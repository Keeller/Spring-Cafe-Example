package com.example.cofee.Responces;

import java.util.List;

/**
 * Сущность ответа заказа
 */
public class OrderResponce extends AbstractResponse {

    private Long id;
    private List<Long> cartId;
    private Long cardId;
    private Double amount;

    public OrderResponce() {
    }

    public OrderResponce(Long id, List<Long> cartId, Long cardId, Double amount) {
        this.id = id;
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
}
