package services;

import domain.Card;
import dto.CardOrderRequestDto;

import java.util.List;

public interface CardService {
    String cardOrder(CardOrderRequestDto cardOrderDto);
    List<Card> getCardsByAccountNumber(String accountNumber);
}
