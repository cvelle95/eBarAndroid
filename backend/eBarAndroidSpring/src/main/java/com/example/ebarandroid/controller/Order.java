package com.example.ebarandroid.controller;


import com.example.ebarandroid.model.OrderModel;
import com.example.ebarandroid.model.StavkaModel;
import com.example.ebarandroid.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class Order {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("getorderfortable")
    @CrossOrigin(origins = "*")
    public List<OrderModel> getOrderForTableId(int table_id){
        return orderService.getOrderForTableId(table_id);
    }

    @PostMapping("insertorder")
    public OrderModel insertOrderForTable(Float ukupno,Integer table_id,String status,List<StavkaModel> stavke){
        return orderService.insertOrderForTable(ukupno,table_id,status,stavke);
    }

}
