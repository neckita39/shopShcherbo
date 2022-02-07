package com.shcherbo.shop.rest.controller;

import com.shcherbo.shop.goods.CakeDAO;
import com.shcherbo.shop.goods.CakesService;
import com.shcherbo.shop.orders.OrderService;
import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cake.Cake;
import com.shcherbo.shop.rest.dto.Cakes;
import com.shcherbo.shop.rest.dto.Orders;
import com.shcherbo.shop.rest.dto.order.AdditionalInfoOrder;
import com.shcherbo.shop.rest.dto.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jbdc")
public class JDBCController {


    private final CakesService cakesService;
    private final OrderService orderService;

    @Autowired
    public JDBCController(CakesService cakesService, OrderService orderService){

        this.cakesService=cakesService;
        this.orderService=orderService;
    }
    @PostMapping()
    public void create(@RequestBody AdditionalInfo cake){
        cakesService.addCake(cake);
    }

    @GetMapping("/{id}")
    public Cake get(@PathVariable Long id){
        return cakesService.getCakeById(id);
    }

    @GetMapping()
    public Cakes getAll(){
        return cakesService.getCakes();
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AdditionalInfo cake){
        cakesService.changeCake(id, cake);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cakesService.deleteCakeById(id);
    }

    @GetMapping("/orders")
    public Orders getAllOrders(){
        return orderService.getOrders();
    }

    @PostMapping("/orders")
    public void createOrder(@RequestBody Order order)
    {
        orderService.addOrder(order);
    }

}
