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

import com.apress.prospring.data.UserDao;
import com.apress.prospring.domain.User;

/**
 * @author janm
 */
public abstract class JdbcAbstractUserDao extends JdbcDaoSupport implements UserDao, InitializingBean {

	// Static SQL Statements
	private static final String SELECT_BY_USERNAME_PASSWORD_SQL = "select * from Users where Username=? and Password=?";
	private static final String SELECT_ALL_SQL = "select * from Users order by Username";
	private static final String INSERT_SQL = "insert into Users (Username, Password, Email, Type) values (?, ?, ?, ?)";
	private static final String UPDATE_SQL = "update Users set Username=?, Password=?, Email=?, Type=? where UserId=?";
	private static final String DELETE_SQL = "delete from Users where UserId=?";

	// Inner classes

	/**
	 * Base select class
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
			User user = new User();

			user.setEmail(rs.getString("Email"));
			user.setPassword(rs.getString("Password"));
			user.setType(rs.getInt("Type"));
			user.setUserId(rs.getInt("UserId"));
			user.setUsername(rs.getString("Username"));

			return user;
		}
	}

	/**
	 * Selects user by username and password
	 */
	class SelectByUsernameAndPassword extends AbstractSelect {

		public SelectByUsernameAndPassword(DataSource dataSource) {
			super(dataSource, SELECT_BY_USERNAME_PASSWORD_SQL);
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.VARCHAR));
		}
	}

	/**
	 * Selects all users
	 */
	class SelectAll extends AbstractSelect {

		public SelectAll(DataSource dataSource) {
			super(dataSource, SELECT_ALL_SQL);
		}
	}

	/**
	 * Inserts a new user
	 */
	class Insert extends SqlUpdate {

		public Insert(DataSource dataSource) {
			super(dataSource, INSERT_SQL);
			declareParameter(new SqlParameter(Types.VARCHAR)); // Username
			declareParameter(new SqlParameter(Types.VARCHAR)); // Password
			declareParameter(new SqlParameter(Types.VARCHAR)); // Email
			declareParameter(new SqlParameter(Types.INTEGER)); // UserType
		}
	}

	/**
	 * Updates existing user
	 */
	class Update extends SqlUpdate {

		public Update(DataSource dataSource) {
			super(dataSource, UPDATE_SQL);
			declareParameter(new SqlParameter(Types.VARCHAR)); // Username
			declareParameter(new SqlParameter(Types.VARCHAR)); // Password
			declareParameter(new SqlParameter(Types.VARCHAR)); // Email
			declareParameter(new SqlParameter(Types.INTEGER)); // UserType

			declareParameter(new SqlParameter(Types.INTEGER)); // UserId
		}
	}

	/**
	 * Deletes existing user
	 */
	class Delete extends SqlUpdate {

		public Delete(DataSource dataSource) {
			super(dataSource, DELETE_SQL);
			declareParameter(new SqlParameter(Types.INTEGER)); // UserId
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
	 * @param user User object
	 */
	protected void retrieveIdentity(final User user) {
		user.setUserId(getJdbcTemplate().queryForInt(getIdentitySql()));
	}

	/**
	 * Insets a new User
	 * 
	 * @param user The user
	 */
	private void insert(User user) {
		Object[] values = new Object[] { user.getUsername(), user.getPassword(), user.getEmail(),
				new Integer(user.getType())};
		insert.update(values);
		retrieveIdentity(user);
	}

	/**
	 * Updates an existing user
	 * 
	 * @param user The user
	 */
	public void update(User user) {
		Object[] values = new Object[] { user.getUsername(), user.getPassword(), user.getEmail(),
				new Integer(user.getType()), new Integer(user.getUserId())};
		update.update(values);
	}

	// Fields
	private SelectByUsernameAndPassword selectByUsernameAndPassword;
	private SelectAll selectAll;
	private Insert insert;
	private Update update;
	private Delete delete;

	protected void initDao() throws Exception {
		selectByUsernameAndPassword = new SelectByUsernameAndPassword(getDataSource());
		selectAll = new SelectAll(getDataSource());
		insert = new Insert(getDataSource());
		update = new Update(getDataSource());
		delete = new Delete(getDataSource());
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#getByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	public User getByUsernameAndPassword(String username, String password) {
		Object[] values = new Object[] { username, password};
		return (User)selectByUsernameAndPassword.findObject(values);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#save(com.apress.prospring.domain.User)
	 */
	public void save(User user) {
		if (user.getUserId() == 0)
			insert(user);
		else
			update(user);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#delete(int)
	 */
	public void delete(int userId) {
		delete.update(userId);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.UserDao#getAll()
	 */
	public List getAll() {
		return selectAll.execute();
	}
}