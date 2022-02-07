package com.shcherbo.shop.goods;

import com.shcherbo.shop.rest.dto.Cake.Cake;
import com.shcherbo.shop.rest.dto.Cakes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CakeMapper implements RowMapper<CakeEntity> {
    @Override
    public CakeEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var cake=new CakeEntity();
        cake.setName(resultSet.getString("name"));
        cake.setImage(resultSet.getString("image"));
        cake.setCalories(resultSet.getBigDecimal("calories"));
        cake.setWeight(resultSet.getBigDecimal("weight"));
        cake.setPrice(resultSet.getBigDecimal("price"));
        return cake;
    }
}
