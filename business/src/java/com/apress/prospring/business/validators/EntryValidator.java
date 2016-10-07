/*
 * Created on 11-Aug-2004
 */
package com.apress.prospring.business.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.apress.prospring.domain.Entry;

/**
 * @author janm
 */
public class EntryValidator implements Validator {


    public boolean supports(Class clazz) {
    	return Entry.class.isAssignableFrom(clazz);
    }


    public void validate(Object obj, Errors errors) {
        // Entry entry = (Entry) obj;
               
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject",
                "required", null, "required");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "body", "required",
                null, "required");
    }

}