package com.example.cofee.Services.Interfeices;

import com.example.cofee.Entities.Hazelcast.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {

    public Order createOrder(List<Long> carts, Long card);
    public Order get(Integer id);
    public void finishOrder(Integer id);
    public List<Order> getAll();

}
