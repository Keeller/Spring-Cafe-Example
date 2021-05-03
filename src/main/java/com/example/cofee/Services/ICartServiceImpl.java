package com.example.cofee.Services;

import com.example.cofee.Entities.SQL.Cart;
import com.example.cofee.Repositories.CartRepository;
import com.example.cofee.Services.Interfeices.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис работы с товарами
 */
@Service
public class ICartServiceImpl implements ICartService {

    private CartRepository cartRepository;
    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    /**
     * Создать товар
     * @param name имя товара
     * @param description описание товара
     * @param price цена товара
     * @return Созданный товар
     */
    @Override
    public Cart create(String name, String description, Double price) {
        Cart cart=new Cart(name,description,price);
        return cartRepository.save(cart);
    }

    /**
     * Обновить товар
     * @param id айдишник
     * @param name имя товра
     * @param description описание товара
     * @param price цена товара
     * @return Обновляемый товар
     */
    @Override
    public Cart update(Long id,String name, String description, Double price) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        cart.setName(name);
        cart.setDescription(description);
        cart.setPrice(price);
        return cartRepository.save(cart);
    }

    /**
     * Удаление товара по айдишнику
     * @param id айдишник товара
     */
    @Override
    public void delete(Long id) {
        cartRepository.delete(cartRepository.findById(id).orElseThrow());
    }

    /**
     * Получить товар по йдишни ку
     * @param id айдишник товара
     * @return треьуемый товар
     */
    @Override
    public Cart get(Long id) {
        return cartRepository.findById(id).orElseThrow();
    }

    /**
     * Получить товары по списку айдишников
     * @param ids список айдишников
     * @return список товаров
     */
    @Override
    public List<Cart> getById(List<Long> ids) {
        return cartRepository.findAllById(ids);
    }

    /**
     * Получить все товары
     * @return список товаров
     */
    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }
}
