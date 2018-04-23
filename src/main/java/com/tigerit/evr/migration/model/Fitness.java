package com.tigerit.evr.migration.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by raqib on 16/11/15.
 */
public class Fitness implements Serializable {
    private String fitnessId;
    private String registrationNo;
    private String registrationId;
    private Date expiryDate;

    public String getFitnessId() {
        return fitnessId;
    }

    public void setFitnessId(String fitnessId) {
        this.fitnessId = fitnessId;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "fitnessId='" + fitnessId + '\'' +
                ", registrationNo='" + registrationNo + '\'' +
                ", registrationId='" + registrationId + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
