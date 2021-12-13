package com.shcherbo.shop.rest.controller;

import com.shcherbo.shop.goods.CakesService;
import com.shcherbo.shop.orders.OrderEntity;
import com.shcherbo.shop.orders.OrderService;
import com.shcherbo.shop.purchase.PurchaseService;
import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Orders;
import com.shcherbo.shop.rest.dto.order.AdditionalInfoOrder;
import com.shcherbo.shop.rest.dto.order.Order;
import com.shcherbo.shop.rest.dto.purchase.Purchase;
import com.shcherbo.shop.users.UserEntity;
import com.shcherbo.shop.users.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")

public class Admin {

    private final OrderService orderService;
    private final CakesService cakesService;
    private final UserService userService;
    private final PurchaseService purchaseService;

    public Admin(OrderService orderService, CakesService cakesService,
                 UserService userService, PurchaseService purchaseService) {
        this.purchaseService=purchaseService;
        this.userService=userService;
        this.orderService = orderService;
        this.cakesService = cakesService;
    }

    @GetMapping(value = "/menu")
    public String getStart(Model model) {
        model.addAttribute("menu");
        return "menu";
    }

    @RequestMapping(value = "/changecake")
    public RedirectView changeCake(AdditionalInfo additionalInfo)
    {
        System.out.println("hey");
        cakesService.changeCake(additionalInfo);
        return new RedirectView("/admin/cakes");
    }
    @GetMapping(value = "/changecake/{id}")
    public ModelAndView getCakeEditForm(AdditionalInfo additionalInfo){
        ModelAndView modelAndView = new ModelAndView("editcake");
        modelAndView.addObject("cake", additionalInfo);
        return modelAndView;
    }
    @GetMapping(value = "/editorder/{id}")
    public ModelAndView getOrderEditForm(Order order){
        ModelAndView modelAndView = new ModelAndView("editorder");
        modelAndView.addObject("order", order);
        return modelAndView;
    }
    @RequestMapping(value = "/editorder")
    public RedirectView editOrder(Order order)
    {
        System.out.println("hey");
        orderService.changeOrder(order);
        return new RedirectView("/admin/orders");
    }
    @GetMapping(value = "/cakes")
    public String cakes(Model model) {
        model.addAttribute("cakes", cakesService.getCakes().getCakeList());
        return "cakes";
    }
    @GetMapping(value = "/orders")
    public String orders(Model model)
    {
        model.addAttribute("orders", orderService.getOrders().getOrderList());
        return "orders";
    }

    @GetMapping(value = "/cake/{id}")
    public String getCakeById(@PathVariable Long id, Model model) {
        model.addAttribute("cake", cakesService.getCakeById(id));
//        ModelAndView maw = new ModelAndView("cake");
//        maw.addObject("cake", cakesService.getCakeById(id));
        return "cake";
    }
    @GetMapping(value = "/order/{id}")
    public String getOrderById(@PathVariable Long id, Model model){
        model.addAttribute("order", orderService.getOrderById(id));
        return "order";
    }
    @GetMapping(value = "/cake/delete/{id}")
    public RedirectView deleteCakeById(@PathVariable Long id) {
        cakesService.deleteCakeById(id);
        return new RedirectView("/admin/cakes");
    }
    @GetMapping(value = "/order/delete/{id}")
    public RedirectView deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return new RedirectView("/admin/orders");
    }
    @PostMapping(path = "/cake/add")
    public RedirectView createCake(AdditionalInfo newCake) {
        System.out.println("1");
        cakesService.addCake(newCake);
        return new RedirectView("/admin/cakes");
    }
    @PostMapping(path = "addOrder")
    public RedirectView createOrder(AdditionalInfoOrder order, Model model) {
        UserEntity userEntity = userService.addUser(order.getUser());
        OrderEntity orderEntity = orderService.addOrder(order.getOrder(),userEntity);
        for (Purchase purchase :order.getPurchases()){
            purchaseService.addPurchase(orderEntity,cakesService.getCakeEntity(purchase.getCakeId()),purchase.getNumber());
        }
        return new RedirectView("/admin/orders");
    }
    @GetMapping(value = "/cake/add")
    public ModelAndView getCakeForm(){
        ModelAndView modelAndView = new ModelAndView("addcake");
        modelAndView.addObject("cake", new AdditionalInfo());
        return modelAndView;
    }
    @GetMapping(value = "/addOrder")
    public ModelAndView getOrderForm(){
        ModelAndView modelAndView = new ModelAndView("addorder");
        modelAndView.addObject("order", new AdditionalInfoOrder());
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
