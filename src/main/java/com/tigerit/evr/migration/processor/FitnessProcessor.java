package com.tigerit.evr.migration.processor;

import com.tigerit.evr.migration.model.Fitness;
import com.tigerit.evr.migration.util.SpaceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by raqib on 24/11/15.
 */
@Component
public class FitnessProcessor implements ItemProcessor<Fitness, Fitness> {
    private static final Logger logger = LoggerFactory.getLogger(FitnessProcessor.class);

    @Override
    public Fitness process(Fitness fitness) throws Exception {
        fitness = (Fitness) SpaceUtil.trimReflective(fitness);
        logger.debug("Processing result: {}", fitness);
        return fitness;
    }
}
