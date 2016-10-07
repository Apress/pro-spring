/*
 * Created on Sep 8, 2004
 */
package com.apress.prospring.ch7.introductions;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * @author robh
 */
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {

    public IsModifiedAdvisor() {
        super(new IsModifiedMixin());
    }
}
