package dao;

import domain.Card;

public interface CardDao extends Dao<Card>{
    Card getCardByNumber(String number);
}
