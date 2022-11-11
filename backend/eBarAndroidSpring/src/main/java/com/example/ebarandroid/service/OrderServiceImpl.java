package com.example.ebarandroid.service;

import com.example.ebarandroid.model.OrderModel;
import com.example.ebarandroid.model.StavkaModel;
import com.example.ebarandroid.repository.OrderRepository;
import com.example.ebarandroid.repository.StavkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service()
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    private StavkaRepository stavkaRepository;

    @Override
    public List<OrderModel> getOrderForTableId(int table_id){
        return orderRepository.getOrderForTableId(table_id);
    }

    @Override
    public OrderModel insertOrderForTable(Float ukupno,Integer table_id,String status, List<StavkaModel> stavke){
        OrderModel orderModelSaved = new OrderModel(ukupno,table_id,status);
        orderRepository.save(orderModelSaved);
        for(StavkaModel stavka:stavke){
            stavka.setOrder_id(orderModelSaved.getId());
            stavkaRepository.save(stavka);
        }
        return orderModelSaved;
    }
}
