package com.shcherbo.shop.rest.controller;

import com.shcherbo.shop.goods.CakesService;
import com.shcherbo.shop.orders.OrderEntity;
import com.shcherbo.shop.orders.OrderService;
import com.shcherbo.shop.purchase.PurchaseService;
import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.order.AdditionalInfoOrder;
import com.shcherbo.shop.rest.dto.order.Order;
import com.shcherbo.shop.rest.dto.purchase.Purchase;
import com.shcherbo.shop.users.UserEntity;
import com.shcherbo.shop.users.UserService;
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
    private final UserService userService;
    private final PurchaseService purchaseService;

    public Admin(OrderService orderService, CakesService cakesService,
                 UserService userService, PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
        this.userService = userService;
        this.orderService = orderService;
        this.cakesService = cakesService;
    }

    @GetMapping(value = "/menu")
    public String getMenu(Model model) {
        model.addAttribute("menu");
        return "menu";
    }

    @PostMapping(value = "/editcake")//Request
    public RedirectView editCake(AdditionalInfo additionalInfo) {
        cakesService.changeCake(additionalInfo);
        return new RedirectView("/admin/cakes");
    }

    @GetMapping(value = "/editcake/{id}")
    public ModelAndView getCakeEditForm(AdditionalInfo additionalInfo) {
        ModelAndView modelAndView = new ModelAndView("editcake");
        modelAndView.addObject("cake", additionalInfo);
        return modelAndView;
    }

    @GetMapping(value = "/editorder/{id}")
    public ModelAndView getOrderEditForm(Order order) {
        ModelAndView modelAndView = new ModelAndView("editorder");
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    @PostMapping(value = "/editorder")//Request
    public RedirectView editOrder(Order order) {
        orderService.changeOrder(order);
        return new RedirectView("/admin/orders");
    }

    @GetMapping(value = "/cakes")
    public String getCakes(Model model) {
        model.addAttribute("cakes", cakesService.getCakes().getCakeList());
        return "cakes";
    }

    @GetMapping(value = "/orders")
    public String getOrders(Model model) {
        model.addAttribute("orders", orderService.getOrders().getOrderList());
        return "orders";
    }

    @GetMapping(value = "/cake/{id}")
    public String getCakeById(@PathVariable Long id, Model model) {
        model.addAttribute("cake", cakesService.getCakeById(id));
        return "cake";
    }

    @GetMapping(value = "/order/{id}")
    public String getOrderById(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        return "order";
    }

    @GetMapping(value = "/deletecake/{id}")
    public RedirectView deleteCakeById(@PathVariable Long id) {
        cakesService.deleteCakeById(id);
        return new RedirectView("/admin/cakes");
    }

    @GetMapping(value = "/deleteorder/{id}")
    public RedirectView deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return new RedirectView("/admin/orders");
    }

    @PostMapping(path = "/addcake")
    public RedirectView addCake(AdditionalInfo newCake) {
        System.out.println("1");
        cakesService.addCake(newCake);
        return new RedirectView("/admin/cakes");
    }

    @PostMapping(path = "addorder")
    public RedirectView addOrder(AdditionalInfoOrder order, Model model) {
        UserEntity userEntity = userService.addUser(order.getUser());
        OrderEntity orderEntity = orderService.addOrder(order.getOrder(), userEntity);
        for (Purchase purchase : order.getPurchases()) {
            purchaseService.addPurchase(orderEntity, cakesService.getCakeEntity(purchase.getCakeId()), purchase.getNumber());
        }
        return new RedirectView("/admin/orders");
    }

    @GetMapping(value = "/addcake")
    public ModelAndView getCakeAddForm() {
        ModelAndView modelAndView = new ModelAndView("addcake");
        modelAndView.addObject("cake", new AdditionalInfo());
        return modelAndView;
    }

    @GetMapping(value = "/addorder")
    public ModelAndView getOrderAddForm() {
        ModelAndView modelAndView = new ModelAndView("addorder");
        modelAndView.addObject("order", new AdditionalInfoOrder());
        return modelAndView;
    }

}

