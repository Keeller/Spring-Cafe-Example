package com.example.cofee.Entities.SQL;

import javax.persistence.*;

/**
 * Сущность карты
 */
@Entity
@Table(name="cards")
@Cacheable
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_num")
    private String cardNum;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "client_sername")
    private String clientSername;
    @Column(name = "client_second_name")
    private String clientSecondName;

    public Cards() {
    }

    public Cards( String cardNum, Double discount, String clientName, String clientSername, String clientSecondName) {
        this.cardNum = cardNum;
        this.discount = discount;
        this.clientName = clientName;
        this.clientSername = clientSername;
        this.clientSecondName = clientSecondName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSername() {
        return clientSername;
    }

    public void setClientSername(String clientSername) {
        this.clientSername = clientSername;
    }

    public String getClientSecondName() {
        return clientSecondName;
    }

    public void setClientSecondName(String clientSecondName) {
        this.clientSecondName = clientSecondName;
    }
}
