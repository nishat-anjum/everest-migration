package com.tigerit.evr.migration.model;

import java.io.Serializable;

/**
 * Created by raqib on 02/12/15.
 */
public class VehicleHistory implements Serializable {
    private String registrationId;
    private String registrationNo;
    private String previousRegistrationNo;
    private String vehicleId;
    private String chassisNo;
    private String personId;
    private String personName;
    private Integer sequenceNo;
    private String updateDate;
    private Long lRegEventId;
    private String lRegEventName;
    private Long lOwnershipTypeId;
    private String lOwnershipTypeName;
    private Long lVehicleTypeId;
    private String lVehicleTypeName;

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getPreviousRegistrationNo() {
        return previousRegistrationNo;
    }

    public void setPreviousRegistrationNo(String previousRegistrationNo) {
        this.previousRegistrationNo = previousRegistrationNo;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Long getlRegEventId() {
        return lRegEventId;
    }

    public void setlRegEventId(Long lRegEventId) {
        this.lRegEventId = lRegEventId;
    }

    public String getlRegEventName() {
        return lRegEventName;
    }

    public void setlRegEventName(String lRegEventName) {
        this.lRegEventName = lRegEventName;
    }

    public Long getlOwnershipTypeId() {
        return lOwnershipTypeId;
    }

    public void setlOwnershipTypeId(Long lOwnershipTypeId) {
        this.lOwnershipTypeId = lOwnershipTypeId;
    }

    public String getlOwnershipTypeName() {
        return lOwnershipTypeName;
    }

    public void setlOwnershipTypeName(String lOwnershipTypeName) {
        this.lOwnershipTypeName = lOwnershipTypeName;
    }

    public Long getlVehicleTypeId() {
        return lVehicleTypeId;
    }

    public void setlVehicleTypeId(Long lVehicleTypeId) {
        this.lVehicleTypeId = lVehicleTypeId;
    }

    public String getlVehicleTypeName() {
        return lVehicleTypeName;
    }

    public void setlVehicleTypeName(String lVehicleTypeName) {
        this.lVehicleTypeName = lVehicleTypeName;
    }

    @Override
    public String toString() {
        return "VehicleHistory{" +
                "registrationId='" + registrationId + '\'' +
                ", registrationNo='" + registrationNo + '\'' +
                ", previousRegistrationNo='" + previousRegistrationNo + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", chassisNo='" + chassisNo + '\'' +
                ", personId='" + personId + '\'' +
                ", personName='" + personName + '\'' +
                ", sequenceNo=" + sequenceNo +
                ", updateDate='" + updateDate + '\'' +
                ", lRegEventId=" + lRegEventId +
                ", lRegEventName='" + lRegEventName + '\'' +
                ", lOwnershipTypeId=" + lOwnershipTypeId +
                ", lOwnershipTypeName='" + lOwnershipTypeName + '\'' +
                ", lVehicleTypeId=" + lVehicleTypeId +
                ", lVehicleTypeName='" + lVehicleTypeName + '\'' +
                '}';
    }
}
