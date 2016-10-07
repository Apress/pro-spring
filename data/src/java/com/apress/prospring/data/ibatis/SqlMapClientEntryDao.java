/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.data.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.apress.prospring.data.EntryDao;
import com.apress.prospring.domain.Entry;

/**
 * @author janm
 */
public class SqlMapClientEntryDao extends SqlMapClientDaoSupport implements EntryDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.EntryDao#getAll()
	 */
	public List getAll() {
		return getSqlMapClientTemplate().queryForList("getAllEntries", null);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.EntryDao#save(com.apress.prospring.domain.Entry)
	 */
	public void save(Entry entry) {
		if (entry.getEntryId() == 0)
			insert(entry);
		else
			update(entry);
	}

	/**
	 * Inserts an Entry
	 * 
	 * @param entry The entry
	 */
	private void insert(Entry entry) {
		getSqlMapClientTemplate().insert("insertEntry", entry);
	}

	/**
	 * Updates an Entry
	 * 
	 * @param entry The entry
	 */
	private void update(Entry entry) {
		getSqlMapClientTemplate().update("updateEntry", entry);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.EntryDao#delete(int)
	 */
	public void delete(int entryId) {
		getSqlMapClientTemplate().delete("deleteEntry", new Integer(entryId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.EntryDao#getById(int)
	 */
	public Entry getById(int entryId) {
		return (Entry)getSqlMapClientTemplate().queryForObject("getEntryById", new Integer(entryId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.EntryDao#getMostRecent(int)
	 */
	public List getMostRecent(int count) {
		return getSqlMapClientTemplate().queryForList("getAllEntries", null);
	}
}