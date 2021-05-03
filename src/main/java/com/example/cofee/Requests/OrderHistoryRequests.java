package com.example.cofee.Requests;

import javax.persistence.Column;

/**
 * Сущность запроса к контроллеру истории заказов
 */
public class OrderHistoryRequests {

    private Long id;
    private String  serializedOrder;

    public OrderHistoryRequests() {
    }

    public OrderHistoryRequests(Long id, String serializedOrder) {
        this.id = id;
        this.serializedOrder = serializedOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerializedOrder() {
        return serializedOrder;
    }

    public void setSerializedOrder(String serializedOrder) {
        this.serializedOrder = serializedOrder;
    }
}
