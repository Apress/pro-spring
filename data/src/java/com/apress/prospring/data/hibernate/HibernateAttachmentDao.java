/*
 * Created on 08-Nov-2004
 */
package com.apress.prospring.data.hibernate;

import java.util.List;

import org.springframework.orm.hibernate.support.HibernateDaoSupport;

import com.apress.prospring.data.AttachmentDao;
import com.apress.prospring.domain.Attachment;

/**
 * @author janm
 */
public class HibernateAttachmentDao extends HibernateDaoSupport implements AttachmentDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#getById(int)
	 */
	public Attachment getById(int attachmentId) {
		return (Attachment)getHibernateTemplate().load(Attachment.class, new Integer(attachmentId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#getByEntry(int)
	 */
	@SuppressWarnings(value={"unchecked"})
	public List<Attachment> getByEntry(int entry) {
		// Not used
		return null;
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#getByComment(int)
	 */
	public List getByComment(int comment) {
		// Not used
		return null;
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#insertEntryAttachment(com.apress.prospring.domain.Attachment, int)
	 */
	public void insertEntryAttachment(Attachment attachment, int entry) {
		// Not used
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#insertCommentAttachment(com.apress.prospring.domain.Attachment, int)
	 */
	public void insertCommentAttachment(Attachment attachment, int comment) {
		// Not used
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#delete(int)
	 */
	public void delete(int attachmentId) {
		Attachment a = new Attachment();
		a.setAttachmentId(attachmentId);
		getHibernateTemplate().delete(a);
	}

}
