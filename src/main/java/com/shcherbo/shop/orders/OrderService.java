package com.shcherbo.shop.orders;


import com.shcherbo.shop.rest.dto.Orders;
import com.shcherbo.shop.rest.dto.order.Order;
import com.shcherbo.shop.users.UserEntity;

public interface OrderService {
    void addOrder(Order order);

    Orders getOrders();

    Order getOrderById(Long id);

    void deleteOrderById(Long id);

    void changeOrder(Order order);

}