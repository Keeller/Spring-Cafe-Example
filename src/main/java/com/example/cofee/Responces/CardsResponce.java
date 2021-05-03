package com.example.cofee.Responces;

/**
 * Сущность ответа карты
 */
public class CardsResponce extends AbstractResponse {

    private Long id;
    private String cardNum;
    private Double discount;
    private String clientName;
    private String clientSername;
    private String clientSecondName;

    public CardsResponce() {
    }

    public CardsResponce(Long id, String cardNum, Double discount, String clientName, String clientSername, String clientSecondName) {
        this.id = id;
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
