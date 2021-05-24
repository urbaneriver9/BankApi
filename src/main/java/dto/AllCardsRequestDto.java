package dto;

import domain.Card;

import java.util.List;

public class AllCardsRequestDto {
    private String number;
    private List<Card> cards;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
