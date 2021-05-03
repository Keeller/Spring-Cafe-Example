package com.example.cofee.Services;

import com.example.cofee.Entities.Hazelcast.Order;
import com.example.cofee.Entities.SQL.OrderHistory;
import com.example.cofee.Repositories.OrderHistoryRepository;
import com.example.cofee.Services.Interfeices.IOrderHistoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис работы с историей заказов
 */
@Service
public class IOrderHistoryServiceImpl implements IOrderHistoryService {

    private OrderHistoryRepository orderHistoryRepository;

    @Autowired
    public void setOrderHistoryRepository(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

    /**
     * Сериализовать заказ
     * @param order заказ
     * @return JSON строка заказа
     * @throws JsonProcessingException ошибка зписи в json
     */
   protected String serializeOrder(Order order) throws JsonProcessingException {
       ObjectMapper objectMapper=new ObjectMapper();
       return objectMapper.writeValueAsString(order);
   }

    /**
     * Обратное преобразование объекта
     * @param json сериализованный объект
     * @return заказ
     * @throws JsonProcessingException ошибка чтения заказ
     */
   public Order deserializeOrder(String json) throws JsonProcessingException {
       ObjectMapper objectMapper=new ObjectMapper();
       return objectMapper.readValue(json,Order.class);
   }

    /**
     * Поместить задачу в историю
     * @param order обрабатываеммый заказ
     * @return объект истории заказа
     */
    @Override
    public OrderHistory pushOrderIntoHistory(Order order) {

        try {
            return orderHistoryRepository.save(new OrderHistory(serializeOrder(order)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Получить заказ из истории по айдишнику
     * @param id айдишник
     * @return объект истории
     */
    @Override
    public OrderHistory getOrderHistoryById(Long id) {
        return orderHistoryRepository.findById(id).orElseThrow();
    }

    /**
     * Получить все объекты истории
     * @return список объектов истории
     */
    @Override
    public List<OrderHistory> getAll() {
        return orderHistoryRepository.findAll();
    }
}
