package com.shcherbo.shop.goods;


import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cake.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface CakeRepository extends JpaRepository<CakeEntity, Long> {
        @Query("SELECT cakes FROM CakeEntity cakes")
        List<CakeEntity> findCakes();

        @Query("SELECT cake FROM CakeEntity cake WHERE cake.id=:id")
        Optional<CakeEntity> findOneCake(@Param("id") Long id);

        @Modifying
        @Transactional
        @Query("UPDATE CakeEntity cake SET cake.calories=:calories," +
                " cake.image=:image,  cake.name=:name," +
                " cake.price=:price,cake.weight=:weight " +
                "WHERE cake.id=:id")
        void createCake(@Param("id") Long id, Cake cake);



}
