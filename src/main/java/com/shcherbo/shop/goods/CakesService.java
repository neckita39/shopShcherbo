package com.shcherbo.shop.goods;

import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cake.Cake;
import com.shcherbo.shop.rest.dto.Cakes;
import org.springframework.web.bind.annotation.RequestBody;

public interface CakesService {
    CakeEntity getCakeEntity(Long id);
    void addCake(AdditionalInfo cake);
    Cakes getCakes();
    AdditionalInfo getCakeById(Long id);
    void deleteCakeById(Long id);
    void changeCake(Long id,  Cake cake);
}
