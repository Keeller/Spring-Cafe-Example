package com.example.cofee.RepositoriesImpl;

import com.example.cofee.Entities.Hazelcast.Order;
import com.example.cofee.Repositories.OrderRepository;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Ручная реализация репозитория для работы с IMDG Hazelcast
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private HazelcastInstance hazelcastInstance;

    @Autowired
    public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    /**
     * Получить все записи
     * @return список записей
     */
    @Override
    public List<Order> getAll() {
        Map<Long,Order> map=hazelcastInstance.getMap("data");
        return new ArrayList<>(map.values());
    }

    /**
     * Получить заказ по айдишнику
     * @param id айдишник
     * @return заказ
     */
    @Override
    public Order get(Integer id) {
        return (Order) hazelcastInstance.getMap("data").get(Long.valueOf(id));
    }

    /**
     * Создать заказ
     * @param order заказ на создание
     * @return созданный заказ
     */
    @Override
    public Order create(Order order) {
        Map<Long,Order> map = hazelcastInstance.getMap("data");
        Long id=Long.valueOf(1);
        if(!map.isEmpty())
            id = map.keySet().stream().max(Long::compare).get()+1;
        order.setId(id);
        (map).putIfAbsent(id,order);
        return map.get(id);
    }

    /**
     * Обновить заказ
     * @param order заказ на обновление
     * @return созданный заказ
     */
    @Override
    public Order update(Order order) {
        Map<Long,Order> map = hazelcastInstance.getMap("data");
        if (map.containsKey(order.getId())) {
            (map).put(order.getId(), order);
            return map.get(order.getId());
        }
        else
            return null;
    }

    /**
     * Удалить заказ по айдишнику
     * @param id айдишник
     */
    @Override
    public void delete(Integer id) {
        Map<Long,Order> map=hazelcastInstance.getMap("data");
        map.remove(Long.valueOf(id));

    }
}
