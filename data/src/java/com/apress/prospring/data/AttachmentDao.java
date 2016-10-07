/*
 * Created on 24-Jul-2004
 */
package com.apress.prospring.data;

import java.util.List;

import com.apress.prospring.domain.Attachment;


/**
 * @author janm
 */
public interface AttachmentDao {

	/**
	 * Gets Attachment identified by attachmentId
	 * 
	 * @param attachmentId Attachment identity
	 * @return Attachment object with FileData set to the file data
	 */
	public Attachment getById(int attachmentId);

	/**
	 * Gets List of Attachments identified by entry
	 * 
	 * @param entry Entry identity
	 * @return List of Attachments with FileData set to null
	 */
	public List<Attachment> getByEntry(int entry);
	
	/**
	 * Gets List of Attachments identified by comment
	 * 
	 * @param comment Comment identity
	 * @return List of Attachments with FileData set to null
	 */
	public List getByComment(int comment);
	
	/**
	 * Inserts an attachment record and associates it with Entry
	 * 
	 * @param attachment Attachment to be inserted
	 * @param entry Entry to associate this attachment with
	 */
	public void insertEntryAttachment(Attachment attachment, int entry);
	
	/**
	 * Inserts an attachment record and associates it with Comment
	 * 
	 * @param attachment Attachment to be inserted
	 * @param comment Comment to associate this attachment with
	 */
	public void insertCommentAttachment(Attachment attachment, int comment);
	
	/**
	 * Deletes Attachment identified by attachmentId
	 * 
	 * @param attachmentId Attachment identity
	 */
	public void delete(int attachmentId);
}
