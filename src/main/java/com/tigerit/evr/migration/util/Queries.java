package com.tigerit.evr.migration.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by nishat on 4/23/18.
 */
@Component
@PropertySource({"classpath:sql-${spring.profiles.active}.properties"})
public class Queries {
    public static final String INDIV_TYPE_ENROLL_SELECT = "SELECT " +
            "ev.id, " +
            "ev.reg_no, " +
            "ev.nepali_reg_no, " +
            "ev.ev_type_id, " +
            "ev.ev_type_text, " +
            "ev.ownership_type, " +
            "ev.reg_exam_unit_id, " +
            "ev.reg_exam_unit_text, " +
            "ev.owner_type, " +
            "ev.ev_model_text, " +
            "ev.ev_make_text, " +
            "ev.chassis_no, " +
            "ev.issue_date, " +
            "ev.ownership_transfer_date, " +
            "ev.payment_date, " +
            "ev.payment_receipt_number, " +
            "ev.number_of_seats, " +
            "ev.email, " +
            "ev.phone, " +
            "ev.bank_name, " +
            "ev.vehicle_photo_id, " +
            "person.full_name, " +
            "person.passport, " +
            "person.address, " +
            "person.country_id, " +
            "person.country_text, " +
            "person.district_id, " +
            "person.district_text, " +
            "bio.id bio_data_id, " +
            "perso.epc, " +
            "perso.rfid, " +
            "perso.tag_id, " +
            "et.code code " +
            "FROM ev_identity ev  " +
            "LEFT JOIN person person ON (person.id = ev.person_id )  " +
            "LEFT JOIN biometric bio ON (person.id = bio.applicant_id AND bio.active = 1)  " +
            "LEFT JOIN personalize perso ON (perso.ev_identity_id = ev.id)  " +
            "LEFT JOIN ev_type et ON (et.id = ev.ev_type_id) WHERE ev.owner_Type = 0";

    public static final String INDIV_TYPE_ENROLL_INSERT = "INSERT INTO is_enroll_test ( " +
            "id, reg_no, reg_no_bangla, " +
            "vehicle_type, vehicle_type_text, " +
            "ownership_type_enum, " +
            "current_authority, current_authority_text, " +
            "ownership_type, " +
            "vehicle_model, " +
            "manufacturer, " +
            "chesis_no, " +
            "registration_date, " +
            "ownership_transfer_date, " +
            "payment_date_nepal, " +
            "transaction_no, " +
            "number_of_seats, " +
            "owner_email, owner_phone, " +
            "bank_name, " +
            "vehicle_photo_id, " +
            "owner_name, " +
            "owner_nid, " +
            "owner_address, " +
            "country_id, country_text, " +
            "district_id, district_text, " +
            "bio_data_id, " +
            "epc, rf_tag_id, tag_id, " +
            "vehicle_class, created_by, create_time) VALUES (:enrollId, :regNo, :regNoNepal, :vehicleType, :vehicleTypeText, :ownershipTypeName, :currentAuthorityId, " +
            ":currentAuthorityName, :ownershipType, :model, :manufacturer, :chassisNo, :registrationDateNpl, :ownershipTransferDateNpl, :paymentDateNpl, " +
            ":paymentReceiptNumber, :noOfSeats, :ownerEmail, :ownerPhone, :bankName, :vehiclePhotoId, :ownerName, :ownerNID, :ownerAddress, :nationality, " +
            ":nationalityText, :passportIssueAuth, :passportIssueAuthText, :bioDataId, :epc, :rfid, :tagId, :vehicleClass, :createdBy, :createTime)";


    public static final String BIOMETRIC_SELECT = "SELECT bio.id, bio.photo, bio.signature " +
            "FROM Biometric bio " +
            "LEFT JOIN person per ON (bio.applicant_id = per.id) " +
            "WHERE bio.active = 1";

    public static final String BIOMETRIC_INSERT = "INSERT INTO Biometric_Test (id, photo, signature, created_by, create_time) VALUES " +
            "(:id, :photo, :signature, :createdBy, :createTime)";

    @Value("${organization.stamp.insert}")
    private String orgStampInsertQuery;

    @Value("${organization.stamp.select}")
    private String orgStampSelectQuery;

    @Value("${vehicle.photo.insert}")
    private String vehiclePhotoInsertQuery;

    @Value("${vehicle.photo.select}")
    private String vehiclePhotoSelectQuery;

    @Value("${organization.type.enroll.select}")
    private String orgTypeEnrollSelectQuery;

    @Value("${organization.type.enroll.select}")
    private String orgTypeEnrollInsertQuery;

    public String getOrgStampInsertQuery() {
        return orgStampInsertQuery;
    }

    public void setOrgStampInsertQuery(String orgStampInsertQuery) {
        this.orgStampInsertQuery = orgStampInsertQuery;
    }

    public String getOrgStampSelectQuery() {
        return orgStampSelectQuery;
    }

    public void setOrgStampSelectQuery(String orgStampSelectQuery) {
        this.orgStampSelectQuery = orgStampSelectQuery;
    }

    public String getVehiclePhotoInsertQuery() {
        return vehiclePhotoInsertQuery;
    }

    public void setVehiclePhotoInsertQuery(String vehiclePhotoInsertQuery) {
        this.vehiclePhotoInsertQuery = vehiclePhotoInsertQuery;
    }

    public String getVehiclePhotoSelectQuery() {
        return vehiclePhotoSelectQuery;
    }

    public void setVehiclePhotoSelectQuery(String vehiclePhotoSelectQuery) {
        this.vehiclePhotoSelectQuery = vehiclePhotoSelectQuery;
    }

    public String getOrgTypeEnrollSelectQuery() {
        return orgTypeEnrollSelectQuery;
    }

    public void setOrgTypeEnrollSelectQuery(String orgTypeEnrollSelectQuery) {
        this.orgTypeEnrollSelectQuery = orgTypeEnrollSelectQuery;
    }

    public String getOrgTypeEnrollInsertQuery() {
        return orgTypeEnrollInsertQuery;
    }

    public void setOrgTypeEnrollInsertQuery(String orgTypeEnrollInsertQuery) {
        this.orgTypeEnrollInsertQuery = orgTypeEnrollInsertQuery;
    }
}
