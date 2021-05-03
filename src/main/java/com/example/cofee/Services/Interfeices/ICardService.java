package com.example.cofee.Services.Interfeices;

import com.example.cofee.Entities.SQL.Cards;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICardService {

    public Cards create(String cardNum, Double discount, String clientName, String serName, String clientSecondName);
    public Cards update(Long id,String cardNum, Double discount, String clientName, String serName, String clientSecondName);
    public void delete(Long id);
    public Cards get(Long id);
    public Double getDiscount(Long id);
    public List<Cards> getAll();

}
