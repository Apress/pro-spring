/*
 * Created on 08-Aug-2004
 */
package com.apress.prospring;

import java.util.Date;

import com.apress.prospring.data.CommentDao;
import com.apress.prospring.domain.Comment;


/**
 * @author janm
 */
public class TestCommentDao extends SpringTestCase {

	private CommentDao getDao() {
		return (CommentDao)getBean("commentDao");
	}
	
	public void testGetBean() {
		assertNotNull(getDao());
	}
	
	/**
	 * Tests Insert/Delete operation
	 *
	 */
	public void testInsertDelete() {
		Comment c = new Comment();
		c.setBody("cb");
		c.setEntry(1);
		c.setPostDate(new Date());
		c.setPostedBy(null);
		c.setReplyTo(null);
		c.setSubject("subj");
	}
}
