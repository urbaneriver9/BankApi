package domain;

import java.util.Objects;

public class Card {
    private long clientID;
    private String accountNumber;
    private String number;
    private boolean isValid;

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return getClientID() == card.getClientID() && isValid() == card.isValid() && Objects.equals(getAccountNumber(), card.getAccountNumber()) && Objects.equals(getNumber(), card.getNumber());
    }

}
