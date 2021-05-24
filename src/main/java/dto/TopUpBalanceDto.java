package dto;

import java.math.BigDecimal;

public class TopUpBalanceDto {
    String accountNumber;
    BigDecimal topUpSum;

    public TopUpBalanceDto(String accountNumber, BigDecimal topUpSum) {
        this.accountNumber = accountNumber;
        this.topUpSum = topUpSum;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getTopUpSum() {
        return topUpSum;
    }

    public void setTopUpSum(BigDecimal topUpSum) {
        this.topUpSum = topUpSum;
    }
}
