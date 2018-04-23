package com.tigerit.evr.migration.mapper;

import com.tigerit.evr.migration.model.TaxToken;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by raqib on 26/11/15.
 */
@Component
public class TaxTokenRowMapper implements RowMapper<TaxToken> {
    @Override
    public TaxToken mapRow(ResultSet rs, int rowNum) throws SQLException {
        TaxToken taxToken = new TaxToken();
        taxToken.setTaxTokenId(rs.getString("tax_token_id"));
        taxToken.setRegistrationNo(rs.getString("registration_no"));
        taxToken.setRegistrationId(rs.getString("registration_id"));
        taxToken.setExpiryDate(rs.getDate("expiry_date"));

        return taxToken;
    }
}
