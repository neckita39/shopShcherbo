package com.shcherbo.shop.goods;

import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cake.Cake;
import com.shcherbo.shop.rest.dto.Cakes;

public interface CakesService {
    Cakes getCakes();
    void addCake(AdditionalInfo cake);
    Cake getCakeById(Long id);
    void deleteCakeById(Long id);
    void changeCake(Long id, AdditionalInfo cake);
    //    CakeEntity getCakeEntity(Long id);
}
