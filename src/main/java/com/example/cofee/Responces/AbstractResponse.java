package com.example.cofee.Responces;

/**
 * Общая сущность ответа содержащая обощенные свойство ответа
 */
public  class AbstractResponse {
    private String code;
    private String err;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
