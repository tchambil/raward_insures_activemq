package data.dtos;

import cs.utec.edu.reward.producer.common.datetime.SimpleDate;

import java.math.BigDecimal;

public class RewardDto {
    private Long entityId;
    private String ConfirmationNumber;
    private BigDecimal Amount;
    private SimpleDate CreationDate;
    private String AccountNumber;
    private String DinningMerchantNumber;
    private SimpleDate DinnigDate;
    private BigDecimal DinnigAmount;

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getConfirmationNumber() {
        return ConfirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        ConfirmationNumber = confirmationNumber;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public SimpleDate getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(SimpleDate creationDate) {
        CreationDate = creationDate;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getDinningMerchantNumber() {
        return DinningMerchantNumber;
    }

    public void setDinningMerchantNumber(String dinningMerchantNumber) {
        DinningMerchantNumber = dinningMerchantNumber;
    }

    public SimpleDate getDinnigDate() {
        return DinnigDate;
    }

    public void setDinnigDate(SimpleDate dinnigDate) {
        DinnigDate = dinnigDate;
    }

    public BigDecimal getDinnigAmount() {
        return DinnigAmount;
    }

    public void setDinnigAmount(BigDecimal dinnigAmount) {
        DinnigAmount = dinnigAmount;
    }
}
