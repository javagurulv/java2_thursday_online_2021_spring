package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.Lot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//@Component
public class JdbcLotRepositoryImpl implements LotRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveLot(Lot lot) {
        jdbcTemplate.update(
                "INSERT INTO user_lots (name,start_price,user_id) "
                        + "VALUES (?, ? ,?)",
                lot.getName(),lot.getStartPrice(),lot.getUserID());

    }
    @Override
    public boolean deleteLotById(Long id) {
        String sql = "DELETE FROM user_lots WHERE id = ?";
        Object[] args = new Object[] {id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<Lot> getAllLots() {
        String sql = "SELECT * FROM user_lots";
        return jdbcTemplate.query(sql,new LotRowMapper());
    }


    @Override
    public List<Lot> searchByName(String name) {
        String sql = "SELECT * FROM user_lots"+" WHERE name LIKE '%?%'";
        Object[] args = new Object[]{name};
        return jdbcTemplate.query(sql,args,new LotRowMapper());
    }

    @Override
    public List<Lot> searchByPrice(BigDecimal price) {
        String sql = "SELECT * FROM user_lots"+" WHERE start_price LIKE '%?%'";
        Object[] args = new Object[]{price};
        return jdbcTemplate.query(sql,args,new LotRowMapper());
    }

    @Override
    public List<Lot> searchByNameAndPrice(String name, BigDecimal price) {
        String sql = "SELECT * FROM user_lots WHERE"+
                " name LIKE ? AND start_price LIKE ?";
        Object[] args = new Object[] {name, price};
        return jdbcTemplate.query(sql,args,new LotRowMapper());
    }

    @Override
    public Optional<Lot> getById(Long id) {
        return Optional.empty();
    }
}
