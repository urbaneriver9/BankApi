package services.impl;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import domain.Account;
import dto.AllCardsRequestDto;
import dto.BalanceRequestDto;
import dto.TopUpBalanceDto;
import services.AccountService;
import services.CardService;
import util.mapper.AccountMapper;
import util.mapper.impl.AccountMapperImpl;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    AccountDao accountDao = new AccountDaoImpl();
    AccountMapper accountMapper = new AccountMapperImpl();
    CardService cardService = new CardServiceImpl();

    @Override
    public BalanceRequestDto getBalanceRequest(String accountNumber) { //ToDO null!!!
        Account account = accountDao.getByNumber(accountNumber);
        BalanceRequestDto balanceRequestDto = accountMapper.mapBalance(account);
        return balanceRequestDto;
    }

    @Override
    public Account getAccountByNumber(String accountNumber) { //ToDo: return DTO, not null!!!
        Account account = accountDao.getByNumber(accountNumber);
        account.setCards(cardService.getCardsByAccountNumber(accountNumber));
        return account;
    }

    @Override
    public List<Account> getAllAccountByClientId(long clientID) { //ToDo: return List<DTO>
        List<Account> allAccounts = accountDao.getByClientId(clientID);;
        for(Account account : allAccounts){
            account.setCards(cardService.getCardsByAccountNumber(account.getNumber()));
        }
        return allAccounts;
    }

    @Override
    public void topUp(TopUpBalanceDto topUpBalanceDto) { // ToDo: Balance



        accountDao.updateBalance(topUpBalanceDto.getAccountNumber(), topUpBalanceDto.getTopUpSum());
    }

//    public void topUpref(TopUpBalanceDto topUpBalanceDto){
//        Account account = accountDao.getByNumber(topUpBalanceDto.getAccountNumber())
//    }

}
