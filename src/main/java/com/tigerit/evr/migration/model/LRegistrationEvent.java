package com.tigerit.evr.migration.model;

import java.io.Serializable;

/**
 * Created by raqib on 22/11/15.
 */
public class LRegistrationEvent implements Serializable {
    private Long eventId;
    private String eventCode;
    private String eventName;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "LRegistrationEvent{" +
                "eventId=" + eventId +
                ", eventCode='" + eventCode + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
