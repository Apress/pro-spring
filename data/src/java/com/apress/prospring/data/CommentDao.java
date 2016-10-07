/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.data;

import java.util.List;

import com.apress.prospring.domain.Comment;


/**
 * Comment DAO interface
 * 
 * @author janm
 */
public interface CommentDao {
	
	/**
	 * Returns List of Comment objects identified by entry
	 * 
	 * @param entry Entry identity
	 * @return List of Comments
	 */
	public List<Comment> getByEntry(int entry);
	
	/**
	 * Returns a Comment object identified by primary key
	 * 
	 * @param commentId Comment identity
	 * @return Comment object
	 */
	public Comment getById(int commentId);
	
	/**
	 * Saves a comment
	 * 
	 * @param comment Comment to be saved
	 */
	public void save(Comment comment);
	
	/**
	 * Deletes comment identified by commentId
	 * 
	 * @param commentId Comment identity
	 */
	public void delete(int commentId);
}
