package com.shcherbo.shop.purchase;
import com.shcherbo.shop.goods.CakeEntity;
import com.shcherbo.shop.orders.OrderEntity;

public interface PurchaseService {
    void addPurchase(OrderEntity orderEntity, CakeEntity cakeEntity, Integer number);
    boolean isCakePurchased(Long id);
}
