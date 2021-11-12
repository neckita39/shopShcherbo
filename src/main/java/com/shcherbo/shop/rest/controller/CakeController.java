package com.shcherbo.shop.rest.controller;

import com.shcherbo.shop.goods.CakesService;
import com.shcherbo.shop.goods.CakesServiceImpl;
import com.shcherbo.shop.orders.OrderEntity;
import com.shcherbo.shop.orders.OrderService;
import com.shcherbo.shop.purchase.PurchaseService;
import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cake.Cake;
import com.shcherbo.shop.rest.dto.Cakes;
import com.shcherbo.shop.rest.dto.order.AdditionalInfoOrder;
import com.shcherbo.shop.rest.dto.purchase.Purchase;
import com.shcherbo.shop.users.UserEntity;
import com.shcherbo.shop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class CakeController {
    private final UserService userService;
    private final CakesService cakesService;
    private final PurchaseService purchaseService;
    private final OrderService orderService;


    @Autowired
    public CakeController(UserService userService, CakesService cakesService, PurchaseService purchaseService, OrderService orderService) {
        this.cakesService = cakesService;
        this.userService = userService;
        this.purchaseService = purchaseService;
        this.orderService = orderService;
    }



    @GetMapping(value = "cakes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cakes cakes() {
        return cakesService.getCakes();
    }

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdditionalInfo getCakeById(@PathVariable Long id) {
        return cakesService.getCakeById(id);
    }

    @PostMapping(path = "cakes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cake> createCake(@RequestBody @Valid AdditionalInfo newCake){
        cakesService.addCake(newCake);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "addOrder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdditionalInfoOrder> createOrder(@RequestBody @Valid AdditionalInfoOrder newOrder) {
        UserEntity userEntity = userService.addUser(newOrder.getUser());
        OrderEntity orderEntity = orderService.addOrder(newOrder.getOrder(),userEntity);
        for (Purchase purchase :newOrder.getPurchases()){
            purchaseService.addPurchase(orderEntity,cakesService.getCakeEntity(purchase.getCakeId()),purchase.getNumber());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}