package com.tigerit.evr.migration.processor;

import com.tigerit.evr.migration.model.VehicleHistory;
import com.tigerit.evr.migration.util.SpaceUtil;
import com.tigerit.evr.migration.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by nishat on 24/04/18.
 */
@Component
public class VehicleHistoryProcessor implements ItemProcessor<VehicleHistory, VehicleHistory> {
    private static final Logger logger = LoggerFactory.getLogger(VehicleHistoryProcessor.class);

    @Override
    public VehicleHistory process(VehicleHistory vehicleHistory) throws Exception {
        vehicleHistory = (VehicleHistory) SpaceUtil.trimReflective(vehicleHistory);
        vehicleHistory.setCreatedBy(Utils.SERVICE_USER);
        vehicleHistory.setCreateTime(Utils.currentTimestamp());
        logger.debug("Processing result: {}", vehicleHistory);
        return vehicleHistory;
    }
}
