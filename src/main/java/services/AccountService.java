package services;

import domain.Account;
import dto.AllCardsRequestDto;
import dto.BalanceRequestDto;
import dto.TopUpBalanceDto;

import java.util.List;

public interface AccountService {

    BalanceRequestDto getBalanceRequest(String accountNumber);
    Account getAccountByNumber(String accountNumber);
    List<Account> getAllAccountByClientId(long clientID);
    void topUp(TopUpBalanceDto topUpBalanceDto);

}
