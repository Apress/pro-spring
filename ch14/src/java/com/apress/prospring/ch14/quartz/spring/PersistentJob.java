/*
 * Created on Sep 28, 2004
 */
package com.apress.prospring.ch14.quartz.spring;

import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

/**
 * @author robh
 */
public class PersistentJob implements StatefulJob {

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        Map map = context.getJobDetail().getJobDataMap();
        System.out.println("[" + context.getJobDetail().getName() + "]"
                + map.get("message"));
        map.put("message", "Updated Message");
    }

}