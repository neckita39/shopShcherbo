package com.shcherbo.shop.goods;

import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cake.Cake;
import com.shcherbo.shop.rest.dto.Cakes;

public interface CakesService {
    CakeEntity getCakeEntity(Long id);
    Long addCake(AdditionalInfo cake);
    Cakes getCakes();
    AdditionalInfo getCakeById(Long id);
    Object deleteCakeById(Long id);
    void changeCake(AdditionalInfo additionalInfo, Long id);
}
