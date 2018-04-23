package com.tigerit.evr.migration.mapper;

import com.tigerit.evr.migration.model.EnrollmentBean;
import com.tigerit.evr.migration.util.Utils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nishat on 4/23/18.
 */
@Component("indivEnrollmentRowMapper")
public class IndivEnrollmentRowMapper implements RowMapper<EnrollmentBean> {

    @Override
    public EnrollmentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        EnrollmentBean enrollmentBean = new EnrollmentBean();
        enrollmentBean.setEnrollId(rs.getLong("id"));
        enrollmentBean.setRegNo(rs.getString("reg_no"));
        enrollmentBean.setRegNoNepal(rs.getString("nepali_reg_no"));
        enrollmentBean.setVehicleType(rs.getInt("ev_type_id"));
        enrollmentBean.setVehicleTypeText(rs.getString("ev_type_text"));
        enrollmentBean.setOwnershipTypeName(rs.getString("ownership_type"));
        enrollmentBean.setPassportIssueAuth(rs.getLong("reg_exam_unit_id"));
        enrollmentBean.setPassportIssueAuthText(rs.getString("reg_exam_unit_text"));
        enrollmentBean.setOwnershipType(rs.getInt("owner_type"));
        enrollmentBean.setModel(rs.getString("ev_model_text"));


        enrollmentBean.setManufacturer(rs.getString("ev_make_text"));
        enrollmentBean.setChassisNo(rs.getString("chassis_no"));
        enrollmentBean.setRegistrationDateNpl(rs.getString("issue_date"));
        enrollmentBean.setOwnershipTransferDateNpl(rs.getString("ownership_transfer_date"));
        enrollmentBean.setPaymentDateNpl(rs.getString("payment_date"));
        enrollmentBean.setPaymentReceiptNumber(rs.getString("payment_receipt_number"));


        enrollmentBean.setNoOfSeats(rs.getLong("number_of_seats"));
        enrollmentBean.setOwnerEmail(rs.getString("email"));
        enrollmentBean.setOwnerPhone(rs.getString("phone"));
        enrollmentBean.setBankName(rs.getString("bank_name"));
        enrollmentBean.setVehiclePhotoId(rs.getLong("vehicle_photo_id"));

        enrollmentBean.setOwnerName(rs.getString("full_name"));
        enrollmentBean.setOwnerNID(rs.getString("passport"));
        enrollmentBean.setOwnerAddress(rs.getString("address"));
        enrollmentBean.setPassportIssueAuth(rs.getLong("country_id"));
        enrollmentBean.setPassportIssueAuthText(rs.getString("country_text"));
        enrollmentBean.setNationality(rs.getLong("district_id"));
        enrollmentBean.setNationalityText(rs.getString("district_text"));
        enrollmentBean.setBioDataId(rs.getLong("bio_data_id"));
        enrollmentBean.setEpc(rs.getString("epc"));
        enrollmentBean.setRfid(rs.getString("rfid"));
        enrollmentBean.setTagId(rs.getString("tag_id"));
        enrollmentBean.setVehicleClass(Utils.getVehicleClass(rs.getString("code")));

        return enrollmentBean;
    }
}
