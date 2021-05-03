package com.example.cofee.Services;

import com.example.cofee.Entities.SQL.Cards;
import com.example.cofee.Repositories.CardsRepository;
import com.example.cofee.Services.Interfeices.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис работы с заказами
 */
@Service
public class ICardServiceImpl implements ICardService {

    private CardsRepository cardsRepository;
    @Autowired
    public void setCardsRepository(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    /**
     * создать карту
     * @param cardNum номер карты
     * @param discount расчитать скидку
     * @param clientName имя клиента
     * @param serName фамилия клиента
     * @param clientSecondName отчество клиента
     * @return созданная карта
     */
    @Override
    public Cards create(String cardNum, Double discount, String clientName, String serName, String clientSecondName) {
        Cards cards=new Cards(cardNum,discount,cardNum,serName,clientName);
        return cardsRepository.save(cards);

    }

    /**
     * Обновить элемент
     * @param id айдишник
     * @param cardNum номер карты
     * @param discount скидка
     * @param clientName имя клиента
     * @param serName фамилия клиента
     * @param clientSecondName отчество клиента
     * @return обновленная карта
     */
    @Override
    public Cards update(Long id,String cardNum, Double discount, String clientName, String serName, String clientSecondName) {
        Optional<Cards> byId = cardsRepository.findById(id);
        Cards cards = byId.orElseThrow();
        cards.setCardNum(cardNum);
        cards.setDiscount(discount);
        cards.setClientName(clientName);
        cards.setClientSername(serName);
        cards.setClientSecondName(clientSecondName);
        return cardsRepository.save(cards);
    }

    /**
     * Удалить элемент
     * @param id айдишник удаления
     */
    @Override
    public void delete(Long id) {
        cardsRepository.delete(cardsRepository.findById(id).orElseThrow());
    }

    /**
     * Полкучить элемент
     * @param id айдишник получения
     * @return требуемая карта
     */
    @Override
    public Cards get(Long id) {
        return cardsRepository.findById(id).orElseThrow();
    }

    /**
     * Получить скридку
     * @param id айдишник карты
     * @return размер скидки
     */
    @Override
    public Double getDiscount(Long id) {
        return cardsRepository.findById(id).orElseThrow().getDiscount();
    }

    /**
     * Получить все элементы
     * @return список всех карт
     */
    @Override
    public List<Cards> getAll() {
        return cardsRepository.findAll();
    }
}
