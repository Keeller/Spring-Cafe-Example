package com.example.cofee.Services.Interfeices;


import com.example.cofee.Entities.SQL.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICartService {

    public Cart create(String name,String description,Double price);
    public Cart update(Long id,String name,String description,Double price);
    public void delete(Long id);
    public Cart get(Long id);
    public List<Cart> getById(List<Long> ids);
    public List<Cart> getAll();
}
