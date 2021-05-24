package dao.impl;

import com.sun.tools.javac.util.Assert;
import dao.CardDao;
import db.H2DataSourceImpl;
import domain.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CardDaoImplTest {

    CardDao cardDao = new CardDaoImpl();

    @BeforeEach
    public void createNewDB(){
        H2DataSourceImpl.initDb();
    }

    @Test
    void insertAndGetById() {
        Card card = new Card();
        card.setNumber("test");
        card.setClientID(11);
        card.setAccountNumber("test");
        try {
            cardDao.insert(card);
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        card = cardDao.getCardByNumber("test");
        Card expectedCard = new Card();
        expectedCard.setNumber("test");
        expectedCard.setAccountNumber("test");
        expectedCard.setClientID(11);
        expectedCard.setValid(false);
        assertEquals(expectedCard, card);
    }

    @Test
    void getAll() {
    }

    @Test
    void getAllCardsByAccountNumber() {
    }
}