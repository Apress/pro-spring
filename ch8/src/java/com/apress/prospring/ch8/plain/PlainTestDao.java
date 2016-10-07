/*
 * Created on 31-Jul-2004
 */
package com.apress.prospring.ch8.plain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.apress.prospring.ch8.domain.Test;
import com.apress.prospring.ch8.TestDao;

/**
 * Plain JDBC TestDao implementation
 * 
 * @author janm
 */
public class PlainTestDao implements TestDao {

	static {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ex) {
			// noop
		}
	}
	
	/**
	 * Gets a connection
	 *  
	 * @return Connection object
	 * @throws SQLException if the connection cannot be established
	 */
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/psch10", "janm", "");
	}
	
	/**
	 * Safely closes connection
	 * 
	 * @param connection Connection to close. Can be null.
	 */
	private void closeConnection(Connection connection) {
		if (connection == null) return;
		
		try {
			connection.close();
		} catch (SQLException ex) {
			// noop
		}
	}
	
	/* (non-Javadoc)
	 * @see com.apress.prospring.ch10.TestDao#getAll()
	 */
	public List getAll() {
		List result = new ArrayList();
		
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from Test");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Test test = new Test();
				test.setName(resultSet.getString("Name"));
				test.setTestId(resultSet.getInt("TestId"));
				result.add(test);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch10.TestDao#insert(com.apress.prospring.ch10.domain.Test)
	 */
	public void insert(Test test) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into Test (Name) values (?)");
			statement.setString(1, test.getName());
			statement.execute();
			
			ResultSet generatedKeys = statement.getGeneratedKeys(); 
			if (generatedKeys.next()) {
				test.setTestId(generatedKeys.getInt("TestId"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch10.TestDao#delete(int)
	 */
	public void delete(int testId) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from Test where TestId=?");
			statement.setInt(1, testId);
			statement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch10.TestDao#getByName(java.lang.String)
	 */
	public List getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch10.TestDao#update(com.apress.prospring.ch10.domain.Test)
	 */
	public void update(Test test) {
		// TODO Auto-generated method stub
		
	}
}
