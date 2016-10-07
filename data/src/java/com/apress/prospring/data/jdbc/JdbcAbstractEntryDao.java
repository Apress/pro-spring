/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import com.apress.prospring.data.AttachmentDao;
import com.apress.prospring.data.CommentDao;
import com.apress.prospring.data.EntryDao;
import com.apress.prospring.domain.Attachment;
import com.apress.prospring.domain.Comment;
import com.apress.prospring.domain.Entry;

/**
 * @author janm
 */
public abstract class JdbcAbstractEntryDao extends JdbcDaoSupport implements
        EntryDao, InitializingBean {

    // Static SQL statements

    private static final String SELECT_ALL_SQL = "select e.* from Entries e order by e.PostDate desc";

    private static final String SELECT_BY_ID_SQL = "select e.* from Entries e where e.EntryId=?";

    private static final String SELECT_ALL_LIMIT_SQL = "select e.* from Entries e order by e.PostDate desc limit ?";

    private static final String DELETE_SQL = "delete from Entries where EntryId=?";

    private static final String UPDATE_SQL = "update Entries set Subject=?, Body=?, PostDate=? where EntryId=?";

    private static final String INSERT_SQL = "insert into Entries (Subject, Body, PostDate) values (?, ?, ?)";

    private CommentDao commentDao;

    private AttachmentDao attachmentDao;

    /**
     * Returns SQL command to retrieve identity
     * 
     * @return SQL command
     */
    protected abstract String getIdentitySql();

    /**
     * Sets identity
     * 
     * @param entry
     *            Entry object
     */
    protected void retrieveIdentity(final Entry entry) {
        entry.setEntryId(getJdbcTemplate().queryForInt(getIdentitySql()));
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public void setAttachmentDao(AttachmentDao attachmentDao) {
        this.attachmentDao = attachmentDao;
    }

    // Select classes

    abstract class AbstractSelect extends MappingSqlQuery {

        /**
         * Creates new instance of AbstractSelect
         * 
         * @param dataSource
         *            DataSource to be used for the query
         * @param sql
         *            Query code
         */
        public AbstractSelect(DataSource dataSource, String sql) {
            super(dataSource, sql);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.springframework.jdbc.object.MappingSqlQuery#mapRow(java.sql.ResultSet,
         *      int)
         */
        protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Entry entry = new Entry();

            entry.setBody(rs.getString("Body"));
            entry.setEntryId(rs.getInt("EntryId"));
            entry.setPostDate(rs.getTimestamp("PostDate"));
            entry.setSubject(rs.getString("Subject"));

            return entry;
        }

    }

    /**
     * Select all entries ordered by date
     */
    class SelectAll extends AbstractSelect {

        public SelectAll(DataSource dataSource) {
            super(dataSource, SELECT_ALL_SQL);
        }
    }

    /**
     * Select entry by identity
     */
    class SelectById extends AbstractSelect {

        public SelectById(DataSource dataSource) {
            super(dataSource, SELECT_BY_ID_SQL);
            declareParameter(new SqlParameter(Types.INTEGER)); // EntryId
        }
    }

    /**
     * Selects max entries
     */
    class SelectAllLimit extends AbstractSelect {

        public SelectAllLimit(DataSource dataSource) {
            super(dataSource, SELECT_ALL_LIMIT_SQL);
            declareParameter(new SqlParameter(Types.INTEGER)); // Limit
        }
    }

    /**
     * Inserts new entry
     */
    class Insert extends SqlUpdate {

        public Insert(DataSource dataSource) {
            super(dataSource, INSERT_SQL);
            declareParameter(new SqlParameter(Types.VARCHAR)); // Subject
            declareParameter(new SqlParameter(Types.VARCHAR)); // Body
            declareParameter(new SqlParameter(Types.TIMESTAMP)); // PostDate
        }
    }

    /**
     * Updates an existing entry
     */
    class Update extends SqlUpdate {

        public Update(DataSource dataSource) {
            super(dataSource, UPDATE_SQL);
            declareParameter(new SqlParameter(Types.VARCHAR)); // Subject
            declareParameter(new SqlParameter(Types.VARCHAR)); // Body
            declareParameter(new SqlParameter(Types.TIMESTAMP)); // PostDate
            declareParameter(new SqlParameter(Types.INTEGER));
        }
    }

    /**
     * Deletes existing entry
     */
    class Delete extends SqlUpdate {

        public Delete(DataSource dataSource) {
            super(dataSource, DELETE_SQL);
            declareParameter(new SqlParameter(Types.INTEGER)); // EntryId
        }
    }

    // Fields
    private SelectAll selectAll;

    private SelectById selectById;

    private SelectAllLimit selectAllLimit;

    private Delete delete;

    private Update update;

    private Insert insert;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.support.JdbcDaoSupport#initDao()
     */
    protected void initDao() throws Exception {
        super.initDao();

        selectAll = new SelectAll(getDataSource());
        selectById = new SelectById(getDataSource());
        selectAllLimit = new SelectAllLimit(getDataSource());
        insert = new Insert(getDataSource());
        update = new Update(getDataSource());
        delete = new Delete(getDataSource());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.apress.prospring.data.EntryDao#getAll()
     */
    public List getAll() {
        return selectAll.execute();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.apress.prospring.data.EntryDao#save(com.apress.prospring.domain.Entry)
     */
    public void save(Entry entry) {
        if (entry.getEntryId() == 0)
            insert(entry);
        else
            update(entry);
    }

    /**
     * Insets an Entry
     * 
     * @param entry
     *            the Entry
     */
    private void insert(Entry entry) {
        Object[] values = new Object[] { entry.getSubject(), entry.getBody(),
                entry.getPostDate() };
        insert.update(values);
        retrieveIdentity(entry);

    }

    /**
     * Updates an Entry
     * 
     * @param entry
     *            the Entry
     */
    private void update(Entry entry) {
        Object[] values = new Object[] { entry.getSubject(), entry.getBody(),
                entry.getPostDate(), new Integer(entry.getEntryId()) };
        update.update(values);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.apress.prospring.data.EntryDao#delete(int)
     */
    public void delete(int entryId) {
        delete.update(entryId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.apress.prospring.data.EntryDao#getById(int)
     */
    public Entry getById(int entryId) {
        Entry e = (Entry) selectById.findObject(entryId);
        e.setComments(new HashSet<Comment>());
        e.setAttachments(new HashSet<Attachment>());
        e.getComments().addAll(commentDao.getByEntry(e.getEntryId()));
        e.getAttachments().addAll(attachmentDao.getByEntry(e.getEntryId()));
        return e;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.apress.prospring.data.EntryDao#getMostRecent(int)
     */
    public List getMostRecent(int count) {
        return selectAllLimit.execute(count);
    }
}