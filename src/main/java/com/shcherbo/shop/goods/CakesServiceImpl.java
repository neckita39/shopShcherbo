package com.shcherbo.shop.goods;

import com.shcherbo.shop.exception.CakeNotFoundException;
import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cake.Cake;
import com.shcherbo.shop.rest.dto.Cakes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CakesServiceImpl implements CakesService {
    private final CakeRepository cakeRepository;

    @Autowired
    public CakesServiceImpl(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    @Override
    public Cakes getCakes() {
        List<CakeEntity> cakeEntityList = cakeRepository.findCakes();
        List<Cake> cakeList = cakeEntityList.stream().map(
                c -> {
                    Cake cake = new Cake();
                    cake.setId(c.getId());
                    cake.setCalories(c.getCalories());
                    cake.setName(c.getName());
                    cake.setImage(c.getImage());
                    cake.setPrice(c.getPrice());
                    cake.setWeight(c.getWeight());
                    return cake;
                }
        ).collect(Collectors.toList());
        Cakes cakes = new Cakes();
        cakes.setCakeList(cakeList);
        return cakes;
    }

    @Override
    public AdditionalInfo getCakeById(Long id) {
        return  cakeRepository.findOneCake(id)
                .map(cakeEntity -> {
                    AdditionalInfo additionalInfo=new AdditionalInfo();
                    additionalInfo.setId(cakeEntity.getId());
                    additionalInfo.setCalories(cakeEntity.getCalories());
                    additionalInfo.setName(cakeEntity.getName());
                    additionalInfo.setImage(cakeEntity.getImage());
                    additionalInfo.setPrice(cakeEntity.getPrice());
                    additionalInfo.setWeight(cakeEntity.getWeight());
                    additionalInfo.setComponents(cakeEntity.getComponents());
                    additionalInfo.setManufacturer(cakeEntity.getManufacturer());
                    additionalInfo.setShelflife(cakeEntity.getShelflife());
                    return additionalInfo;
                })
                .orElseThrow(() -> new CakeNotFoundException("No such cake"));
    }

    @Override
    public CakeEntity getCakeEntity(Long id) {
        return cakeRepository.findById(id).get();
    }

    @Override
    public void addCake(AdditionalInfo cake) {
        CakeEntity cakeEntity = new CakeEntity();
        cakeEntity.setCalories(cake.getCalories());
        cakeEntity.setImage(cake.getImage());
        ;
        cakeEntity.setName(cake.getName());
        cakeEntity.setPrice(cake.getPrice());
        cakeEntity.setWeight(cake.getWeight());
        cakeEntity.setComponents(cake.getComponents());
        cakeEntity.setManufacturer(cake.getManufacturer());
        cakeEntity.setShelflife(cake.getShelflife());
        cakeRepository.save(cakeEntity);
    }

    @Override
    public void deleteCakeById(Long id) {
        cakeRepository.deleteAllById(Collections.singleton(id));
    }

    @Override
    public void changeCake(Long id,  Cake cake) {
        System.out.println(id);
        cakeRepository.createCake(id, cake);
    }
}
