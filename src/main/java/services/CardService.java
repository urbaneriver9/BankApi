package services;

import dto.CardDto;
import dto.CardOrderRequestDto;

public interface CardService {
    void cardOrder(CardOrderRequestDto cardOrderDto);
}
