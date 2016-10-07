/*
 * Created on Aug 6, 2004
 */
package com.apress.prospring.ch5.pe;

import java.beans.PropertyEditorSupport;
import java.util.regex.Pattern;

/**
 * @author robh
 */
public class PatternPropertyEditor extends PropertyEditorSupport {

    public void setAsText(String text) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(text);
        setValue(pattern);
    }
}
