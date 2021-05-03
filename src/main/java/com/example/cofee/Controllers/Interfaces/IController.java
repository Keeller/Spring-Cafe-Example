package com.example.cofee.Controllers.Interfaces;

import com.example.cofee.Responces.AbstractResponse;

public interface IController {

    default AbstractResponse fallback(Exception ex) {
        AbstractResponse abstractResponse=new AbstractResponse();
        abstractResponse.setCode("500");
        abstractResponse.setErr(ex.getMessage());
        return abstractResponse;
    }

}
