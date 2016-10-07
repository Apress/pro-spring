/*
 * Created on 24-Jul-2004
 */
package com.apress.prospring.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import com.apress.prospring.data.AttachmentDao;
import com.apress.prospring.domain.Attachment;

/**
 * Attachment DAO JDBC implementation
 * 
 * @author janm
 */
public abstract class JdbcAbstractAttachmentDao extends JdbcDaoSupport implements AttachmentDao, InitializingBean {
	
	// SQL statements
	private static final String SELECT_BY_ID_SQL = "select * from Attachments where AttachmentId=?";
	private static final String SELECT_BY_ENTRY_SQL = "select a.AttachmentId, a.FileName, a.ContentType, null as FileData from EntryAttachments ea inner join Attachments a on a.AttachmentId = ea.Attachment where ea.Entry = ?";
	private static final String SELECT_BY_COMMENT_SQL = "select a.AttachmentId, a.FileName, a.ContentType, null as FileData from CommentAttachments ca inner join Attachments a on a.AttachmentId = ca.Attachment where ca.Comment = ?";
	
	private static final String INSERT_SQL = "insert into Attachments (FileName, ContentType, FileData) values (?, ?, ?)";
	private static final String INSERT_ENTRY_SQL = "insert into EntryAttachments (Attachment, Entry) values (?, ?)";
	private static final String INSERT_COMMENT_SQL = "insert into CommentAttachments (Attachment, Comment) values (?, ?)";
	
	private static final String DELETE_SQL = "delete from Attachments where AttachmentId=?";
	
	// Inner classes
	
	/**
	 * Base abstract select class. 
	 */
	abstract class AbstractSelect extends MappingSqlQuery {

		/**
		 * Creates new instance of AbstractSelect
		 * 
		 * @param dataSource DataSource to be used for the query
		 * @param sql Query code
		 */
		public AbstractSelect(DataSource dataSource, String sql) {
			super(dataSource, sql);
		}
		
		/* (non-Javadoc)
		 * @see org.springframework.jdbc.object.MappingSqlQuery#mapRow(java.sql.ResultSet, int)
		 */
		protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Attachment attachment = new Attachment();
	
			attachment.setAttachmentId(rs.getInt("AttachmentId"));
			attachment.setContentType(rs.getString("ContentType"));
			attachment.setFileData(rs.getBytes("FileData"));
			attachment.setFileName(rs.getString("FileName"));
			
			return attachment;
		}
	}
	
	/**
	 * Selects attachment identified by the primary key
	 */
	class SelectById extends AbstractSelect {
		public SelectById(DataSource dataSource) {
			super(dataSource, SELECT_BY_ID_SQL);
			declareParameter(new SqlParameter(Types.INTEGER));
		}
	}
	
	/**
	 * Selects attachments identified by entry
	 */
	class SelectByEntry extends AbstractSelect {
		public SelectByEntry(DataSource dataSource) {
			super(dataSource, SELECT_BY_ENTRY_SQL);
			declareParameter(new SqlParameter(Types.INTEGER));
		}
	}

	/**
	 * Selects attachments identified by comment
	 */
	class SelectByComment extends AbstractSelect {
		public SelectByComment(DataSource dataSource) {
			super(dataSource, SELECT_BY_COMMENT_SQL);
			declareParameter(new SqlParameter(Types.INTEGER));
		}
	}
	
	/**
	 * Inserts new attachment
	 */
	class Insert extends SqlUpdate {
		public Insert(DataSource dataSource) {
			super(dataSource, INSERT_SQL);
			declareParameter(new SqlParameter(Types.VARCHAR));	// FileName
			declareParameter(new SqlParameter(Types.VARCHAR));	// ContentType
			declareParameter(new SqlParameter(Types.BINARY));		// FileData
		}
	}
	
	/**
	 * Inserts record to EntryAttachments
	 */
	class InsertEntry extends SqlUpdate {
		public InsertEntry(DataSource dataSource) {
			super(dataSource, INSERT_ENTRY_SQL);
			declareParameter(new SqlParameter(Types.INTEGER));	// Attachment
			declareParameter(new SqlParameter(Types.INTEGER));	// Entry
		}
	}

	/**
	 * Inserts record to EntryComments
	 */
	class InsertComment extends SqlUpdate {
		public InsertComment(DataSource dataSource) {
			super(dataSource, INSERT_COMMENT_SQL);
			declareParameter(new SqlParameter(Types.INTEGER));	// Attachment
			declareParameter(new SqlParameter(Types.INTEGER));	// Comment
		}
	}
	
	/**
	 * Deletes existing attachment
	 */
	class Delete extends SqlUpdate {
		public Delete(DataSource dataSource) {
			super(dataSource, DELETE_SQL);
			declareParameter(new SqlParameter(Types.INTEGER));	// AttachmentId
		}
	}
	
	/**
	 * Returns SQL command to retrieve identity
	 * 
	 * @return SQL command
	 */
	protected abstract String getIdentitySql();
	
	
	/**
	 * Sets identity
	 * 
	 * @param attachment Attachment object
	 */
	protected void retrieveIdentity(final Attachment attachment) {
		attachment.setAttachmentId(getJdbcTemplate().queryForInt(getIdentitySql()));
	}
	
	// Fields
	private SelectByComment selectByComment;
	private SelectByEntry selectByEntry;
	private SelectById selectById;
	private Insert insert;
	private InsertComment insertComment;
	private InsertEntry insertEntry;
	private Delete delete;
	
	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.support.JdbcDaoSupport#initDao()
	 */
	protected void initDao() throws Exception {
		selectByComment = new SelectByComment(getDataSource());
		selectByEntry = new SelectByEntry(getDataSource());
		selectById = new SelectById(getDataSource());
		insert = new Insert(getDataSource());
		insertComment = new InsertComment(getDataSource());
		insertEntry = new InsertEntry(getDataSource());
		delete = new Delete(getDataSource());
	}
	
	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#getById(int)
	 */
	public Attachment getById(int attachmentId) {
		return (Attachment)selectById.findObject(attachmentId);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#getByEntry(int)
	 */
	@SuppressWarnings(value={"unchecked"})
	public List<Attachment> getByEntry(int entry) {
		return selectByEntry.execute(entry);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#getByComment(int)
	 */
	public List getByComment(int comment) {
		return selectByComment.execute(comment);
	}
	

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#insertEntryAttachment(com.apress.prospring.domain.Attachment, int)
	 */
	public void insertEntryAttachment(Attachment attachment, int entry) {
		Object[] values = new Object[] { attachment.getFileName(), attachment.getContentType(), attachment.getFileData() };
		insert.update(values);
		retrieveIdentity(attachment);
		insertEntry.update(attachment.getAttachmentId(), entry);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#insertCommentAttachment(com.apress.prospring.domain.Attachment, int)
	 */
	public void insertCommentAttachment(Attachment attachment, int comment) {
		Object[] values = new Object[] { attachment.getFileName(), attachment.getContentType(), attachment.getFileData() };
		insert.update(values);
		retrieveIdentity(attachment);
		insertComment.update(attachment.getAttachmentId(), comment);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#delete(int)
	 */
	public void delete(int attachmentId) {
		delete.update(attachmentId);
	}
		
}
