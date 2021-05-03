package com.example.cofee.Controllers;

import com.example.cofee.Controllers.Interfaces.IController;
import com.example.cofee.Entities.SQL.Cards;
import com.example.cofee.Requests.CardsRequest;
import com.example.cofee.Responces.AbstractResponse;
import com.example.cofee.Responces.CardsResponce;
import com.example.cofee.Responces.CartResponce;
import com.example.cofee.Services.Interfeices.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Контроллер карты
 */
@CrossOrigin(origins = "*",maxAge = 1000)
@RestController
@RequestMapping(value = "/cards")
public class CardsController implements IController {

    private ICardService iCardService;
    @Autowired
    public void setiCardService(ICardService iCardService) {
        this.iCardService = iCardService;
    }

    /**
     * Создать карту
     * @param cardsRequest запрос
     * @return ответ
     */
    @RequestMapping(method = RequestMethod.POST)
    public AbstractResponse create(@RequestBody CardsRequest cardsRequest){
        try {
            Cards cards = iCardService.create(cardsRequest.getCardNum(), cardsRequest.getDiscount(), cardsRequest.getClientName(), cardsRequest.getClientSername(), cardsRequest.getClientSecondName());
            CardsResponce cardsResponce = getCardsResponse(cards);
            cardsResponce.setCode("200");
            return cardsResponce;
        }
        catch (Exception ex){
            return fallback(ex);
        }
    }

    /**
     * Построить ответ из сущности
     * @param cards сущность карта
     * @return ответ
     */
    private CardsResponce getCardsResponse(Cards cards) {
        CardsResponce cardsResponce = new CardsResponce();
        cardsResponce.setId(cards.getId());
        cardsResponce.setCardNum(cards.getCardNum());
        cardsResponce.setClientName(cards.getClientName());
        cardsResponce.setClientSecondName(cards.getClientSecondName());
        cardsResponce.setClientSername(cards.getClientSername());
        cardsResponce.setDiscount(cards.getDiscount());
        cardsResponce.setCode("200");
        return cardsResponce;
    }

    /**
     * Обновить карту
     * @param cardsRequest запрос
     * @return ответ
     */
    @RequestMapping(method = RequestMethod.PATCH)
    public AbstractResponse update(@RequestBody CardsRequest cardsRequest){
        try {
            Cards cards = iCardService.update(cardsRequest.getId(),cardsRequest.getCardNum(), cardsRequest.getDiscount(), cardsRequest.getClientName(), cardsRequest.getClientSername(), cardsRequest.getClientSecondName());
            CardsResponce cardsResponce = getCardsResponse(cards);
            cardsResponce.setCode("200");
            return cardsResponce;
        }
        catch (Exception ex){
            return fallback(ex);
        }
    }

    /**
     * Удалить карту
     * @param id айдишник
     * @return ответ
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public AbstractResponse delete(@PathVariable("id") Long id){
        try {
            iCardService.delete(id);
            AbstractResponse cartResponce = new AbstractResponse();
            cartResponce.setCode("200");
            return cartResponce;
        }
        catch (Exception ex){
            return fallback(ex);
        }
    }

    /**
     * Получить карту по айдишнику
     * @param id айдишник
     * @return отавет
     */
    @RequestMapping(method = RequestMethod.GET,path = "/{id}")
    public AbstractResponse get(@PathVariable("id") Long id){
        try {
            Cards cards = iCardService.get(id);
            CardsResponce cardsResponce = getCardsResponse(cards);
            cardsResponce.setCode("200");
            return cardsResponce;
        }
        catch (Exception ex){
            return fallback(ex);
        }

    }

    /**
     * Получить все карты
     * @return список карт
     */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<? extends AbstractResponse> getAll(){
        try {
            List<Cards> all = iCardService.getAll();
            List<AbstractResponse> responses=new ArrayList<>();
            for (Cards cards : all) {
                CardsResponce cardsResponse = getCardsResponse(cards);
                responses.add(cardsResponse);
            }

            return responses;
        }
        catch (Exception ex){
            return Collections.singleton(fallback(ex));
        }
    }


}
