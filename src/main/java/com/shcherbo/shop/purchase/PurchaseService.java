package com.shcherbo.shop.purchase;

import com.shcherbo.shop.goods.CakeEntity;
import com.shcherbo.shop.orders.OrderEntity;
import com.shcherbo.shop.rest.dto.order.Order;
import com.shcherbo.shop.users.UserEntity;

public interface PurchaseService {
    public void addPurchase(OrderEntity orderEntity, CakeEntity cakeEntity, Integer number);
}
