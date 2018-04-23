package com.tigerit.evr.migration.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by nishat on 4/23/18.
 */
public class EnrollmentBean implements Serializable {

    private Long enrollId;
    private String regNo;
    private String regNoNepal;
    private String chassisNo;

    private int ownershipType;
    private String ownershipTypeName;

    private String registrationDateNpl;
    private String ownershipTransferDateNpl;
    private String paymentDateNpl;
    private String paymentReceiptNumber;

    private String ownerPhone;
    private String ownerEmail;

    private int vehicleType;
    private String vehicleTypeText;
    private String vehicleTypeCode;
    private int vehicleClass;
    private String vehicleClassName;
    private String model;

    private String rfid;
    private String epc;
    private String tagId;

    private Long currentAuthorityId;
    private String currentAuthorityName;

    private String ownerName;
    private String ownerNID;
    private String ownerAddress;
    private Long passportIssueAuth;
    private String passportIssueAuthText;
    private Long nationality;
    private String nationalityText;

    private Long bioDataId;
    private Long noOfSeats;
    private String bankName;

    private int personalizationStatus;
    private Long vehiclePhotoId;
    private Long orgStampPhotoId;

    private String organizationName;
    private String orgVatOrPanNo;
    private String orgAddress;
    private boolean hasRepresentative;

    private String manufacturer;
    private Date createTime;
    private String createdBy;

    public Long getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(Long enrollId) {
        this.enrollId = enrollId;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNoNepal() {
        return regNoNepal;
    }

    public void setRegNoNepal(String regNoNepal) {
        this.regNoNepal = regNoNepal;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public int getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(int ownershipType) {
        this.ownershipType = ownershipType;
    }

    public String getOwnershipTypeName() {
        return ownershipTypeName;
    }

    public void setOwnershipTypeName(String ownershipTypeName) {
        this.ownershipTypeName = ownershipTypeName;
    }

    public String getRegistrationDateNpl() {
        return registrationDateNpl;
    }

    public void setRegistrationDateNpl(String registrationDateNpl) {
        this.registrationDateNpl = registrationDateNpl;
    }

    public String getOwnershipTransferDateNpl() {
        return ownershipTransferDateNpl;
    }

    public void setOwnershipTransferDateNpl(String ownershipTransferDateNpl) {
        this.ownershipTransferDateNpl = ownershipTransferDateNpl;
    }

    public String getPaymentDateNpl() {
        return paymentDateNpl;
    }

    public void setPaymentDateNpl(String paymentDateNpl) {
        this.paymentDateNpl = paymentDateNpl;
    }

    public String getPaymentReceiptNumber() {
        return paymentReceiptNumber;
    }

    public void setPaymentReceiptNumber(String paymentReceiptNumber) {
        this.paymentReceiptNumber = paymentReceiptNumber;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleTypeText() {
        return vehicleTypeText;
    }

    public void setVehicleTypeText(String vehicleTypeText) {
        this.vehicleTypeText = vehicleTypeText;
    }

    public String getVehicleTypeCode() {
        return vehicleTypeCode;
    }

    public void setVehicleTypeCode(String vehicleTypeCode) {
        this.vehicleTypeCode = vehicleTypeCode;
    }

    public int getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(int vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public String getVehicleClassName() {
        return vehicleClassName;
    }

    public void setVehicleClassName(String vehicleClassName) {
        this.vehicleClassName = vehicleClassName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getEpc() {
        return epc;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public Long getCurrentAuthorityId() {
        return currentAuthorityId;
    }

    public void setCurrentAuthorityId(Long currentAuthorityId) {
        this.currentAuthorityId = currentAuthorityId;
    }

    public String getCurrentAuthorityName() {
        return currentAuthorityName;
    }

    public void setCurrentAuthorityName(String currentAuthorityName) {
        this.currentAuthorityName = currentAuthorityName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNID() {
        return ownerNID;
    }

    public void setOwnerNID(String ownerNID) {
        this.ownerNID = ownerNID;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public Long getPassportIssueAuth() {
        return passportIssueAuth;
    }

    public void setPassportIssueAuth(Long passportIssueAuth) {
        this.passportIssueAuth = passportIssueAuth;
    }

    public String getPassportIssueAuthText() {
        return passportIssueAuthText;
    }

    public void setPassportIssueAuthText(String passportIssueAuthText) {
        this.passportIssueAuthText = passportIssueAuthText;
    }

    public Long getNationality() {
        return nationality;
    }

    public void setNationality(Long nationality) {
        this.nationality = nationality;
    }

    public String getNationalityText() {
        return nationalityText;
    }

    public void setNationalityText(String nationalityText) {
        this.nationalityText = nationalityText;
    }

    public Long getBioDataId() {
        return bioDataId;
    }

    public void setBioDataId(Long bioDataId) {
        this.bioDataId = bioDataId;
    }

    public Long getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(Long noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getPersonalizationStatus() {
        return personalizationStatus;
    }

    public void setPersonalizationStatus(int personalizationStatus) {
        this.personalizationStatus = personalizationStatus;
    }

    public Long getVehiclePhotoId() {
        return vehiclePhotoId;
    }

    public void setVehiclePhotoId(Long vehiclePhotoId) {
        this.vehiclePhotoId = vehiclePhotoId;
    }

    public Long getOrgStampPhotoId() {
        return orgStampPhotoId;
    }

    public void setOrgStampPhotoId(Long orgStampPhotoId) {
        this.orgStampPhotoId = orgStampPhotoId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrgVatOrPanNo() {
        return orgVatOrPanNo;
    }

    public void setOrgVatOrPanNo(String orgVatOrPanNo) {
        this.orgVatOrPanNo = orgVatOrPanNo;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public boolean isHasRepresentative() {
        return hasRepresentative;
    }

    public void setHasRepresentative(boolean hasRepresentative) {
        this.hasRepresentative = hasRepresentative;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "EnrollmentBean{" +
                "enrollId=" + enrollId +
                ", regNo='" + regNo + '\'' +
                ", regNoNepal='" + regNoNepal + '\'' +
                '}';
    }
}
