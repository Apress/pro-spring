/*
 * Created on 24-Jul-2004
 */
package com.apress.prospring.data;

import java.util.Date;
import java.util.List;

import com.apress.prospring.domain.Audit;

/**
 * Audit DAO interface
 * 
 * @author janm
 */
public interface AuditDao {
	
	/**
	 * Returns List of Audit all objects 
	 * @return List of Audits
	 */
	public List getAll();
	
	/**
	 * Inserts new Audit record
	 * 
	 * @param audit Record to be inserted
	 */
	public void insert(Audit audit);
	
	/**
	 * Removes all audit messages older than oldestDate
	 * 
	 * @param oldestDate Oldest audit entry to be kept
	 */
	public void purge(Date oldestDate);
}
