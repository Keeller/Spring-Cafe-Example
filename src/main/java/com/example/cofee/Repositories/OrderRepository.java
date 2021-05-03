package com.example.cofee.Repositories;

import com.example.cofee.Entities.Hazelcast.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий заказа
 */
@Repository
public interface OrderRepository {
    public List<Order> getAll();
    public Order get(Integer id);
    public Order create(Order order);
    public Order update(Order order);
    public void  delete(Integer id);
}
