package com.shcherbo.shop.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("SELECT orders FROM OrderEntity orders JOIN orders.user user WHERE orders.id=:id")
    Optional<OrderEntity> findOrderById(@Param("id")Long id);
}
