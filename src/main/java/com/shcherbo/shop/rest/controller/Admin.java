package com.shcherbo.shop.rest.controller;

import com.shcherbo.shop.goods.CakesService;
import com.shcherbo.shop.orders.OrderService;
import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")

public class Admin {

    private final OrderService orderService;
    private final CakesService cakesService;

    public Admin(OrderService orderService, CakesService cakesService) {
        this.orderService = orderService;
        this.cakesService = cakesService;
    }

    @GetMapping(value = "/start")
    public ModelAndView getStart() {
        ModelAndView maw = new ModelAndView("start");
        return maw;
    }


    @GetMapping(value = "/cakes")
    public String cakes(Model model) {
        model.addAttribute("cakes", cakesService.getCakes().getCakeList());
//        ModelAndView modelAndView = new ModelAndView("cakes");
//        modelAndView.addObject("cakes", cakesService.getCakes().getCakeList());
        return "cakes";
    }


    @GetMapping(value = "cake/{id}")
    public String getCakeById(@PathVariable Long id, Model model) {
        model.addAttribute("cake", cakesService.getCakeById(id));
//        ModelAndView maw = new ModelAndView("cake");
//        maw.addObject("cake", cakesService.getCakeById(id));
        return "cake";
    }

    @GetMapping(value = "/cake/delete/{id}")
    public RedirectView deleteCakeById(@PathVariable Long id) {
        cakesService.deleteCakeById(id);
        return new RedirectView("/admin/cakes");
    }

    @PostMapping(path = "/cake/add")
    public RedirectView createCake(AdditionalInfo newCake) {
        System.out.println("1");
        Long id=cakesService.addCake(newCake);
        return new RedirectView("/admin/cakes");
    }
    @GetMapping(value = "/cake/add")
    public ModelAndView getCakeForm(){
        ModelAndView modelAndView = new ModelAndView("addcake");
        modelAndView.addObject("cake", new AdditionalInfo());
        return modelAndView;
    }

}


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequestMapping("/admin")
//public class Admin {
//    private final UserService userService;
//    private final CakesService cakesService;
//    private final PurchaseService purchaseService;
//    private final OrderService orderService;
//
//    @Autowired
//    public Admin(UserService userService, CakesService cakesService, PurchaseService purchaseService, OrderService orderService) {
//        this.cakesService = cakesService;
//        this.userService = userService;
//        this.purchaseService = purchaseService;
//        this.orderService = orderService;
//    }
//
//    @GetMapping(value = "/cakes")
//    public String cakes(Model model) {
//        List<Cake> cakes= cakesService.getCakes().getCakeList();
//        model.addAttribute("cakes", cakes);
//        return "cakes";
//    }
//
//    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String getCakeById(@PathVariable Long id, Model model) {
//        AdditionalInfo cake=cakesService.getCakeById(id);
//        model.addAttribute("cake", cake);
//        return "cake";
//    }
//
//    @GetMapping(value = "deletecake/{id}")
//    public String deleteCakeById(@PathVariable Long id, Model model) {
//        if (purchaseService.isCakePurchased(id)) {
//            model.addAttribute("cake", cakesService.deleteCakeById(id));
//            return "cake";
//        }
//        List<Cake> cakes= cakesService.getCakes().getCakeList();
//        model.addAttribute("cakes", cakes);
//        return "cakes";
//    }
//    @PostMapping(path = "/cake/edit")
//    public RedirectView createCake(AdditionalInfo newCake){
//        System.out.println("1");
//        cakesService.addCake(newCake);
//        return new RedirectView("/admin/cakes");
//    }
////    @PostMapping(path = "changecake", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
////    public ResponseEntity<Cake> createCake(@RequestBody @Valid AdditionalInfo additionalInfo, Long id){
////        cakesService.changeCake(additionalInfo, id);
////        return new ResponseEntity<>(HttpStatus.ACCEPTED);
////    }
//
//}
