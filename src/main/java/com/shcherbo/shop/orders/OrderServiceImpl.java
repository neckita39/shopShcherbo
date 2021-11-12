package com.shcherbo.shop.orders;

import com.shcherbo.shop.rest.dto.order.Order;
import com.shcherbo.shop.users.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    public OrderEntity addOrder(Order order, UserEntity user){
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setDelivery(order.getDelivery());
        orderEntity.setStatus(order.getOrderStatus());
        orderEntity.setDeliveryAddress(order.getDeliveryAddress());
        orderEntity.setPayment(order.getPayment());
        orderEntity.setUser(user);
        orderEntity.setDeliveryTime(order.getDeliveryTime());
        return orderRepository.saveAndFlush(orderEntity);
    }

}
