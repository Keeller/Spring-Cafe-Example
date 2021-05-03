package com.example.cofee.Services;

import com.example.cofee.Entities.Hazelcast.Order;
import com.example.cofee.Services.Interfeices.IOrderHistoryService;
import com.example.cofee.Services.Interfeices.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ToDo: Тесты хорошо бы написать на разные ситуации.
 */
class OrderServiceImplTest extends AbstractServiceTest {

    private IOrderService iOrderService;
    @Autowired
    public void setiOrderService(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }


    @Test
    void testOrder() {
        List<Long> longs = new ArrayList<>();
        longs.add(1L);
        longs.add(2L);
        Order order = iOrderService.createOrder(longs, 1L);
        assertNotNull(order);
        assertNotEquals(0,order.getCartId().size());
        assertEquals(1L,order.getCardId());
        List<Order> all = iOrderService.getAll();
        assertNotEquals(0,all.size());
        iOrderService.finishOrder(1);
        List<Order> all1 = iOrderService.getAll();
        assertEquals(0,all1.size());
    }


}