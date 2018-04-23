package com.tigerit.evr.migration.mapper;

import com.tigerit.evr.migration.model.OrganizationStamp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nishat on 4/23/18.
 */
@Component
public class OrgStampRowMapper implements RowMapper<OrganizationStamp> {
    @Override
    public OrganizationStamp mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrganizationStamp organizationStamp = new OrganizationStamp();
        organizationStamp.setId(rs.getLong("id"));
        organizationStamp.setStampImage(rs.getBytes("stamp_image"));

        return organizationStamp;
    }
}
