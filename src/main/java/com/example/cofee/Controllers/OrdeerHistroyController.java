package com.example.cofee.Controllers;

import com.example.cofee.Controllers.Interfaces.IController;
import com.example.cofee.Entities.SQL.OrderHistory;
import com.example.cofee.Responces.AbstractResponse;
import com.example.cofee.Responces.OrderHistoryResponce;
import com.example.cofee.Services.Interfeices.IOrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Контороллер истории заказов
 */
@CrossOrigin(origins = "*",maxAge = 1000)
@RestController
@RequestMapping(value = "/ordershystory")
public class OrdeerHistroyController implements IController {

    private IOrderHistoryService iOrderHistoryService;
    @Autowired
    public void setiOrderHistoryService(IOrderHistoryService iOrderHistoryService) {
        this.iOrderHistoryService = iOrderHistoryService;
    }

    /**
     * Получить объект истории заказов
     * @param id айдишник
     * @return ответ
     */
    @RequestMapping(method = RequestMethod.GET,path = "/{id}")
    public AbstractResponse get(@PathVariable("id") Long id){
        try {
            OrderHistory orderHistoryById = iOrderHistoryService.getOrderHistoryById(id);
            OrderHistoryResponce orderHistoryResponce = getOrderHistoryResponce(orderHistoryById);
            orderHistoryResponce.setCode("200");
            return  orderHistoryResponce;

        }
        catch (Exception ex){
            return fallback(ex);
        }
    }

    /**
     * Преобразовать сущность в ответ
     * @param orderHistoryById сушность
     * @return ответ
     */
    private OrderHistoryResponce getOrderHistoryResponce(OrderHistory orderHistoryById) {
        OrderHistoryResponce orderHistoryResponce=new OrderHistoryResponce();
        orderHistoryResponce.setId(orderHistoryById.getId());
        orderHistoryResponce.setSerializedOrder(orderHistoryById.getSerializedOrder());
        orderHistoryResponce.setCode("200");
        return orderHistoryResponce;
    }

    /**
     * Получить все объекты истории
     * @return список объектов истории
     */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<? extends AbstractResponse> getAll(){
        try {
            List<OrderHistory> histories = iOrderHistoryService.getAll();
            List<OrderHistoryResponce> responces = new ArrayList<>();
            for (OrderHistory history : histories) {
                OrderHistoryResponce orderHistoryResponce = getOrderHistoryResponce(history);
                responces.add(orderHistoryResponce);
            }
            return responces;
        }
        catch (Exception  ex){
            return Collections.singleton(fallback(ex));
        }
    }
}
