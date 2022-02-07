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
public class CakesServiceImpl implements CakesService{
    private final CakeDAO cakeDAO;

    @Autowired
    public CakesServiceImpl(CakeDAO cakeDAO) {
        this.cakeDAO = cakeDAO;
    }
    @Override
    public Cakes getCakes(){
        List<CakeEntity> cakeEntityList=cakeDAO.getAll();
        List<Cake> cakeList=cakeEntityList.stream().map(
                c ->{
                    Cake cake= new Cake();
                    cake.setId(c.getId());
                    cake.setCalories(c.getCalories());
                    cake.setName(c.getName());
                    cake.setImage(c.getImage());
                    cake.setPrice(c.getPrice());
                    cake.setWeight(c.getWeight());
                    return cake;
                }
        ).collect(Collectors.toList());
        Cakes cakes=new Cakes();
        cakes.setCakeList(cakeList);
        return cakes;
    }
    @Override
    public Cake getCakeById(Long id){
        var cake=cakeDAO.get(id);
        var newCake=new Cake();
        newCake.setName(cake.getName());
        newCake.setPrice(cake.getPrice());
        newCake.setCalories(cake.getCalories());
        newCake.setImage(cake.getImage());
        newCake.setWeight(cake.getWeight());
        return newCake;
    }
    @Override
    public void addCake(AdditionalInfo cake){
        cakeDAO.create(cake);
    }
    @Override
    public void deleteCakeById(Long id)
    {
        cakeDAO.delete(id);
    }
    @Override
    public void changeCake(Long id,AdditionalInfo cake){
        cakeDAO.update(id, cake);
    }
    //    @Override
//    public CakeEntity getCakeEntity(Long id) {
//        return cakeRepository.findById(id).get();
//    }
}
