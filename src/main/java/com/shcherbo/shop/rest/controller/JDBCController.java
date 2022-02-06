package com.shcherbo.shop.rest.controller;

import com.shcherbo.shop.rest.dao.CakeDAO;
import com.shcherbo.shop.rest.dto.Cake.AdditionalInfo;
import com.shcherbo.shop.rest.dto.Cake.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jbdc")
public class JDBCController {


    private final CakeDAO cakeDAO;

    @Autowired
    public JDBCController(CakeDAO cakeDAO){
        this.cakeDAO=cakeDAO;
    }
    @PostMapping()
    public void create(@RequestBody AdditionalInfo cake){
        cakeDAO.create(cake);
    }

    @GetMapping("/{id}")
    public Cake get(@PathVariable int id){
        return cakeDAO.get(id);
    }

    @GetMapping()
    public List<Cake> getAll(){
        return cakeDAO.getAll();
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody AdditionalInfo cake){
        cakeDAO.update(id, cake);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        cakeDAO.delete(id);
    }




}
