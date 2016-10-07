/*
 * Created on Sep 28, 2004
 */
package com.apress.prospring.ch14.timer.bday;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.scheduling.timer.ScheduledTimerTask;

/**
 * @author robh
 */
public class BirthdayScheduledTask extends ScheduledTimerTask {

    private static final long MILLIS_IN_YEAR = 1000 * 60 * 60 * 24 * 365;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Date startDate;

    public void setDate(String date) throws ParseException {
        startDate = dateFormat.parse(date);
    }

    public long getDelay() {
        Calendar now = Calendar.getInstance();
        Calendar then = Calendar.getInstance();
        then.setTime(startDate);

        //return (then.getTimeInMillis() - now.getTimeInMillis());
        return 1000;
    }

    public long getPeriod() {
        return MILLIS_IN_YEAR;
    }
}