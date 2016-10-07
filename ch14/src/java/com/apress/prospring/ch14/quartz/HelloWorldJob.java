/*
 * Created on Sep 28, 2004
 */
package com.apress.prospring.ch14.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author robh
 */
public class HelloWorldJob implements Job {

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Hello World!");
    }

}