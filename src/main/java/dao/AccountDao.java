package dao;

import domain.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDao extends Dao<Account> {

    List<Account> getByClientId(long clientId);

    Account getByNumber(String accountNumber);
    void updateBalance(String accountNumber, BigDecimal topUpSum);
}
