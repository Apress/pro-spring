/*
 * Created on Jul 26, 2004
 */
package com.apress.prospring.business.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.apress.prospring.business.ObscenityFilter;
import com.apress.prospring.domain.BlogPosting;

/**
 * @author robh
 */
public class ObscenityFilterAdvice implements MethodBeforeAdvice {

    private ObscenityFilter filter;

    public void setObscenityFilter(ObscenityFilter filter) {
        this.filter = filter;
    }

    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        for (int x = 0; x < args.length; x++) {
            if (args[x] instanceof BlogPosting) {
                BlogPosting arg = (BlogPosting) args[x];
                if (filter.containsObscenities(arg.getBody())) {
                    arg.setBody(filter.obfuscateObscenities(arg.getBody()));
                }
                if (filter.containsObscenities(arg.getSubject())) {
                    arg.setSubject(filter
                            .obfuscateObscenities(arg.getSubject()));
                }
            }
        }
    }

}