package com.tigerit.evr.migration.mapper;

import com.tigerit.evr.migration.model.Fitness;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by raqib on 24/11/15.
 */
@Component
public class FitnessRowMapper implements RowMapper<Fitness> {
    @Override
    public Fitness mapRow(ResultSet rs, int rowNum) throws SQLException {
        Fitness fitness = new Fitness();
        fitness.setFitnessId(rs.getString("fitness_id"));
        fitness.setRegistrationNo(rs.getString("registration_no"));
        fitness.setRegistrationId(rs.getString("registration_id"));
        fitness.setExpiryDate(rs.getDate("expiry_date"));

        return fitness;
    }
}
