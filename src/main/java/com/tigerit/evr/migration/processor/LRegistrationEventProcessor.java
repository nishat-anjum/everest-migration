package com.tigerit.evr.migration.processor;

import com.tigerit.evr.migration.model.LRegistrationEvent;
import com.tigerit.evr.migration.util.SpaceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by raqib on 26/11/15.
 */
@Component
public class LRegistrationEventProcessor implements ItemProcessor<LRegistrationEvent, LRegistrationEvent> {
    private static final Logger logger = LoggerFactory.getLogger(LRegistrationEventProcessor.class);

    @Override
    public LRegistrationEvent process(LRegistrationEvent lRegistrationEvent) throws Exception {
        lRegistrationEvent = (LRegistrationEvent) SpaceUtil.trimReflective(lRegistrationEvent);
        logger.debug("Processing result: {}", lRegistrationEvent);
        return lRegistrationEvent;
    }
}
