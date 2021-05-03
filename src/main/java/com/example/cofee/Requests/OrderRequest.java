package com.example.cofee.Requests;

import com.example.cofee.Responces.AbstractResponse;

import java.util.List;
/**
 * Сущность запроса к заказов
 */
public class OrderRequest extends AbstractResponse {

    private Long id;
    private List<Long> cartId;
    private Long cardId;

    public OrderRequest() {
    }

    public OrderRequest(Long id, List<Long> cartId, Long cardId) {
        this.id = id;
        this.cartId = cartId;
        this.cardId = cardId;
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
}
