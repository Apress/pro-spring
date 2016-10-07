/*
 * Created on 19-Jul-2004
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

import com.apress.prospring.data.CommentDao;
import com.apress.prospring.domain.Comment;
import com.apress.prospring.domain.User;

/**
 * @author janm
 */
public abstract class JdbcAbstractCommentDao extends JdbcDaoSupport implements CommentDao, InitializingBean {

	// Static SQL statements
	private static final String SELECT_BY_ID_SQL = "select c.*, u.* from Comments c inner join Users u on u.UserId = c.PostedBy where c.CommentId = ?";
	private static final String SELECT_BY_ENTRY_SQL = "select c.*, u.* from Comments c inner join Users u on u.UserId = c.PostedBy where c.Entry = ? order by c.PostDate desc";
	private static final String INSERT_SQL = "insert into Comments (Subject, Body, PostDate, Entry, ReplyTo, PostedBy) values (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_SQL = "update Comments set Subject=?, Body=?, PostDate=?, Entry=?, ReplyTo=?, PostedBy=? where CommentId=?";
	private static final String DELETE_SQL = "delete from Comments where CommentId = ?";

	/**
	 * Returns SQL command to retrieve identity
	 * 
	 * @return SQL command
	 */
	protected abstract String getIdentitySql();

	// Inner classes

	/**
	 * Base abstract select class. The result set must include all fields from Comment and User tables.
	 * This would usually be in form of SELECT c.*, u.* FROM Comments c, Users u ...
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
			Comment comment = new Comment();

			comment.setBody(rs.getString("Body"));
			comment.setCommentId(rs.getInt("CommentId"));
			comment.setPostDate(rs.getTimestamp("PostDate"));
			comment.setReplyTo(new Integer(rs.getInt("ReplyTo")));
			if (rs.wasNull()) comment.setReplyTo(null);
			comment.setEntry(rs.getInt("Entry"));
			comment.setSubject(rs.getString("Subject"));

			User user = new User();
			user.setEmail(rs.getString("Email"));
			user.setPassword(rs.getString("Password"));
			user.setType(rs.getInt("Type"));
			user.setUserId(rs.getInt("UserId"));
			user.setUsername(rs.getString("Username"));

			comment.setPostedBy(user);

			return comment;
		}
	}

	/**
	 * Selects Entry by Entry Id
	 */
	class SelectById extends AbstractSelect {

		public SelectById(DataSource dataSource) {
			super(dataSource, SELECT_BY_ID_SQL);
			declareParameter(new SqlParameter(Types.INTEGER)); // EntryId
		}
	}

	/**
	 * Selects comments by Entry
	 */
	class SelectByEntry extends AbstractSelect {

		public SelectByEntry(DataSource dataSource) {
			super(dataSource, SELECT_BY_ENTRY_SQL);
			declareParameter(new SqlParameter(Types.INTEGER));
		}
	}

	/**
	 * Inserts new comment
	 */
	class Insert extends SqlUpdate {

		public Insert(DataSource dataSource) {
			super(dataSource, INSERT_SQL);
			declareParameter(new SqlParameter(Types.VARCHAR)); // Subject
			declareParameter(new SqlParameter(Types.VARCHAR)); // Body
			declareParameter(new SqlParameter(Types.TIMESTAMP)); // PostDate
			declareParameter(new SqlParameter(Types.INTEGER)); // Entry
			declareParameter(new SqlParameter(Types.INTEGER)); // ReplyTo
			declareParameter(new SqlParameter(Types.INTEGER)); // PostedBy
		}
	}

	/**
	 * Update existing comment
	 */
	class Update extends SqlUpdate {

		public Update(DataSource dataSource) {
			super(dataSource, UPDATE_SQL);
			declareParameter(new SqlParameter(Types.VARCHAR)); // Subject
			declareParameter(new SqlParameter(Types.VARCHAR)); // Body
			declareParameter(new SqlParameter(Types.TIMESTAMP)); // PostDate
			declareParameter(new SqlParameter(Types.INTEGER)); // Entry
			declareParameter(new SqlParameter(Types.INTEGER)); // ReplyTo
			declareParameter(new SqlParameter(Types.INTEGER)); // PostedBy
			declareParameter(new SqlParameter(Types.INTEGER)); // CommentId
		}
	}

	/**
	 * Delete existing comment
	 */
	class Delete extends SqlUpdate {

		public Delete(DataSource dataSource) {
			super(dataSource, DELETE_SQL);
			declareParameter(new SqlParameter(Types.INTEGER));
		}
	}

	/**
	 * Inserts a comment
	 * 
	 * @param comment The comment
	 */
	private void insert(Comment comment) {
		Object[] values = new Object[] { comment.getSubject(), comment.getBody(), comment.getPostDate(),
				new Integer(comment.getEntry()), comment.getReplyTo(),
				new Integer(comment.getPostedBy().getUserId()) };

		insert.update(values);
		comment.setCommentId(getJdbcTemplate().queryForInt(getIdentitySql(), null));
	}

	/**
	 * Updates a comment
	 * 
	 * @param comment The comment
	 */
	private void update(Comment comment) {
		Object[] values = new Object[] { comment.getSubject(), comment.getBody(), comment.getPostDate(),
				new Integer(comment.getEntry()), comment.getReplyTo(), new Integer(comment.getPostedBy().getUserId()),
				new Integer(comment.getCommentId())};

		update.update(values);
	}

	// Fields

	private SelectById selectById;
	private SelectByEntry selectByEntry;
	private Update update;
	private Insert insert;
	private Delete delete;

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.support.JdbcDaoSupport#initDao()
	 */
	protected void initDao() throws Exception {
		super.initDao();
		selectById = new SelectById(getDataSource());
		selectByEntry = new SelectByEntry(getDataSource());
		update = new Update(getDataSource());
		insert = new Insert(getDataSource());
		delete = new Delete(getDataSource());
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#getByEntry(int)
	 */
	@SuppressWarnings(value={"unchecked"})
	public List<Comment> getByEntry(int entry) {
		return selectByEntry.execute(entry);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#getById(int)
	 */
	public Comment getById(int commentId) {
		return (Comment)selectById.findObject(commentId);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#save(com.apress.prospring.domain.Comment)
	 */
	public void save(Comment comment) {
		if (comment.getCommentId() == 0)
			insert(comment);
		else
			update(comment);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#delete(int)
	 */
	public void delete(int commentId) {
		delete.update(commentId);
	}
}