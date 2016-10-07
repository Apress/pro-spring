/*
 * Created on 31-Jul-2004
 */
package com.apress.prospring.ch8.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import com.apress.prospring.ch8.TestDao;
import com.apress.prospring.ch8.domain.Test;
import com.apress.prospring.ch8.domain.TestDetail;

/**
 * @author janm
 */
public abstract class JdbcAbstractTestDao extends JdbcDaoSupport implements TestDao {

	private static final String SELECT_BY_NAME_SQL = "select * from Test where Name=?";
	private static final String UPDATE_SQL = "update Test set Name=? where TestId=?";
	private static final String DELETE_SQL = "delete from Test where TestId=?";
	private static final String INSERT_SQL = "insert into Test (Name) values (?)";

	abstract class AbstractSelect extends MappingSqlQuery {

		public AbstractSelect(DataSource dataSource, String sql) {
			super(dataSource, sql);
		}

		protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Test test = new Test();

			test.setName(rs.getString("Name"));
			test.setTestId(rs.getInt("TestId"));

			return test;
		}
	}

	class SelectByName extends AbstractSelect {

		public SelectByName(DataSource dataSource) {
			super(dataSource, SELECT_BY_NAME_SQL);
			declareParameter(new SqlParameter(Types.VARCHAR));
		}
	}
	
	class Update extends SqlUpdate {
		public Update(DataSource dataSource) {
			super(dataSource, UPDATE_SQL);
			declareParameter(new SqlParameter(Types.VARCHAR));	// Name
			declareParameter(new SqlParameter(Types.INTEGER));	// TestId
		}
	}
	
	class Delete extends SqlUpdate {
		public Delete(DataSource dataSource) {
			super(dataSource, DELETE_SQL);
			declareParameter(new SqlParameter(Types.INTEGER));	// TestId
		}
	}

	class Insert extends SqlUpdate {
		public Insert(DataSource dataSource) {
			super(dataSource, INSERT_SQL);
			declareParameter(new SqlParameter(Types.VARCHAR));	// Name
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
	 * @param test The test object
	 */
	protected void retrieveIdentity(final Test test) {
		test.setTestId(getJdbcTemplate().queryForInt(getIdentitySql()));
	}
	
	private SelectByName selectByName;
	private Update update;
	private Delete delete;
	private Insert insert;

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.support.JdbcDaoSupport#initDao()
	 */
	protected void initDao() throws Exception {
		super.initDao();
		selectByName = new SelectByName(getDataSource());
		update = new Update(getDataSource());
		delete = new Delete(getDataSource());
		insert = new Insert(getDataSource());
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch10.TestDao#getByName(java.lang.String)
	 */
	public List getByName(String name) {
		return selectByName.execute(name);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch10.TestDao#getAll()
	 */
	public List getAll() {
		JdbcTemplate jt = new JdbcTemplate(getDataSource());
		
		return (List)jt.execute(
			new PreparedStatementCreator() {

				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					return connection.prepareStatement("select t.*, td.* from Tests t inner join TestDetails td on t.TestId = td.Test");
				}
			 
			}, 
			new PreparedStatementCallback() {

				private int testId = -1;
				
				public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					List result = new ArrayList();
					int lastTestId = -1;
					Test test = null;
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						testId = rs.getInt("TestId");
						if (testId != lastTestId) {
							test = new Test();
							test.setTestId(testId);
							test.setName(rs.getString("Name"));
							test.setDetails(new ArrayList());
						}
						TestDetail td = new TestDetail();
						td.setData(rs.getString("Data"));
						td.setTest(rs.getInt("Test"));
						td.setTestDetailId(rs.getInt("TestDetailId"));
						test.getDetails().add(td);
					}
					return result;
				}
			
			}); 
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch10.TestDao#insert(com.apress.prospring.ch10.domain.Test)
	 */
	public void insert(Test test) {
		insert.update(new Object[] { test.getName() });
		retrieveIdentity(test);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch10.TestDao#delete(int)
	 */
	public void delete(int testId) {
		delete.update(testId);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch10.TestDao#update(com.apress.prospring.ch10.domain.Test)
	 */
	public void update(Test test) {
		update.update(new Object[] { test.getName(), new Integer(test.getTestId()) });
	}

}