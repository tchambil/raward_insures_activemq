package data.dtos;

import java.math.BigDecimal;

public class AccountDto {
    private Long entityId;
    private String number;
    private String name;
    private BigDecimal savings ;
    private String creditCardNumber;
    private String EmailAddress;
    private boolean IsNotificationEmail;
    public AccountDto() {
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public BigDecimal getSavings() {
        return savings;
    }

    public void setSavings(BigDecimal savings) {
        this.savings = savings;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public boolean isNotificationEmail() {
        return IsNotificationEmail;
    }

    public void setNotificationEmail(boolean notificationEmail) {
        IsNotificationEmail = notificationEmail;
    }
}
