package dao;

import domain.Card;

import java.util.List;

public interface CardDao extends Dao<Card>{
    Card getCardByNumber(String number);
    List<Card> getAllCardsByAccountNumber(String accountNumber);
}
