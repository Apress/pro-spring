/*
 * Created on 08-Aug-2004
 */
package com.apress.prospring;

import com.apress.prospring.data.AttachmentDao;


/**
 * @author janm
 */
public class TestAttachmentDao extends SpringTestCase {

	private AttachmentDao getDao() {
		return (AttachmentDao)getBean("attachmentDao");
	}
	
	public void testGetBean() {
		assertNotNull(getDao());
	}
	
	public void testInsert() {
		// getDao().insertCommentAttachment()
	}
	
}
