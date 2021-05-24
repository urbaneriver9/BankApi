package util.mapper.impl;

import dto.AccountDto;
import domain.Account;
import dto.BalanceRequestDto;
import dto.TopUpBalanceDto;
import util.mapper.AccountMapper;

public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account map(AccountDto accountDto) {
        Account account = new Account();
        account.setNumber(account.getNumber());
        account.setBalance(accountDto.getBalance());
        account.setOpen(accountDto.isOpen());
        return null;
    }

    @Override
    public AccountDto map(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setNumber(account.getNumber());
        accountDto.setBalance(account.getBalance());
        accountDto.setOpen(account.isOpen());
        return accountDto;
    }

    @Override
    public BalanceRequestDto mapBalance(Account account) {
        BalanceRequestDto balanceRequestDto = new BalanceRequestDto();
        balanceRequestDto.setNumber(account.getNumber());
        balanceRequestDto.setBalance(account.getBalance());
        return balanceRequestDto;
    }

    @Override
    public Account map(TopUpBalanceDto topUpBalanceDto) {
        Account account = new Account();
        account.setNumber(topUpBalanceDto.getAccountNumber());
        account.setBalance(topUpBalanceDto.getTopUpSum());
        return account;
    }
}
