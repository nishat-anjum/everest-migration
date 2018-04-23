package com.tigerit.evr.migration.mapper;

import com.tigerit.evr.migration.model.VehicleHistory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by raqib on 03/12/15.
 */
@Component
public class VehicleHistoryRowMapper  implements RowMapper<VehicleHistory> {
    @Override
    public VehicleHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        VehicleHistory vehicleHistory = new VehicleHistory();
//        vehicleHistory.setRegistrationId(rs.getString("registration_id"));
//        vehicleHistory.setRegistrationNo(rs.getString("registration_no"));
//        vehicleHistory.setPreviousRegistrationNo(rs.getString("previous_registration_no"));
//        vehicleHistory.setVehicleId(rs.getString("vehicle_id"));
//        vehicleHistory.setChassisNo(rs.getString("chassis_no"));
//        vehicleHistory.setPersonId(rs.getString("person_id"));
//        vehicleHistory.setPersonName(rs.getString("person_name"));
//        vehicleHistory.setSequenceNo(rs.getInt("sequence_no"));
//        vehicleHistory.setUpdateDate(rs.getString("update_date"));
//        vehicleHistory.setlRegEventId(rs.getLong("l_reg_event_id"));
//        vehicleHistory.setlRegEventName(rs.getString("l_reg_event_name"));
//        vehicleHistory.setlOwnershipTypeId(rs.getLong("l_ownership_type_id"));
//        vehicleHistory.setlOwnershipTypeName(rs.getString("l_ownership_type_name"));
//        vehicleHistory.setlVehicleTypeId(rs.getLong("l_vehicle_type_id"));
//        vehicleHistory.setlVehicleTypeName(rs.getString("l_vehicle_type_name"));

        return vehicleHistory;
    }
}
