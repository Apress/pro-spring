/*
 * Created on Jul 26, 2004
 */
package com.apress.prospring.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import com.apress.prospring.domain.Attachment;
import com.apress.prospring.domain.Comment;
import com.apress.prospring.domain.Entry;
import com.apress.prospring.domain.User;

/**
 * @author robh
 */
public class DefaultBlogManager extends AbstractDaoBasedBlogManager implements
        InitializingBean {

    private AuditService auditService;

    public void afterPropertiesSet() throws Exception {
        if (auditService == null) {
            auditService = new DefaultAuditService();
        }
    }

    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    public User login(String username, String password)
            throws InvalidCredentialsException {
        User user = userDao.getByUsernameAndPassword(username, password);

        if (user == null) {
            throw new InvalidCredentialsException(
                    "The credentials you supplied do not match a known user profile. Try again");
        } else {
            return user;
        }
    }

    public List getMostRecentEntries() {
        return entryDao.getMostRecent(100);
    }

    public List getAllEntries() {
        return entryDao.getAll();
    }

    public Entry getEntry(int entryId) {
        Entry entry = entryDao.getById(entryId);
        // entry.setAttachments(attachmentDao.getByEntry(entryId));
        
        return entry;
    }

    public void deleteEntry(int entryId, User user) {
        entryDao.delete(entryId);
        auditService.writeAuditMessage("Entry Id " + entryId + " deleted.",
                user);
    }

    public void saveEntry(Entry entry, User user) {

        if (entry.getEntryId() <= 0) {
            // new entry - make sure 
            // post date is set
            entry.setPostDate(new Date());
        }

        entryDao.save(entry);
        auditService.writeAuditMessage("Entry " + entry + " saved", user);
    }

    public void saveComment(Comment comment, User postingUser) {
        comment.setPostedBy(postingUser);

        if (comment.getCommentId() <= 0) {
            // this is a new comment
            comment.setPostDate(new Date());
        }

        commentDao.save(comment);
        auditService.writeAuditMessage("Comment " + comment + " saved.",
                postingUser);
    }

    public List getEntryAttachments(int entryId) {
        return attachmentDao.getByEntry(entryId);
    }

    public void attachToEntry(Attachment attachment, int entryId) {
        attachmentDao.insertEntryAttachment(attachment, entryId);
    }

    public void attachToComment(Attachment attachment, int commentId) {
        attachmentDao.insertCommentAttachment(attachment, commentId);
    }

    public Comment getComment(int commentId) {
        Comment comment = commentDao.getById(commentId);
        // comment.setAttachments(attachmentDao.getByComment(commentId));
        
        return comment;
    }

    public void deleteComment(int commentId, User user) {
        commentDao.delete(commentId);
        auditService.writeAuditMessage("Comment: " + commentId + " deleted.",
                user);
    }

    public List getAllUsers() {
        return userDao.getAll();
    }

	/* (non-Javadoc)
	 * @see com.apress.prospring.business.BlogManager#getAttachment(int)
	 */
	public Attachment getAttachment(int attachmentId) {
		return attachmentDao.getById(attachmentId);
	}

}