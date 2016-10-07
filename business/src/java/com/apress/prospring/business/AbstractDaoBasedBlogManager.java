/*
 * Created on Jul 26, 2004
 */
package com.apress.prospring.business;

import com.apress.prospring.data.AttachmentDao;
import com.apress.prospring.data.CommentDao;
import com.apress.prospring.data.EntryDao;
import com.apress.prospring.data.UserDao;

/**
 * Provides a base for all BlogManager implementations removing the need to
 * constantly define code to store dependencies
 * 
 * @author robh
 */
public abstract class AbstractDaoBasedBlogManager implements BlogManager {

    protected UserDao userDao;

    protected EntryDao entryDao;

    protected AttachmentDao attachmentDao;

    protected CommentDao commentDao;

    public void setUserDao(UserDao dao) {
        this.userDao = dao;
    }

    public void setEntryDao(EntryDao dao) {
        this.entryDao = dao;
    }

    public void setAttachmentDao(AttachmentDao dao) {
        this.attachmentDao = dao;
    }

    public void setCommentDao(CommentDao dao) {
        this.commentDao = dao;
    }
}