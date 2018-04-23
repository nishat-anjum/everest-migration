package com.tigerit.evr.migration.processor;

import com.tigerit.evr.migration.model.VehiclePhoto;
import com.tigerit.evr.migration.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by nishat on 4/23/18.
 */
@Component
public class VehiclePhotoProcessor implements ItemProcessor<VehiclePhoto, VehiclePhoto> {

    private static final Logger logger = LoggerFactory.getLogger(VehiclePhotoProcessor.class);

    @Override
    public VehiclePhoto process(VehiclePhoto vehiclePhoto) throws Exception {
        vehiclePhoto.setCreatedBy(Utils.SERVICE_USER);
        vehiclePhoto.setCreateTime(Utils.currentTimestamp());
        logger.debug("Processing result: {}", vehiclePhoto);
        return vehiclePhoto;
    }
}
