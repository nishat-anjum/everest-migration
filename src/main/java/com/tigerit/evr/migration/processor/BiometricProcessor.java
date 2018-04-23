package com.tigerit.evr.migration.processor;

import com.tigerit.evr.migration.model.Biometric;
import com.tigerit.evr.migration.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by nishat on 4/23/18.
 */
@Component
public class BiometricProcessor implements ItemProcessor<Biometric, Biometric> {

    private static final Logger logger = LoggerFactory.getLogger(BiometricProcessor.class);

    @Override
    public Biometric process(Biometric biometric) throws Exception {
        biometric.setCreatedBy(Utils.SERVICE_USER);
        biometric.setCreateTime(Utils.currentTimestamp());
        logger.debug("Processing result: {}", biometric);
        return biometric;
    }
}
