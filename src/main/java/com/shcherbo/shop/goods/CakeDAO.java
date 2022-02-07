package com.shcherbo.shop.goods;

import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CakeDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void create(AdditionalInfo cake) {
        try {
            var statement=connection.createStatement();

            var SQL="INSERT INTO cake(name, calories, image, price, weight, components, manufacturer, shelflife) VALUES('" + cake.getName() +
                    "','" + cake.getCalories() +"','"
                    +cake.getImage()+"','"+cake.getPrice()+"','"+cake.getWeight()+"','"
                    +cake.getComponents()+"','"+cake.getManufacturer()+"','"+cake.getShelflife()+"')";
            statement.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public CakeEntity get(Long id) {
        var cake=new CakeEntity();
        try {
            var statement=connection.createStatement();
            var SQL= "SELECT * FROM cake WHERE id="+id;
            var resultSet=statement.executeQuery(SQL);
            while(resultSet.next()) {
                cake.setName(resultSet.getString("name"));
                cake.setImage(resultSet.getString("image"));
                cake.setCalories(resultSet.getBigDecimal("calories"));
                cake.setWeight(resultSet.getBigDecimal("weight"));
                cake.setPrice(resultSet.getBigDecimal("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cake;
    }

    public List<CakeEntity> getAll() {
        var cakes= new ArrayList<CakeEntity>();
        try {
            var statement=connection.createStatement();
            var SQL="SELECT * FROM cake";
            var resultSet=statement.executeQuery(SQL);

            while(resultSet.next()){
                var cake=new CakeEntity();
                cake.setId(resultSet.getLong("id"));
                cake.setName(resultSet.getString("name"));
                cake.setImage(resultSet.getString("image"));
                cake.setCalories(resultSet.getBigDecimal("calories"));
                cake.setWeight(resultSet.getBigDecimal("weight"));
                cake.setPrice(resultSet.getBigDecimal("price"));

                cakes.add(cake);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cakes;
    }

    public void update(Long id, AdditionalInfo cake) {
        System.out.println(1);
        try {
            var statement=connection.createStatement();

            var SQL="UPDATE cake " +
                    "SET name='"+cake.getName()+"',"+"calories='"+cake.getCalories()+"',"+"image='"+cake.getImage()+"',"+
                    "price='"+cake.getPrice()+"',"+"weight='"+cake.getWeight()+"',"+"components='"+cake.getComponents()+"',"+
                    "manufacturer='"+cake.getManufacturer()+"',"+"shelflife='"+cake.getShelflife()+"' WHERE id="+id;
            statement.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        try {
            var statement=connection.createStatement();
            var SQL= "DELETE FROM cake WHERE id="+id;
            statement.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
