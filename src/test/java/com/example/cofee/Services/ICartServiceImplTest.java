package com.example.cofee.Services;

import com.example.cofee.Entities.SQL.Cart;
import com.example.cofee.Services.Interfeices.ICartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ICartServiceImplTest extends AbstractServiceTest {

    private ICartService iCartService;
    @Autowired
    public void setiCartService(ICartService iCartService) {
        this.iCartService = iCartService;
    }

    @Test
    void create() {
        Cart cart = iCartService.create("Cofee", "Good Cofee", 1000.12);
        assertNotNull(cart);
        assertEquals(1000.12,cart.getPrice());
        Cart cart1 = iCartService.create("Tea", "Good Tea", 1200.13);
        assertNotNull(cart1);
        assertEquals(1200.13,cart1.getPrice());
    }

    @Test
    void update() {
        Cart update = iCartService.update(Long.valueOf(1), "Cofee", "Good Cofee", 1200.12);
        assertNotNull(update);
        assertEquals(1200.12,update.getPrice());
    }


    @Test
    void getAll() {
        List<Cart> all = iCartService.getAll();
        assertNotEquals(0,all.size());
    }
}