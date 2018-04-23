package com.tigerit.evr.migration.listener;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by raqib on 25/11/15.
 */
@Component("jobListener")
public class MigrationJobListener implements JobExecutionListener {
    private static final Logger logger = LoggerFactory.getLogger(MigrationJobListener.class);
    private DateTime startTime, stopTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = new DateTime();
        logger.debug("{} job starts at: {}", jobExecution.getJobInstance().getJobName(), startTime);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        stopTime = new DateTime();
        logger.debug("{} job stops at: {}", jobExecution.getJobInstance().getJobName(), stopTime);
        logger.debug("Total time take in millis: {}", getTimeInMillis(startTime, stopTime));

        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.debug("{} job completed successfully", jobExecution.getJobInstance().getJobName());
            //Here you can perform some other business logic like cleanup
        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            logger.debug("{} job failed with following exceptions", jobExecution.getJobInstance().getJobName());
            List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
            for (Throwable th : exceptionList) {
                logger.error("exception: {}", th.getLocalizedMessage());
            }
        }
    }

    private long getTimeInMillis(DateTime start, DateTime stop) {
        return stop.getMillis() - start.getMillis();
    }
}
