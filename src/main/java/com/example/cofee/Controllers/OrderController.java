package com.example.cofee.Controllers;

import com.example.cofee.Controllers.Interfaces.IController;
import com.example.cofee.Entities.Hazelcast.Order;
import com.example.cofee.Requests.OrderRequest;
import com.example.cofee.Responces.AbstractResponse;
import com.example.cofee.Responces.OrderResponce;
import com.example.cofee.Services.Interfeices.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Контороллер заказов
 */
@CrossOrigin(origins = "*",maxAge = 1000)
@RestController
@RequestMapping(value = "/orders")
public class OrderController implements IController {
    private IOrderService iOrderService;
    @Autowired
    public void setiOrderService(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    /**
     * Создать заказ
     * @param orderRequest запрос заказа
     * @return ответ
     */
    @RequestMapping(method = RequestMethod.POST)
    public AbstractResponse create(@RequestBody OrderRequest orderRequest){
        try {
            Order order = iOrderService.createOrder(orderRequest.getCartId(), orderRequest.getCardId());
            OrderResponce orderResponce = getOrderResponce(order);
            orderResponce.setCode("200");
            return orderResponce;

        }
        catch (Exception ex){
            return fallback(ex);
        }

    }

    /**
     * Закрыть зака
     * @param id айдишник заказа
     * @return ответ
     */
    @RequestMapping(method = RequestMethod.GET,path = "/finish/{id}")
    public AbstractResponse finishOrder(@PathVariable("id") Integer id){
        try {
            iOrderService.finishOrder(id);
            AbstractResponse abstractResponse=new AbstractResponse();
            abstractResponse.setCode("200");
            return abstractResponse;
        }
        catch (Exception ex){
            return fallback(ex);
        }
    }

    /**
     * Получить заказ по айдишнику
     * @param id айдишник
     * @return ответ
     */
    @RequestMapping(method = RequestMethod.GET,path = "/{id}")
    public AbstractResponse get(Integer id){
        try {
            Order order = iOrderService.get(id);
            OrderResponce orderResponce = getOrderResponce(order);
            orderResponce.setCode("200");
            return orderResponce;
        }
        catch (Exception ex){
            return fallback(ex);
        }
    }

    /**
     * Получить все заказы
     * @return список заказов
     */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<? extends AbstractResponse> getAll(){
        try {
            List<Order> all = iOrderService.getAll();
            List<OrderResponce> responces=new ArrayList<>();
            for (Order order : all) {
                OrderResponce orderResponce = getOrderResponce(order);
                responces.add(orderResponce);
            }
            return responces;

        }
        catch (Exception ex){
            return Collections.singleton(fallback(ex));
        }
    }

    /**
     * Сформировать из заказ сущность ответа
     * @param order заказ
     * @return ответ
     */
    private OrderResponce getOrderResponce(Order order) {
        OrderResponce orderResponce=new OrderResponce();
        orderResponce.setCardId(order.getCardId());
        orderResponce.setCartId(order.getCartId());
        orderResponce.setAmount(order.getAmount());
        orderResponce.setCode("200");
        return orderResponce;
    }
}
