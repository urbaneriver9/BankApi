package util.mapper;

import dto.AccountDto;
import domain.Account;
import dto.BalanceRequestDto;
import dto.TopUpBalanceDto;


public interface AccountMapper {

    Account map (AccountDto accountDto);
    AccountDto map(Account account);
    BalanceRequestDto mapBalance(Account account);
    Account map (TopUpBalanceDto topUpBalanceDto);
}
