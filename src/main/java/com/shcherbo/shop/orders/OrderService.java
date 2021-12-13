package com.shcherbo.shop.orders;


import com.shcherbo.shop.rest.dto.Orders;
import com.shcherbo.shop.rest.dto.order.Order;
import com.shcherbo.shop.users.UserEntity;

public interface OrderService {
    OrderEntity addOrder(Order order, UserEntity user);

    Orders getOrders();

    Order getOrderById(Long id);

    void deleteOrderById(Long id);

    void changeOrder(Order order);

}