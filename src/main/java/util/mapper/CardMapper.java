package util.mapper;

import dto.CardDto;
import domain.Card;
import dto.CardOrderRequestDto;

public interface CardMapper {

    Card map(CardDto cardDto);
    CardDto map(Card card);
    Card map(CardOrderRequestDto cardOrderDto);
}
