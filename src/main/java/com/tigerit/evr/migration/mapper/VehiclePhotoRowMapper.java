package com.tigerit.evr.migration.mapper;

import com.tigerit.evr.migration.model.VehiclePhoto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nishat on 4/23/18.
 */
@Component
public class VehiclePhotoRowMapper implements RowMapper<VehiclePhoto> {
    @Override
    public VehiclePhoto mapRow(ResultSet rs, int rowNum) throws SQLException {
        VehiclePhoto vehiclePhoto = new VehiclePhoto();
        vehiclePhoto.setId(rs.getLong("id"));
        vehiclePhoto.setPhoto(rs.getBytes("photo"));
        return vehiclePhoto;
    }
}
