package services.impl;

import dao.CardDao;
import dao.impl.CardDaoImpl;
import db.H2DataSourceImpl;
import domain.Card;
import dto.CardOrderRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.CardService;

import static org.junit.jupiter.api.Assertions.*;

class CardServiceImplTest {

    CardService cardService = new CardServiceImpl();
    CardDao cardDao = new CardDaoImpl();

    @BeforeEach
    public void createNewDB(){
        H2DataSourceImpl.initDb();
    }

    @Test
    void cardOrder() {
        CardOrderRequestDto cardOrderRequestDto = new CardOrderRequestDto(11, "test");
        String cardNumber = cardService.cardOrder(cardOrderRequestDto);
        Card expectedCard = new Card();
        expectedCard.setNumber(cardNumber);
        expectedCard.setAccountNumber("test");
        expectedCard.setClientID(11);
        expectedCard.setValid(false);
        Card card = cardDao.getCardByNumber(cardNumber);
        assertEquals(expectedCard,card);
    }

    @Test
    void getCardsByAccountNumber() {
    }
}