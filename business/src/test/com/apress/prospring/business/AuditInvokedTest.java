/*
 * Created on Sep 16, 2004
 */
package com.apress.prospring.business;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import com.apress.prospring.data.CommentDao;
import com.apress.prospring.data.EntryDao;
import com.apress.prospring.domain.Comment;
import com.apress.prospring.domain.Entry;
import com.apress.prospring.domain.User;

/**
 * @author robh
 */
public class AuditInvokedTest extends TestCase {

	private DefaultBlogManager bm = new DefaultBlogManager();

	private CommentDao commentDao = new MockCommentDao();

	private EntryDao entryDao = new MockEntryDao();

	private MockAuditService auditService;

	public AuditInvokedTest() {
		bm.setCommentDao(commentDao);
		bm.setEntryDao(entryDao);
	}

	public void setUp() {
		auditService = new MockAuditService();
		bm.setAuditService(auditService);
	}

	public void testSaveEntry() {
		bm.saveEntry(new Entry(), null);
		performAssert();
	}

	public void testSaveComment() {
		bm.saveComment(new Comment(), new User());
		performAssert();
	}

	private void performAssert() {
		assertEquals("The Audit Service was not invoked", 1, auditService.callCount);
	}

	private class MockAuditService implements AuditService {

		private int callCount = 0;

		public void writeAuditMessage(String data, User user) {
			callCount++;
		}

		public void purgeAudit(Date oldestDate) {

		}

		public int getCallCount() {
			return callCount;
		}

		/* (non-Javadoc)
		 * @see com.apress.prospring.business.AuditService#getAllAuditEntries()
		 */
		public List getAllAuditEntries() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	private class MockCommentDao implements CommentDao {

		public List<Comment> getByEntry(int entry) {

			return null;
		}

		public Comment getById(int commentId) {

			return null;
		}

		public void save(Comment comment) {

		}

		public void delete(int commentId) {

		}

	}

	private class MockEntryDao implements EntryDao {

		public List getAll() {
			return null;
		}

		public void save(Entry entry) {

		}

		public void delete(int entryId) {

		}

		public Entry getById(int entryId) {
			return null;
		}

		public List getMostRecent(int count) {
			return null;
		}

	}

}