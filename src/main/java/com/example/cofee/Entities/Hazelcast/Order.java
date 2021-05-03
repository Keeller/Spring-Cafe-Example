package com.example.cofee.Entities.Hazelcast;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Сущность заказа
 */
public class Order implements Serializable {


    private Long id;
    private List<Long> cartId;
    private Long cardId;
    private Double amount;

    public Order() {
    }

    public Order( List<Long> cartId, Long cardId, Double amount) {
        this.cartId = cartId;
        this.cardId = cardId;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getCartId() {
        return cartId;
    }

    public void setCartId(List<Long> cartId) {
        this.cartId = cartId;
    }


    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
