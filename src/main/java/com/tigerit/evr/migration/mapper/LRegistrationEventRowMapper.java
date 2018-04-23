package com.tigerit.evr.migration.mapper;

import com.tigerit.evr.migration.model.LRegistrationEvent;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by raqib on 26/11/15.
 */
@Component
public class LRegistrationEventRowMapper implements RowMapper<LRegistrationEvent> {
    @Override
    public LRegistrationEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
        LRegistrationEvent lRegistrationEvent = new LRegistrationEvent();
        lRegistrationEvent.setEventId(rs.getLong("event_id"));
        lRegistrationEvent.setEventCode(rs.getString("event_code"));
        lRegistrationEvent.setEventName(rs.getString("event_name"));

        return lRegistrationEvent;
    }
}
