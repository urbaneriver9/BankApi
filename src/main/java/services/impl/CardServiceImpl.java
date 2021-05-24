package services.impl;

import dao.CardDao;
import dao.impl.CardDaoImpl;
import domain.Card;
import dto.CardOrderRequestDto;
import services.CardService;
import util.mapper.CardMapper;
import util.mapper.impl.CardMapperImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CardServiceImpl implements CardService {

    private static final int CARD_NUMBER_LENGTH = 16;
    CardDao cardDao = new CardDaoImpl();

    CardMapper cardMapper = new CardMapperImpl();

    @Override
    public String cardOrder(CardOrderRequestDto cardOrderDto){
        Card card = cardMapper.map(cardOrderDto);
        String cardNumber = generateRandom();
        card.setNumber(cardNumber);

        try {
            return cardDao.insert(card);

        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
        return cardNumber;
    }

    @Override
    public List<Card> getCardsByAccountNumber(String accountNumber) {
        return cardDao.getAllCardsByAccountNumber(accountNumber);
    }


    private static String generateRandom() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < CARD_NUMBER_LENGTH; i++) {
            stringBuilder.append((int)(Math.random()*10));
        }
        return stringBuilder.toString();
    }
}
