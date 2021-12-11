package com.shcherbo.shop.rest.controller;

import com.shcherbo.shop.goods.CakesService;
import com.shcherbo.shop.orders.OrderService;
import com.shcherbo.shop.purchase.PurchaseService;
import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cake.Cake;
import com.shcherbo.shop.rest.dto.Cakes;
import com.shcherbo.shop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class Admin {
    private final UserService userService;
    private final CakesService cakesService;
    private final PurchaseService purchaseService;
    private final OrderService orderService;

    @Autowired
    public Admin(UserService userService, CakesService cakesService, PurchaseService purchaseService, OrderService orderService) {
        this.cakesService = cakesService;
        this.userService = userService;
        this.purchaseService = purchaseService;
        this.orderService = orderService;
    }

    @RequestMapping(value = "/cakes")
    public String cakes(Model model) {
        List<Cake> cakes= cakesService.getCakes().getCakeList();
        model.addAttribute("cakes", cakes);
        return "cakes";
    }

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCakeById(@PathVariable Long id, Model model) {
        AdditionalInfo cake=cakesService.getCakeById(id);
        model.addAttribute("cake", cake);
        return "cake";
    }

    @GetMapping(value = "deletecake/{id}")
    public void deleteCakeById(@PathVariable Long id) throws Exception {
        if (!purchaseService.isCakePurchased(id)) {
            cakesService.deleteCakeById(id);
        }
    }
//    @PostMapping(path = "changecake", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Cake> createCake(@RequestBody @Valid AdditionalInfo additionalInfo, Long id){
//        cakesService.changeCake(additionalInfo, id);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }

}
