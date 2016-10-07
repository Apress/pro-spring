/*
 * Created on 24-Jul-2004
 */
package com.apress.prospring.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import com.apress.prospring.data.AuditDao;
import com.apress.prospring.domain.Audit;

/**
 * @author janm
 */
public abstract class JdbcAbstractAuditDao extends JdbcDaoSupport implements AuditDao, InitializingBean {

	// SQL Statements
	private static final String SELECT_ALL_SQL = "select * from Audit order by AuditDate desc";
	private static final String INSERT_SQL = "insert into Audit (User, AuditDate, Data) values (?, ?, ?)";
	private static final String PURGE_SQL = "delete from Audit where AuditDate <= ?";

	/**
	 * Returns SQL command to retrieve identity
	 * 
	 * @return SQL command
	 */
	protected abstract String getIdentitySql();

	// Inner classes

	/**
	 * Base Select class. 
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
			Audit audit = new Audit();

			audit.setAuditDate(rs.getTimestamp("AuditDate"));
			audit.setAuditId(rs.getInt("AuditId"));
			audit.setData(rs.getString("Data"));
			audit.setUser(new Integer(rs.getInt("User")));
			if (rs.wasNull()) audit.setUser(null);

			return audit;
		}
	}

	class Purge extends SqlUpdate {
		public Purge(DataSource dataSource) {
			super(dataSource, PURGE_SQL);
			declareParameter(new SqlParameter(Types.TIMESTAMP));	// oldestDate
		}
	}
	
	/**
	 * Selects all audit records
	 */
	class SelectAll extends AbstractSelect {

		public SelectAll(DataSource dataSource) {
			super(dataSource, SELECT_ALL_SQL);
		}
	}

	/**
	 * Inserts new audit record
	 */
	class Insert extends SqlUpdate {

		public Insert(DataSource dataSource) {
			super(dataSource, INSERT_SQL);

			declareParameter(new SqlParameter(Types.INTEGER)); // User
			declareParameter(new SqlParameter(Types.TIMESTAMP)); // AuditDate
			declareParameter(new SqlParameter(Types.VARCHAR)); // Data
		}
	}

	/**
	 * Sets identity
	 * 
	 * @param audit Audit object
	 */
	protected void retrieveIdentity(final Audit audit) {
		audit.setAuditId(getJdbcTemplate().queryForInt(getIdentitySql()));
	}

	// Fields
	private SelectAll selectAll;
	private Insert insert;
	private Purge purge;

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.support.JdbcDaoSupport#initDao()
	 */
	protected void initDao() throws Exception {
		super.initDao();
		selectAll = new SelectAll(getDataSource());
		insert = new Insert(getDataSource());
		purge = new Purge(getDataSource());
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AuditDao#getAll()
	 */
	public List getAll() {
		return selectAll.execute();
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AuditDao#insert(com.apress.prospring.domain.Audit)
	 */
	public void insert(Audit audit) {
		Object[] values = new Object[] { audit.getUser(), audit.getAuditDate(), audit.getData()};
		insert.update(values);
		retrieveIdentity(audit);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AuditDao#purge(java.util.Date)
	 */
	public void purge(Date oldestDate) {
		purge.update(new Object[] { oldestDate });
	}
}