/*
 * Created on Jul 26, 2004
 */
package com.apress.prospring.business;

import java.util.List;

import com.apress.prospring.domain.Attachment;
import com.apress.prospring.domain.Comment;
import com.apress.prospring.domain.Entry;
import com.apress.prospring.domain.User;

/**
 * @author robh
 */
public interface BlogManager {

    public User login(String username, String password)
            throws InvalidCredentialsException;

    public List getMostRecentEntries();

    public List getAllEntries();

    public Entry getEntry(int entryId);

    public void saveEntry(Entry entry, User user);

    public void saveComment(Comment comment, User postingUser);
    
    public List getEntryAttachments(int entryId);
    
    public void attachToEntry(Attachment attachment, int entryId);
    
    public void attachToComment(Attachment attachment, int commentId);

	/**
	 * Deletes an existing entry identified by entryId
	 * 
	 * @param entryId Entry identity
	 */
	public void deleteEntry(int entryId, User user);

	/**
	 * Returns a Comment object identified by commentId
	 * 
	 * @param commentId Comment identity
	 * @return Comment object
	 */
	public Comment getComment(int commentId);

	/**
	 * Deletes Comment identified by commentId
	 * 
	 * @param commentId Comment identity
	 */
	public void deleteComment(int commentId, User user);

	/**
	 * Returns a List of all User objects
	 * 
	 * @return List of Users
	 */
	public List getAllUsers();

	/**
	 * Gets the attachment by its identity
	 * 
	 * @param attachmentId The attachment identity
	 * @return Attachment object
	 */
	public Attachment getAttachment(int attachmentId);
}