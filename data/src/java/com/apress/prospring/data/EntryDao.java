/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.data;

import java.util.List;

import com.apress.prospring.domain.Entry;


/**
 * @author janm
 */
public interface EntryDao {

	/**
	 * Gets a List of all Entries
	 * 
	 * @return List of Entry objects
	 */
	public List getAll();
	    
	/**
	 * Saves an Entry object
	 * 
	 * @param entry Entry to be saved
	 */
	public void save(Entry entry);
	
	/**
	 * Deletes an Entry identified by entryId
	 * 
	 * @param entryId Entry identity
	 */
	public void delete(int entryId);
	
	/**
	 * Returns Entry identified by entryId
	 * 
	 * @param entryId Entry identity
	 * @return Entry object
	 */
	public Entry getById(int entryId);

	/**
	 * Returns up to <code>count</code> of the most recent entries
	 * 
	 * @param count Maximum number of Entry objects to return
	 * @return List of Entry objects
	 */
	public List getMostRecent(int count);
}
