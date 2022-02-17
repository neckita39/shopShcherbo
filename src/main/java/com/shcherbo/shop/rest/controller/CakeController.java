package com.shcherbo.shop.rest.controller;

import com.shcherbo.shop.goods.CakesService;
import com.shcherbo.shop.orders.OrderService;
import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cake.Cake;
import com.shcherbo.shop.rest.dto.Cakes;
import com.shcherbo.shop.rest.dto.order.AdditionalInfoOrder;
import com.shcherbo.shop.rest.dto.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class CakeController {
    private final CakesService cakesService;
    private final OrderService orderService;


    @Autowired
    public CakeController(CakesService cakesService, OrderService orderService) {
        this.cakesService = cakesService;
        this.orderService = orderService;
    }

    @GetMapping(value = "cakes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cakes cakes() {

        System.out.println("get cakes");
        return cakesService.getCakes();
    }

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdditionalInfo getCakeById(@PathVariable Long id) {
        System.out.println("get cake");
        return cakesService.getCakeById(id);
    }

    @GetMapping(value = "/order/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping(value = "/upd/{id}")
    public void update(@PathVariable Long id, @RequestBody Cake cake) {
        cakesService.changeCake(id, cake);
    }

}