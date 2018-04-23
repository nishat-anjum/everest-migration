package com.tigerit.evr.migration.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by raqib on 02/12/15.
 */
public class VehicleHistory implements Serializable {
    private Long enrollId;
    private String paymentReceiptNo;
    private String paymentDate;
    private String regNoEng;
    private String regNoNpl;
    private String chassis;
    private String vehicleType;
    private String ownerName;
    private int ownerType;
    private String ownerTransferDate;
    private int ownerSeqNo;
    private String regEventName;
    private String ownershipTypeName;
    private int regEventId;
    private String regEventDate;
    private int vehicleTypeId;
    private Date createTime;
    private String createdBy;

    public Long getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(Long enrollId) {
        this.enrollId = enrollId;
    }

    public String getPaymentReceiptNo() {
        return paymentReceiptNo;
    }

    public void setPaymentReceiptNo(String paymentReceiptNo) {
        this.paymentReceiptNo = paymentReceiptNo;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getRegNoEng() {
        return regNoEng;
    }

    public void setRegNoEng(String regNoEng) {
        this.regNoEng = regNoEng;
    }

    public String getRegNoNpl() {
        return regNoNpl;
    }

    public void setRegNoNpl(String regNoNpl) {
        this.regNoNpl = regNoNpl;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(int ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerTransferDate() {
        return ownerTransferDate;
    }

    public void setOwnerTransferDate(String ownerTransferDate) {
        this.ownerTransferDate = ownerTransferDate;
    }

    public int getOwnerSeqNo() {
        return ownerSeqNo;
    }

    public void setOwnerSeqNo(int ownerSeqNo) {
        this.ownerSeqNo = ownerSeqNo;
    }

    public String getRegEventName() {
        return regEventName;
    }

    public void setRegEventName(String regEventName) {
        this.regEventName = regEventName;
    }

    public String getOwnershipTypeName() {
        return ownershipTypeName;
    }

    public void setOwnershipTypeName(String ownershipTypeName) {
        this.ownershipTypeName = ownershipTypeName;
    }

    public int getRegEventId() {
        return regEventId;
    }

    public void setRegEventId(int regEventId) {
        this.regEventId = regEventId;
    }

    public String getRegEventDate() {
        return regEventDate;
    }

    public void setRegEventDate(String regEventDate) {
        this.regEventDate = regEventDate;
    }

    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "VehicleHistory{" +
                "enrollId=" + enrollId +
                ", regNoEng='" + regNoEng + '\'' +
                ", regNoNpl='" + regNoNpl + '\'' +
                ", regEventName='" + regEventName + '\'' +
                '}';
    }
}
