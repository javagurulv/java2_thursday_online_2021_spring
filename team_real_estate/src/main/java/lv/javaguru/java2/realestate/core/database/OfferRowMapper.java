package lv.javaguru.java2.realestate.core.database;

import lv.javaguru.java2.realestate.core.domain.Offer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferRowMapper implements RowMapper<Offer> {
    @Override
    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Offer offer = new Offer(
                rs.getString("type"),
                rs.getString("category"),
                rs.getString("description"),
                rs.getDouble("price")
        );
        offer.setId(rs.getInt("id"));
        return offer;
    }
}
