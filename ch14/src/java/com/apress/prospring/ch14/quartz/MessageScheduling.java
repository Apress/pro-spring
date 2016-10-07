/*
 * Created on Sep 28, 2004
 */
package com.apress.prospring.ch14.quartz;

import java.util.Date;
import java.util.Map;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author robh
 */
public class MessageScheduling {

    public static void main(String[] args) throws Exception{
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        JobDetail jobDetail = new JobDetail("messageJob",
                Scheduler.DEFAULT_GROUP, MessageJob.class);
        
        Map map = jobDetail.getJobDataMap();
        map.put("message", "This is a message from Quartz");

        Trigger trigger = new SimpleTrigger("simpleTrigger",
                Scheduler.DEFAULT_GROUP, new Date(), null,
                SimpleTrigger.REPEAT_INDEFINITELY, 3000);
        
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
