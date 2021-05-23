package util.mapper.impl;

import dto.CardDto;
import domain.Card;
import dto.CardOrderRequestDto;
import util.mapper.CardMapper;

public class CardMapperImpl implements CardMapper {

    @Override
    public Card map(CardDto cardDto) {
        Card card = new Card();
        card.setId(cardDto.getId());
        card.setNumber(cardDto.getNumber());
        card.setAccountNumber(cardDto.getAccountNumber());
        card.setClientID(card.getClientID());
        card.setValid(card.isValid());
        return null;
    }

    @Override
    public CardDto map(Card card) {
        CardDto cardDto = new CardDto();
        cardDto.setId(card.getId());
        cardDto.setNumber(card.getNumber());
        cardDto.setAccountNumber(card.getAccountNumber());
        cardDto.setClientID(card.getClientID());
        cardDto.setValid(card.isValid());
        return null;
    }

    @Override
    public Card map(CardOrderRequestDto cardOrderDto) {
        Card card = new Card();
        card.setAccountNumber(cardOrderDto.getAccountNumber());
        card.setClientID(cardOrderDto.getClientID());
        return card;
    }
}
