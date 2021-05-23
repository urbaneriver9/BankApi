package dto;

public class CardOrderRequestDto {
    long clientID;
    String accountNumber;

    public CardOrderRequestDto(long clientID, String accountNumber) {
        this.clientID = clientID;
        this.accountNumber = accountNumber;
    }

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

}
