package com.example.cofee.Responces;

/**
 * Сущность ответа истории заказов
 */
public class OrderHistoryResponce extends AbstractResponse {
    private Long id;
    private String  serializedOrder;

    public OrderHistoryResponce() {
    }

    public OrderHistoryResponce(Long id, String serializedOrder) {
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
