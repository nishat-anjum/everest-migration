package com.tigerit.evr.migration.mapper;

import com.tigerit.evr.migration.model.Biometric;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nishat on 4/23/18.
 */
@Component
public class BiometricRowMapper implements RowMapper<Biometric> {
    @Override
    public Biometric mapRow(ResultSet rs, int rowNum) throws SQLException {
        Biometric biometric = new Biometric();
        biometric.setId(rs.getLong("id"));
        biometric.setPhoto(rs.getBytes("photo"));
        biometric.setSignature(rs.getBytes("signature"));
        return biometric;
    }
}
