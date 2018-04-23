package com.tigerit.evr.migration.mapper;

import com.tigerit.evr.migration.model.VehicleHistory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nishat on 24/04/18.
 */
@Component
public class VehicleHistoryRowMapper  implements RowMapper<VehicleHistory> {
    @Override
    public VehicleHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        VehicleHistory vehicleHistory = new VehicleHistory();
        vehicleHistory.setRegEventDate(rs.getString("issue_date"));
        vehicleHistory.setRegEventName(rs.getString("form_type"));
        vehicleHistory.setOwnerTransferDate(rs.getString("ownership_transfer_date"));
        vehicleHistory.setChassis(rs.getString("chassis_no"));
        vehicleHistory.setPaymentReceiptNo(rs.getString("payment_receipt_number"));
        vehicleHistory.setOwnerType(rs.getInt("owner_type"));
        vehicleHistory.setRegNoNpl(rs.getString("nepali_reg_no"));
        vehicleHistory.setRegNoEng(rs.getString("dl_number"));
        vehicleHistory.setRegNoEng(rs.getString("dl_number"));
        vehicleHistory.setPaymentDate(rs.getString("payment_date"));
        vehicleHistory.setOwnerName(rs.getString("owner_name"));
        vehicleHistory.setEnrollId(rs.getLong("enroll_id"));

        return vehicleHistory;
    }
}
