package com.shcherbo.shop.goods;

import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class CakeDAOTempl {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CakeDAOTempl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(AdditionalInfo cake) {
        jdbcTemplate.update("INSERT INTO cake(calories, components, image, manufacturer, name, price, shelflife, weight) VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
                cake.getCalories(), cake.getComponents(), cake.getImage(), cake.getManufacturer(),
                cake.getName(), cake.getPrice(), cake.getShelflife(), cake.getWeight());

    }

    public CakeEntity get(Long id) {
        return (CakeEntity)
                jdbcTemplate.query("SELECT * FROM cake WHERE id= ?", new CakeMapper(), id).stream().findFirst().orElse(null);
    }

    public List<CakeEntity> getAll() {
        return jdbcTemplate.query("SELECT * FROM cake", new CakeMapper());
    }

    public void update(Long id, AdditionalInfo cake) {
        jdbcTemplate.update("UPDATE cake SET calories=?, components=?, image=?, manufacturer=?, name=?, price=?,shelflife=?,weight=? WHERE id=?",
                cake.getCalories(), cake.getComponents(), cake.getImage(), cake.getManufacturer(),
                cake.getName(), cake.getPrice(), cake.getShelflife(), cake.getWeight(), id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM cake WHERE id=?", new BeanPropertyRowMapper<>(CakeEntity.class), id);
    }
}
