/*
 * Created on 19-Jul-2004
 */
package com.apress.prospring.data.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.apress.prospring.data.CommentDao;
import com.apress.prospring.domain.Comment;
import com.apress.prospring.domain.User;

/**
 * @author janm
 */
public class SqlMapClientCommentDao extends SqlMapClientDaoSupport implements CommentDao {

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#getByEntry(int)
	 */
	@SuppressWarnings(value={"unchecked"})
	public List<Comment> getByEntry(int entry) {
		return getSqlMapClientTemplate().queryForList("getCommentByEntry", new Integer(entry));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#getById(int)
	 */
	public Comment getById(int commentId) {
		return (Comment)getSqlMapClientTemplate().queryForObject("getCommentById", new Integer(commentId));
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#save(com.apress.prospring.domain.Comment)
	 */
	public void save(Comment comment) {
		if (comment.getCommentId() == 0) 
			insert(comment);
		else
			update(comment);
	}

	/**
	 * Inserts a comment
	 * 
	 * @param comment The comment
	 */
	private void insert(Comment comment) {
		comment.setPostedBy(new User());
		//comment.getPostedBy().setUserId(user);

		getSqlMapClientTemplate().insert("updateComment", comment);
	}

	/**
	 * Updates a comment
	 * 
	 * @param comment The comment
	 */
	private void update(Comment comment) {
		getSqlMapClientTemplate().update("updateComment", comment);
	}

	/* (non-Javadoc)
	 * @see com.apress.prospring.data.CommentDao#delete(int)
	 */
	public void delete(int commentId) {
		getSqlMapClientTemplate().delete("deleteComment", new Integer(commentId));
	}

}