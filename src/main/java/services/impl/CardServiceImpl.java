package services.impl;

import dao.CardDao;
import dao.impl.CardDaoImpl;
import domain.Card;
import dto.CardDto;
import dto.CardOrderRequestDto;
import services.CardService;
import util.mapper.CardMapper;
import util.mapper.impl.CardMapperImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class CardServiceImpl implements CardService {

    private static final int CARD_NUMBER_LENGTH = 16;
    private static final int CARD_DIGITS = 10;
    CardDao cardDao = new CardDaoImpl();

    CardMapper cardMapper = new CardMapperImpl();

    @Override
    public void cardOrder(CardOrderRequestDto cardOrderDto){
        Card card = cardMapper.map(cardOrderDto);
        card.setNumber(generateRandom());

        try {
            cardDao.insert(card);
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandom() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < CARD_NUMBER_LENGTH; i++) {
            stringBuilder.append((int)(Math.random()*10));
        }
        return stringBuilder.toString();
    }
}
