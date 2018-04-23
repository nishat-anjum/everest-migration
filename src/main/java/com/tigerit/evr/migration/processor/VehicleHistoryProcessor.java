package com.tigerit.evr.migration.processor;

import com.tigerit.evr.migration.model.VehicleHistory;
import com.tigerit.evr.migration.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by raqib on 06/12/15.
 */
@Component
public class VehicleHistoryProcessor implements ItemProcessor<VehicleHistory, VehicleHistory> {
    private static final Logger logger = LoggerFactory.getLogger(VehicleHistoryProcessor.class);

    @Override
    public VehicleHistory process(VehicleHistory vehicleHistory) throws Exception {
//        vehicleHistory.setRegistrationId(StringUtils.strip(vehicleHistory.getRegistrationId()));
//        vehicleHistory.setRegistrationNo(StringUtils.strip(vehicleHistory.getRegistrationNo()));
//        vehicleHistory.setPreviousRegistrationNo(StringUtils.strip(vehicleHistory.getPreviousRegistrationNo()));
//        vehicleHistory.setVehicleId(StringUtils.strip(vehicleHistory.getVehicleId()));
//        vehicleHistory.setChassisNo(StringUtils.strip(vehicleHistory.getChassisNo()));
//        vehicleHistory.setPersonId(StringUtils.strip(vehicleHistory.getPersonId()));
//        vehicleHistory.setPersonName(StringUtils.strip(vehicleHistory.getPersonName()));
//        vehicleHistory.setUpdateDate(StringUtils.strip(vehicleHistory.getUpdateDate()));
//        vehicleHistory.setlRegEventName(StringUtils.strip(vehicleHistory.getlRegEventName()));
//        vehicleHistory.setlOwnershipTypeName(StringUtils.strip(vehicleHistory.getlOwnershipTypeName()));
//        vehicleHistory.setlVehicleTypeName(StringUtils.strip(vehicleHistory.getlVehicleTypeName()));

        logger.debug("Processing result: {}", vehicleHistory);
        return vehicleHistory;
    }
}
