package com.example.cofee.Services.Interfeices;

import com.example.cofee.Entities.Hazelcast.Order;
import com.example.cofee.Entities.SQL.OrderHistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderHistoryService {

    public OrderHistory pushOrderIntoHistory(Order order);
    public OrderHistory getOrderHistoryById(Long id);
    public List<OrderHistory> getAll();
}
