package com.shcherbo.shop.orders;

import com.shcherbo.shop.exception.CakeNotFoundException;
import com.shcherbo.shop.rest.dto.Orders;
import com.shcherbo.shop.rest.dto.order.Order;
import com.shcherbo.shop.rest.dto.user.User;
import com.shcherbo.shop.users.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @Override
    public Orders getOrders()
    {
        List<OrderEntity> orderEntityList=orderRepository.findAll();
        List<Order> orderList=orderEntityList.stream().map(
                c ->{
                    Order order= new Order();
                    order.setDelivery(c.getDelivery());
                    order.setDeliveryAddress(c.getDeliveryAddress());
                    order.setOrderStatus(c.getStatus());
                    order.setPayment(c.getPayment());
                    order.setUserID(c.getUser().getId());
                    order.setId(c.getId());
                    return order;
                }
        ).collect(Collectors.toList());
        Orders orders=new Orders();
        orders.setOrderList(orderList);
        return orders;

    }
    @Override
    public Order getOrderById(Long id){
        return  orderRepository.findOrderById(id)
                .map(c -> {
                    User user=new User();
                    user.setName(c.getUser().getName());
                    //проверка что запрос работает как надо
                    System.out.println(user.getName());
                    Order order=new Order();
                    order.setDelivery(c.getDelivery());
                    order.setOrderStatus(c.getStatus());
                    order.setDeliveryAddress(c.getDeliveryAddress());
                    order.setPayment(c.getPayment());
                    order.setDeliveryTime(c.getDeliveryTime());
                    order.setUserID(c.getUser().getId());
                    order.setId(c.getId());
                    return order;
                })
                .orElseThrow(() -> new CakeNotFoundException("No such cake"));
    }
    @Override
    public void deleteOrderById(Long id){
        orderRepository.deleteAllById(Collections.singleton(id));
    }
    @Override
    public  void changeOrder(Order order)
    {
        OrderEntity orderEntity=orderRepository.getById(order.getId());
        orderEntity.setDelivery(order.getDelivery());
        orderEntity.setStatus(order.getOrderStatus());
        orderEntity.setDeliveryAddress(order.getDeliveryAddress());
        orderEntity.setPayment(order.getPayment());
        orderEntity.setDeliveryTime(order.getDeliveryTime());
        orderRepository.save(orderEntity);
    }


}
