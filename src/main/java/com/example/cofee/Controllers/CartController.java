package com.example.cofee.Controllers;

import com.example.cofee.Controllers.Interfaces.IController;
import com.example.cofee.Entities.SQL.Cart;
import com.example.cofee.Requests.CartRequest;
import com.example.cofee.Responces.AbstractResponse;
import com.example.cofee.Responces.CartResponce;
import com.example.cofee.Services.Interfeices.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Контороллер товаров
 */
@CrossOrigin(origins = "*",maxAge = 1000)
@RestController
@RequestMapping(value = "/carts")
public class CartController implements IController {

    private ICartService iCartService;
    @Autowired
    public void setiCartService(ICartService iCartService) {
        this.iCartService = iCartService;
    }

    /**
     * Создать товар
     * @param cartRequest запрос
     * @return ответ
     */
    @RequestMapping(method = RequestMethod.POST)
    public AbstractResponse create(@RequestBody CartRequest cartRequest){
        try {
            Cart cart = iCartService.create(cartRequest.getName(), cartRequest.getDescription(), cartRequest.getPrice());
            CartResponce cartResponce = getCartResponce(cart);
            cartResponce.setCode("200");
            return cartResponce;
        }
        catch (Exception ex){
            return fallback(ex);
        }
    }

    /**
     * Обновить товар
     * @param cartRequest запрос
     * @return ответ
     */
    @RequestMapping(method = RequestMethod.PATCH)
    public AbstractResponse update(@RequestBody CartRequest cartRequest){
        try {
            Cart cart = iCartService.update(cartRequest.getId(),cartRequest.getName(), cartRequest.getDescription(), cartRequest.getPrice());
            CartResponce cartResponce = getCartResponce(cart);
            cartResponce.setCode("200");
            return cartResponce;
        }
        catch (Exception ex){
            return fallback(ex);
        }
    }

    /**
     * Удалить товар
     * @param id айдишник товара
     * @return ответ
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public AbstractResponse delete(@PathVariable("id") Long id){
        try {
            iCartService.delete(id);
            AbstractResponse cartResponce=new AbstractResponse();
            cartResponce.setCode("200");
            return cartResponce;
        }
        catch (Exception ex){
            return fallback(ex);
        }
    }

    /**
     * Получить вск товары
     * @return список товаров
     */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<? extends AbstractResponse> getAll(){
        try {
            List<Cart> carts=iCartService.getAll();
            List<CartResponce> responces=new ArrayList<>();
            for (Cart cart : carts) {
                CartResponce cartResponce = getCartResponce(cart);
                responces.add(cartResponce);
            }
            return responces;
        }
        catch (Exception ex){
            return Collections.singleton(fallback(ex));
        }
    }

    /**
     * Получить товар по айдишнику
     * @param id айдишник
     * @return требуемый товар
     */
    @RequestMapping(method = RequestMethod.GET,path = "/{id}")
    public AbstractResponse get(@PathVariable("id") Long id){
        try {
            Cart cart = iCartService.get(id);
            CartResponce cartResponce = getCartResponce(cart);
            return cartResponce;

        }
        catch (Exception ex){
            return fallback(ex);
        }
    }



    private CartResponce getCartResponce(Cart cart) {
        CartResponce cartResponce = new CartResponce();
        cartResponce.setName(cart.getName());
        cartResponce.setDescription(cart.getDescription());
        cartResponce.setPrice(cart.getPrice());
        cartResponce.setCode("200");
        return cartResponce;
    }
}
