package util.mapper;

import dto.AccountDto;
import domain.Account;


public interface AccountMapper {

    Account map (AccountDto accountDto);
    AccountDto map(Account account);
}
