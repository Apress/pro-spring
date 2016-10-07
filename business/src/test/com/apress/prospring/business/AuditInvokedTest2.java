/*
 * Created on Sep 16, 2004
 */
package com.apress.prospring.business;

import org.easymock.MockControl;

import junit.framework.TestCase;

import com.apress.prospring.data.CommentDao;
import com.apress.prospring.data.EntryDao;
import com.apress.prospring.domain.Comment;
import com.apress.prospring.domain.Entry;

/**
 * @author janm
 */
public class AuditInvokedTest2 extends TestCase {

	private DefaultBlogManager bm = new DefaultBlogManager();

	private MockControl auditServiceControl;
	private AuditService auditService;

	public void setUp() {
		CommentDao commentDao;
		EntryDao entryDao;

		entryDao = (EntryDao) MockControl.createControl(EntryDao.class).getMock();
		commentDao = (CommentDao) MockControl.createControl(CommentDao.class).getMock();

		auditServiceControl = MockControl.createControl(AuditService.class);
		auditService = (AuditService) auditServiceControl.getMock();

		bm.setAuditService(auditService);
		bm.setCommentDao(commentDao);
		bm.setEntryDao(entryDao);
	}

	public void testSaveEntry() {
		Entry entry = new Entry();
		auditService.writeAuditMessage("Entry " + entry + " saved", null);
		auditServiceControl.replay();
		bm.saveEntry(entry, null);
	}

	public void testSaveComment() {
		Comment comment = new Comment();
		auditService.writeAuditMessage("Comment " + comment + " saved.", null);
		auditServiceControl.replay();
		bm.saveComment(comment, null);
	}

}