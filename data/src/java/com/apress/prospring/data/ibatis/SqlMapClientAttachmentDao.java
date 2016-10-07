/*
 * Created on 24-Jul-2004
 */
package com.apress.prospring.data.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.apress.prospring.data.AttachmentDao;
import com.apress.prospring.domain.Attachment;


/**
 * @author janm
 */
public class SqlMapClientAttachmentDao extends SqlMapClientDaoSupport implements AttachmentDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#getById(int)
	 */
	public Attachment getById(int attachmentId) {
		return (Attachment)getSqlMapClientTemplate().queryForObject("getAttachmentById", new Integer(attachmentId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#getByEntry(int)
	 */
	@SuppressWarnings(value={"unchecked"})
	public List<Attachment> getByEntry(int entry) {
		return getSqlMapClientTemplate().queryForList("getAttachmentByEntry", new Integer(entry));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#getByComment(int)
	 */
	public List getByComment(int comment) {
		return getSqlMapClientTemplate().queryForList("getAttachmentByComment", new Integer(comment));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#insertEntryAttachment(com.apress.prospring.domain.Attachment, int)
	 */
	public void insertEntryAttachment(Attachment attachment, int entry) {
		getSqlMapClientTemplate().insert("insertAttachment", attachment);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("attachment", new Integer(attachment.getAttachmentId()));
		params.put("entry", new Integer(entry));
		getSqlMapClientTemplate().insert("insertAttachmentEntry", params);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#insertCommentAttachment(com.apress.prospring.domain.Attachment, int)
	 */
	public void insertCommentAttachment(Attachment attachment, int comment) {
		getSqlMapClientTemplate().insert("insertAttachment", attachment);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("attachment", new Integer(attachment.getAttachmentId()));
		params.put("comment", new Integer(comment));
		getSqlMapClientTemplate().insert("insertAttachmentComment", params);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.AttachmentDao#delete(int)
	 */
	public void delete(int attachmentId) {
		getSqlMapClientTemplate().delete("deleteAttachment", new Integer(attachmentId));
	}

}
