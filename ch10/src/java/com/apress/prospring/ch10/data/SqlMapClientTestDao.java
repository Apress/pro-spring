/*
 * Created on Aug 24, 2004
 */
package com.apress.prospring.ch10.data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.apress.prospring.ch10.domain.Test;

/**
 * @author janm
 */
public class SqlMapClientTestDao extends SqlMapClientDaoSupport implements TestDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.TestDao#getAll()
	 */
	public List getAll() {
		return getSqlMapClientTemplate().queryForList("getAllTests", null);
	}

	/**
	 * Inserts a new test
	 * 
	 * @param test The test
	 */
	private void insert(Test test) {
		getSqlMapClientTemplate().insert("insertTest", test);
	}
	
	/**
	 * Updates existing test
	 * 
	 * @param test The test to be updated
	 */
	private void update(Test test) {
		getSqlMapClientTemplate().update("updateTest", test);
	}
	
	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.TestDao#save(com.apress.prospring.ch12.domain.Test)
	 */
	public void save(Test test) {
		if (test.getTestId() == 0) {
			insert(test);
		} else {
			update(test);
		}
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.TestDao#delete(int)
	 */
	public void delete(int testId) {
		getSqlMapClientTemplate().delete("deleteTest", new Integer(testId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.TestDao#getById(int)
	 */
	public Test getById(int testId) {
		return (Test)getSqlMapClientTemplate().queryForObject("getTestById", new Integer(testId));
	}

	public List getByNameAndRunDateMap(String name, Date runDate) {
		Map params = new HashMap();
		params.put("name", name);
		params.put("runDate", runDate);
		return getSqlMapClientTemplate().queryForList("getTestsByNameAndRunDateMap", params);
	}

	public List getByNameAndRunDateDO(String name, Date runDate) {
		Test test = new Test();
		test.setName(name);
		test.setRunDate(runDate);
		return getSqlMapClientTemplate().queryForList("getTestsByNameAndRunDateDO", test);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.TestDao#getByNameAndRunDate(java.lang.String, java.util.Date)
	 */
	public List getByNameAndRunDate(String name, Date runDate) {
		return getByNameAndRunDateMap(name, runDate); 
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.ch12.data.TestDao#updateName(int, java.lang.String)
	 */
	public void updateName(int testId, String name) {
		
		Map params = new HashMap();
		params.put("testId", new Integer(testId));
		params.put("name", name);
		
		getSqlMapClientTemplate().update("updateTestNameMap", params);
		
		/*Test test = new Test();
		test.setTestId(testId);
		test.setName(name);
		getSqlMapClientTemplate().update("updateTestNameDO", test);*/
	}

}