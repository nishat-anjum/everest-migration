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
    
    @Value("${biometric.select}")
    private String biometricSelectQuery;

    @Value("${biometric.insert}")
    private String biometricInsertQuery;

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

    @Value("${individual.type.enroll.select}")
    private String indivTypeEnrollSelectQuery;

    @Value("${individual.type.enroll.insert}")
    private String indivTypeEnrollInsertQuery;

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

    public String getBiometricSelectQuery() {
        return biometricSelectQuery;
    }

    public void setBiometricSelectQuery(String biometricSelectQuery) {
        this.biometricSelectQuery = biometricSelectQuery;
    }

    public String getBiometricInsertQuery() {
        return biometricInsertQuery;
    }

    public void setBiometricInsertQuery(String biometricInsertQuery) {
        this.biometricInsertQuery = biometricInsertQuery;
    }

    public String getIndivTypeEnrollSelectQuery() {
        return indivTypeEnrollSelectQuery;
    }

    public void setIndivTypeEnrollSelectQuery(String indivTypeEnrollSelectQuery) {
        this.indivTypeEnrollSelectQuery = indivTypeEnrollSelectQuery;
    }

    public String getIndivTypeEnrollInsertQuery() {
        return indivTypeEnrollInsertQuery;
    }

    public void setIndivTypeEnrollInsertQuery(String indivTypeEnrollInsertQuery) {
        this.indivTypeEnrollInsertQuery = indivTypeEnrollInsertQuery;
    }
}
