package com.example.cofee.Services;

import com.example.cofee.Entities.SQL.Cards;
import com.example.cofee.Services.Interfeices.ICardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ICardServiceImplTest extends AbstractServiceTest {
    private ICardService iCardService;
    @Autowired
    public void setiCardService(ICardService iCardService) {
        this.iCardService = iCardService;
    }

    @Test
    void create() {
        Cards cards = iCardService.create("8080-555-35-35", 20.2, "Vasya", "Pupkin", "Vasilyevich");
        assertNotNull(cards);
        assertEquals(20.2,cards.getDiscount());

    }

    @Test
    void update() {
        Cards update = iCardService.update(Long.valueOf(1), "8080-555-35-35", 20.5, "Vasya", "Pupkin", "Vasilyevich");
        assertNotNull(update);
        assertEquals(20.5,update.getDiscount());
    }

    @Test
    void getAll() {
        List<Cards> all = iCardService.getAll();
        assertNotEquals(0,all.size());
    }
}