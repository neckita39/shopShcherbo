package com.shcherbo.shop.orders;

import com.shcherbo.shop.goods.CakeEntity;
import com.shcherbo.shop.purchase.PurchaseEntity;
import com.shcherbo.shop.rest.dto.Orders;
import com.shcherbo.shop.rest.dto.order.AdditionalInfoOrder;
import com.shcherbo.shop.rest.dto.order.Order;
import com.shcherbo.shop.rest.dto.statuses.Delivery;
import com.shcherbo.shop.rest.dto.statuses.OrderStatus;
import com.shcherbo.shop.rest.dto.statuses.Payment;
import com.shcherbo.shop.users.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDAO {

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
    public List<OrderEntity> getAllOrders(){
        var orders= new ArrayList<OrderEntity>();
        try {
            var statement=connection.createStatement();
            var SQL="SELECT * FROM orderinfo";
            var resultSet=statement.executeQuery(SQL);

            while(resultSet.next()){
                var order=new OrderEntity();
                var user=new UserEntity();
                var purchase=new PurchaseEntity();
                user.setId(resultSet.getLong("user_id"));
                order.setUser(user);
                order.setId(resultSet.getLong("id"));

                String valueDel=Delivery.NO.getValue((Integer) resultSet.getObject("delivery"));
                order.setDelivery(Delivery.valueOf(valueDel));

                String valueStat=OrderStatus.NEW.getValue((Integer) resultSet.getObject("status"));
                order.setStatus(OrderStatus.valueOf(valueStat));

                String valuePay=Payment.ONLINE.getValue((Integer) resultSet.getObject("payment"));
                order.setPayment(Payment.valueOf(valuePay));


                order.setDeliveryAddress(resultSet.getString("delivery_address"));
                order.setDeliveryTime(resultSet.getString("delivery_time"));
                orders.add(order);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void createOrder(Order order)
    {
        try {
            var statement=connection.createStatement();

            var SQL="INSERT INTO orderinfo(delivery, delivery_address, payment, status, user_id) VALUES ('"+order.getDelivery().ordinal()+"','"+
            order.getDeliveryAddress()+"','"+order.getPayment().ordinal()+
            "','"+order.getOrderStatus().ordinal()+"','"+order.getUserID()+"')";
            statement.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
