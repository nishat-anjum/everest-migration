package com.tigerit.evr.migration.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by nishat on 4/23/18.
 */
public class OrganizationStamp implements Serializable {
    private Long id;
    private byte[] stampImage;
    private Date createTime;
    private String createdBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getStampImage() {
        return stampImage;
    }

    public void setStampImage(byte[] stampImage) {
        this.stampImage = stampImage;
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
        return "OrganizationStamp{" +
                "id=" + id +
                '}';
    }
}
