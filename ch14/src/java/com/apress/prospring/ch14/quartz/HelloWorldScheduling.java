/*
 * Created on Sep 28, 2004
 */
package com.apress.prospring.ch14.quartz;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author robh
 */
public class HelloWorldScheduling {

    public static void main(String[] args) throws Exception {

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        JobDetail jobDetail = new JobDetail("helloWorldJob",
                Scheduler.DEFAULT_GROUP, HelloWorldJob.class);

        Trigger trigger = new SimpleTrigger("simpleTrigger",
                Scheduler.DEFAULT_GROUP, new Date(), null,
                SimpleTrigger.REPEAT_INDEFINITELY, 3000);
        
        scheduler.scheduleJob(jobDetail, trigger);
    }
}