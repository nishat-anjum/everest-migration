package com.tigerit.evr.migration.listener;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by raqib on 25/11/15.
 */
@Component("stepListener")
public class MigrationStepListener implements StepExecutionListener {
    private static final Logger logger = LoggerFactory.getLogger(MigrationStepListener.class);
    private DateTime startTime, stopTime;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        startTime = new DateTime();
        logger.debug("{} step starts at: {}", stepExecution.getStepName(), startTime);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        stopTime = new DateTime();
        logger.debug("{} step stops at: {}", stepExecution.getStepName(), stopTime);
        logger.debug("Total time take in millis: {}", getTimeInMillis(startTime, stopTime));

        if (stepExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.debug("{} step completed successfully", stepExecution.getStepName());
            //Here you can perform some other business logic like cleanup
        } else if (stepExecution.getStatus() == BatchStatus.FAILED) {
            logger.debug("{} step failed with following exceptions", stepExecution.getStepName());
            List<Throwable> exceptionList = stepExecution.getFailureExceptions();
            for (Throwable th : exceptionList) {
                logger.error("Exception: {}", th.getLocalizedMessage());
            }
        }
        return stepExecution.getExitStatus();
    }

    private long getTimeInMillis(DateTime start, DateTime stop) {
        return stop.getMillis() - start.getMillis();
    }
}
