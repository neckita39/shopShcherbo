package com.shcherbo.shop.orders;

import com.shcherbo.shop.exception.CakeNotFoundException;
import com.shcherbo.shop.goods.CakeEntity;
import com.shcherbo.shop.goods.CakeRepository;
import com.shcherbo.shop.purchase.PurchaseEntity;
import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cake.Cake;
import com.shcherbo.shop.rest.dto.Cakes;
import com.shcherbo.shop.rest.dto.Orders;
import com.shcherbo.shop.rest.dto.order.AdditionalInfoOrder;
import com.shcherbo.shop.rest.dto.order.Order;
import com.shcherbo.shop.users.UserEntity;
import com.shcherbo.shop.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final CakeRepository cakeRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CakeRepository cakeRepository,
                            UserRepository userRepository){
        this.cakeRepository=cakeRepository;
        this.orderRepository = orderRepository;
        this.userRepository=userRepository;
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
        return  orderRepository.findById(id)
                .map(c -> {
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
