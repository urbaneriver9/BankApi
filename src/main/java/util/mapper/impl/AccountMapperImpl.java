package util.mapper.impl;

import dto.AccountDto;
import domain.Account;
import util.mapper.AccountMapper;

public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account map(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setClientID(accountDto.getClientID());
        account.setNumber(account.getNumber());
        account.setBalance(accountDto.getBalance());
        account.setOpen(accountDto.isOpen());
        return null;
    }

    @Override
    public AccountDto map(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setClientID(account.getClientID());
        accountDto.setNumber(account.getNumber());
        accountDto.setBalance(account.getBalance());
        accountDto.setOpen(account.isOpen());
        return accountDto;
    }
}
