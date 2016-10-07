/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.data.hibernate;

import java.util.List;

import org.springframework.orm.hibernate.support.HibernateDaoSupport;

import com.apress.prospring.data.CommentDao;
import com.apress.prospring.domain.Comment;


/**
 * @author janm
 */
public class HibernateCommentDao extends HibernateDaoSupport implements CommentDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#getByEntry(int)
	 */
	@SuppressWarnings(value={"unchecked"})
	public List<Comment> getByEntry(int entry) {
		return getHibernateTemplate().find("select c from Comment as c where c.entry = :entry", new Integer(entry));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#getById(int)
	 */
	public Comment getById(int commentId) {
		return (Comment)getHibernateTemplate().load(Comment.class, new Integer(commentId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#save(com.apress.prospring.domain.Comment)
	 */
	public void save(Comment comment) {
		getHibernateTemplate().save(comment);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#delete(int)
	 */
	public void delete(int commentId) {
		Comment comment = new Comment();
		comment.setCommentId(commentId);
		getHibernateTemplate().delete(comment);
	}

}
