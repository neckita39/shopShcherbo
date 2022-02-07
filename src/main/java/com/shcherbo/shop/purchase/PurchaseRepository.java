package com.shcherbo.shop.purchase;

import org.springframework.data.jpa.repository.JpaRepository;

interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
}
