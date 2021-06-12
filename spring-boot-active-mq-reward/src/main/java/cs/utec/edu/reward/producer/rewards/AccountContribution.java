package cs.utec.edu.reward.producer.rewards;

import java.math.BigDecimal;

/**
 * A summary of a monetary contribution made to an account that.
 *
 * A value object. Immutable.
 */
public class AccountContribution{


    private String accountNumber;
    private BigDecimal amount;
    /**
     * Creates a new account contribution.
     * @param accountNumber the number of the account the contribution was made
     * @param amount the total contribution amount
     */
    public AccountContribution(String accountNumber, BigDecimal amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

