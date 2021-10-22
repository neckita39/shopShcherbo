package com.shcherbo.shop.rest.controller;

import com.shcherbo.shop.dto.Cake;
import com.shcherbo.shop.dto.Cakes;
import com.shcherbo.shop.exception.CakeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class CakeController {
    private final Cakes cakeList = new Cakes();
    private static long idCounter = 0;


    public CakeController() {
        Cake cake1 = new Cake();
        idCounter++;
        cake1.setId(idCounter);
        cake1.setName("Napoleon");
        cake1.setPrice(new BigDecimal(100));
        cake1.setWeight(new BigDecimal(100));
        cake1.setImage("cake1.jpg");
        cake1.setCalories(new BigDecimal(100));
        Cake cake2 = new Cake();
        idCounter++;
        cake2.setId(idCounter);
        cake2.setName("Rose");
        cake2.setPrice(new BigDecimal(200));
        cake2.setWeight(new BigDecimal(200));
        cake2.setImage("cake1.jpg");
        cake2.setCalories(new BigDecimal(200));
        List<Cake> tmp = new ArrayList<Cake>();
        tmp.add(cake1);
        tmp.add(cake2);
        cakeList.setCakeList(tmp);
    }

    @GetMapping(value = "cakes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cakes cakes() {
        return cakeList;
    }

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cake getCakeById(@PathVariable Long id) {
        return cakeList.getCakeList().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CakeNotFoundException("No such cake"));
    }

    //хотел сделать через @valid, но не разобрался, закомментил мои догадки

    //@RequestMapping (path="cakes", headers = "id")
    @PostMapping(path = "cakes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cake> createCake(/*@Valid*/ @RequestBody Cake newCake/*, BindingResult bindingResult*/){
        //  if (bindingResult.hasErrors()) {
        //      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        //  } else {
        //      cakeList.getCakeList().add(newCake);
        //      return new ResponseEntity<>(HttpStatus.CREATED);
        //  }
        //сделал по простому

        if (newCake.getName()==null || newCake.getPrice()==null || newCake.getImage()==null || newCake.getWeight()==null
                || newCake.getCalories()==null || newCake.getId()==null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }else {
            cakeList.getCakeList().add(newCake);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

    }

}