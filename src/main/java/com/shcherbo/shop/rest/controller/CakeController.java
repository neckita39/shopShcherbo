package com.shcherbo.shop.rest.controller;

import com.shcherbo.shop.goods.CakesService;
import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cakes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class CakeController {
    private final CakesService cakesService;


    @Autowired
    public CakeController(CakesService cakesService) {
        this.cakesService = cakesService;
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


}