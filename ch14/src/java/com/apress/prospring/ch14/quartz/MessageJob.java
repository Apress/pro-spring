/*
 * Created on Sep 28, 2004
 */
package com.apress.prospring.ch14.quartz;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author robh
 */
public class MessageJob implements Job {

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        Map properties = context.getJobDetail().getJobDataMap();

        System.out.println("Previous Fire Time: "
                + context.getPreviousFireTime());
        System.out.println("Current Fire Time: " + context.getFireTime());
        System.out.println("Next Fire Time: " + context.getNextFireTime());

        System.out.println(properties.get("message"));

        System.out.println("");
    }

}