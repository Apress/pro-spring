/*
 * Created on 11-Aug-2004
 */
package com.apress.prospring.business.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.apress.prospring.domain.Comment;

/**
 * @author janm
 */
public class CommentValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	public boolean supports(Class clazz) {
		return Comment.class.isAssignableFrom(clazz);
		// return clazz.isAssignableFrom(Comment.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object obj, Errors errors) {
		Comment comment = (Comment)obj;
		if (comment.getSubject() == null || comment.getSubject().length() == 0) {
			errors.rejectValue("subject", "required", null, "required");
		}
		if (comment.getBody() == null || comment.getBody().length() == 0) {
			errors.rejectValue("body", "required", null, "required");
		}
	}

}
