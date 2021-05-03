package com.example.cofee.Entities.SQL;

import javax.persistence.*;

/**
 * Сущность истории заказов
 */
@Entity
@Table(name = "orders")
@Cacheable
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sorder")
    private String  serializedOrder;

    public OrderHistory() {
    }

    public OrderHistory(String serializedOrder) {
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
