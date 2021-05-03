package com.example.cofee.Services;

import com.example.cofee.Entities.Hazelcast.Order;
import com.example.cofee.Entities.SQL.Cart;
import com.example.cofee.Entities.SQL.OrderHistory;
import com.example.cofee.Repositories.OrderRepository;
import com.example.cofee.Services.Interfeices.ICardService;
import com.example.cofee.Services.Interfeices.ICartService;
import com.example.cofee.Services.Interfeices.IOrderHistoryService;
import com.example.cofee.Services.Interfeices.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис работы с заказами
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private ICardService iCardService;
    @Autowired
    public void setiCardService(ICardService iCardService) {
        this.iCardService = iCardService;
    }
    private ICartService iCartService;
    @Autowired
    public void setiCartService(ICartService iCartService) {
        this.iCartService = iCartService;
    }
    private IOrderHistoryService iOrderHistoryService;
    @Autowired
    public void setiOrderHistoryService(IOrderHistoryService iOrderHistoryService) {
        this.iOrderHistoryService = iOrderHistoryService;
    }
    private OrderRepository orderRepository;
    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Метод создания заказа
     * @param cartsid айдишеики товаров
     * @param cardid айдишник скидочной карты
     * @return созданный заказ
     */
    @Override
    public Order createOrder(List<Long> cartsid, Long cardid) {
        Double discount = iCardService.getDiscount(cardid);
        Cart cart = iCartService.getById(cartsid).stream().reduce((x, y) -> {
            x.setPrice(x.getPrice() + y.getPrice());
            return x;
        }).get();
        Double price=cart.getPrice();
        double amount=price-(price*(discount/ 100.0));
        amount=(amount<=0.0)?0.0:amount;
        Order order=new Order(cartsid,cardid,amount);
        return orderRepository.create(order);
    }

    /**
     * Получить заказ по номеру
     * @param id айдиник
     * @return требуемый заказ
     */
    @Override
    public Order get(Integer id) {
        return orderRepository.get(id);
    }

    /**
     * Закрыть заказ с указанным id
     * @param id айдишник закрытия
     */
    @Override
    public void finishOrder(Integer id) {
        Order order = orderRepository.get(id);
        OrderHistory orderHistory = iOrderHistoryService.pushOrderIntoHistory(order);
        orderRepository.delete(id);

    }

    /**
     * Получить весь заказ
     * @return список заказов
     */
    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }
}
