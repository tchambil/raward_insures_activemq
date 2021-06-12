package data.entities;
import cs.utec.edu.reward.producer.rewards.AccountContribution;

import javax.persistence.*;
import java.math.BigDecimal;

import  config.GlobalConstants.*;

import static config.GlobalConstants.*;

@Entity
@Table(name="T_ACCOUNT")
public class Account {

    private Long entityId;

    private String number;

    private String name;

    private BigDecimal savings ;

    private String creditCardNumber;
    private String EmailAddress;
    private boolean IsNotificationEmail;
    public Account() {
    }

    /**
     * Create a new account.
     * @param number the account number
     * @param name the name on the account
     */
    public Account(String number, String name) {
        this.number = number;
        this.name = name;
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
     * Getter for the credit card number for this account.
     *
     * @return the credit card number for this account as a 16-character String.
     */
    @Column(name="CREDIT_CARD", nullable=false, length=DB_CARD_LENGTH)
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    /**
     * Setter for the credit card number for this account.
     *
     * @param creditCardNumber
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    /**
     * Returns the number used to uniquely identify this account.
     */
    @Column(name="NUMBER", nullable=false, length=DB_DNI_LENGTH)
    public String getNumber() {
        return number;
    }
    /**
     * Sets the number used to uniquely identify this account.
     * @param number The number for this account
     */
    public void setNumber(String number) {
        this.number = number;
    }
    /**
     * Returns the name on file for this account.
     */
    @Column(name="NAME", nullable=false, length=DB_NAME_LENGTH)
    public String getName() {
        return name;
    }
    /**
     * Sets the name on file for this account.
     * @param name The name for this account
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the amount of savings this beneficiary has accrued.
     */
    @Column(name="SAVINGS", nullable=false)
    public BigDecimal getSavings() {
        return savings;
    }

    public void setSavings(BigDecimal savings) {
        this.savings = savings;
    }
    /**
     * Returns the emailAddress on file for this account.
     */
    @Column(name="EMAIL", nullable=false, length=DB_NAME_LENGTH)
    public String getEmailAddress() {
        return EmailAddress;
    }
    /**
     * Sets the emailAddress on file for this account.
     * @param emailAddress The emailAddress for this account
     */
    public void setEmailAddress(String emailAddress) {
        this.EmailAddress = emailAddress;
    }
    /**
     * Returns the emailAddress on file for this account.
     */
    @Column(name="NOTIFICACIONEMAIL", nullable=false, columnDefinition = "int default 0")
    public boolean getIsNotificationEmail() {
        return IsNotificationEmail;
    }
    /**
     * Sets the isNotificationEmail on file for this account.
     * @param isNotificationEmail The isNotificationEmail for this account
     */
    public void setIsNotificationEmail(boolean isNotificationEmail) {
        this.IsNotificationEmail = isNotificationEmail;
    }
    public AccountContribution makeContribution(BigDecimal amount) {
        return new AccountContribution(getNumber(), amount);
    }
    public String toString() {
        return "Number = '" + number + "', name = " + name + "',creditCardNumber ='"+creditCardNumber+"', saving = " + savings;
    }
    //INSERT INTO reward.t_account values(1,'480112451450012','JUAN PEREZ','12345678',0)
    //INSERT INTO reward.t_account values(2,'154112451450012','LUSI PARI','87654321',0)

}