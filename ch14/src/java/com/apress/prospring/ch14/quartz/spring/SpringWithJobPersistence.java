/*
 * Created on Sep 28, 2004
 */
package com.apress.prospring.ch14.quartz.spring;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author robh
 */
public class SpringWithJobPersistence {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "./ch14/src/conf/quartzPersistent.xml");

        // get the scheduler
        Scheduler scheduler = (Scheduler) ctx.getBean("schedulerFactory");

        JobDetail job = scheduler.getJobDetail("otherJob",
                Scheduler.DEFAULT_GROUP);

        if (job == null) {
            // the job has not yet been created
            job = (JobDetail) ctx.getBean("job");
            job.setName("otherJob");
            job.getJobDataMap().put("message", "This is another message");

            Trigger trigger = new SimpleTrigger("simpleTrigger",
                    Scheduler.DEFAULT_GROUP, new Date(), null,
                    SimpleTrigger.REPEAT_INDEFINITELY, 3000);

            scheduler.scheduleJob(job, trigger);
        }

    }
}