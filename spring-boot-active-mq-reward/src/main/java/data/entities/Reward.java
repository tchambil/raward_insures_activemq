package  data.entities;

import cs.utec.edu.reward.producer.common.datetime.SimpleDate;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="T_Reward")
public class Reward {
    private Long entityId;
    private String ConfirmationNumber;
    private BigDecimal Amount;
    private SimpleDate CreationDate;
    private String AccountNumber;
    private String DinningMerchantNumber;
    private SimpleDate DinnigDate;
    private BigDecimal DinnigAmount;
    public Reward(){

    }

    public Reward(Long entityId, String confirmationNumber, BigDecimal amount, SimpleDate creationDate, String accountNumber, String dinningMerchantNumber, SimpleDate dinnigDate, BigDecimal dinnigAmount) {
        this.entityId = entityId;
        ConfirmationNumber = confirmationNumber;
        Amount = amount;
        CreationDate = creationDate;
        AccountNumber = accountNumber;
        DinningMerchantNumber = dinningMerchantNumber;
        DinnigDate = dinnigDate;
        DinnigAmount = dinnigAmount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique=true, nullable=false)
    public Long getEntityId() {
        return entityId;
    }
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }
    /**
     * Returns the number used to uniquely identify this Reward.
     */
    @Column(name="CONFIRMATION_NUMBER", nullable=false, length=50)
    public String getConfirmationNumber() {
        return ConfirmationNumber;
    }

    /**
     * Sets the number used to uniquely identify this Confirmation Number.
     * @param ConfirmationNumber The number for this Confirmation Number
     */
    public void setConfirmationNumber(String ConfirmationNumber) {
        this.ConfirmationNumber = ConfirmationNumber;
    }

    @Column(name="AMOUNT", nullable=false)
    public BigDecimal getAmount() {
        return Amount;
    }
    public void setAmount(BigDecimal Amount) {
        this.Amount = Amount;
    }

    @Column(name="REWARD_DATE", nullable=false)
    public SimpleDate getCreationDate() {
        return CreationDate;
    }
    public void setCreationDate(SimpleDate CreationDate) {
        this.CreationDate = CreationDate;
    }

    @Column(name="ACCOUNT_NUMBER", nullable=false)
    public String getAccountNumber() {
        return AccountNumber;
    }
    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    @Column(name="DINING_MERCHANT_NUMBER", nullable=false)
    public String getDinningMerchantNumber() {
        return DinningMerchantNumber;
    }
    public void setDinningMerchantNumber(String DinningMerchantNumber) {
        this.DinningMerchantNumber = DinningMerchantNumber;
    }
    @Column(name="DINING_DATE", nullable=false)
    public SimpleDate getDinnigDate() {
        return DinnigDate;
    }
    public void setDinnigDate(SimpleDate DinnigDate) {
        this.DinnigDate = DinnigDate;
    }

    @Column(name="DINING_AMOUNT", nullable=false)
    public BigDecimal getDinnigAmount() {
        return DinnigAmount;
    }
    public void setDinnigAmount(BigDecimal DinnigAmount) {
        this.DinnigAmount = DinnigAmount;
    }

}
