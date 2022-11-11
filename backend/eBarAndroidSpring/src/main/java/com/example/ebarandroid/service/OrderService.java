package com.example.ebarandroid.service;

import com.example.ebarandroid.model.OrderModel;
import com.example.ebarandroid.model.StavkaModel;

import java.util.List;

public interface OrderService {
    public List<OrderModel> getOrderForTableId(int table_id);
    public OrderModel insertOrderForTable(Float ukupno,Integer table_id,String status, List<StavkaModel> stavke);
}
