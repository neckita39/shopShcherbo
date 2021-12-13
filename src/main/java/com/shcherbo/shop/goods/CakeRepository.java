package com.shcherbo.shop.goods;

import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CakeRepository extends JpaRepository<CakeEntity, Long> {
    boolean existsByName(String name);
}
