package data.dtos;

import cs.utec.edu.reward.producer.common.datetime.SimpleDate;
import java.math.BigDecimal;
import java.util.Date;

public class DiningDto {
    private BigDecimal amount;

    private String creditCardNumber;

    private String merchantNumber;

    private Date date;

    /**
     * Creates a new dining, reflecting an amount that was charged to a card by a merchant on the date specified.
     * @param amount the total amount of the dining bill
     * @param creditCardNumber the number of the credit card used to pay for the dining bill
     * @param merchantNumber the merchant number of the restaurant where the dining occurred
     * @param date the date of the dining event
     */
    public DiningDto(BigDecimal amount, String creditCardNumber, String merchantNumber, Date date) {
        this.amount = amount;
        this.creditCardNumber = creditCardNumber;
        this.merchantNumber = merchantNumber;
        this.date =date ;
    }

    /**
     * Creates a new dining, reflecting an amount that was charged to a credit card by a merchant on today's date. A
     * convenient static factory method.
     * @param amount the total amount of the dining bill as a string
     * @param creditCardNumber the number of the credit card used to pay for the dining bill
     * @param merchantNumber the merchant number of the restaurant where the dining occurred
     * @return the dining event
     */
    public static DiningDto createDining(BigDecimal amount, String creditCardNumber, String merchantNumber) {
        return new DiningDto(amount, creditCardNumber, merchantNumber, SimpleDate.today().asDate());
    }

    /**
     * Creates a new dining, reflecting an amount that was charged to a credit card by a merchant on the date specified.
     * A convenient static factory method.
     * @param amount the total amount of the dining bill as a string
     * @param creditCardNumber the number of the credit card used to pay for the dining bill
     * @param merchantNumber the merchant number of the restaurant where the dining occurred
     * @param month the month of the dining event
     * @param day the day of the dining event
     * @param year the year of the dining event
     * @return the dining event
     */
    public static DiningDto createDining(BigDecimal amount, String creditCardNumber, String merchantNumber, int month,
                                      int day, int year) {
        return new DiningDto(amount, creditCardNumber, merchantNumber, new SimpleDate(month, day,
                year).asDate());
    }

    /**
     * Returns the amount of this dining--the total amount of the bill that was charged to the credit card.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Returns the number of the credit card used to pay for this dining. For this dining to be eligible for reward,
     * this credit card number should be associated with a valid account in the reward network.
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Returns the merchant number of the restaurant where this dining occurred. For this dining to be eligible for
     * reward, this merchant number should be associated with a valid restaurant in the reward network.
     */
    public String getMerchantNumber() {
        return merchantNumber;
    }

    /**
     * Returns the date this dining occurred on.
     */
    public Date getDate() {
        return date;
    }

    public boolean equals(Object o) {
        if (!(o instanceof DiningDto)) {
            return false;
        }
        DiningDto other = (DiningDto) o;
        // value objects are equal if their attributes are equal
        return amount.equals(other.amount) && creditCardNumber.equals(other.creditCardNumber)
                && merchantNumber.equals(other.merchantNumber) && date.equals(other.date);
    }

    public int hashCode() {
        return amount.hashCode() + creditCardNumber.hashCode() + merchantNumber.hashCode() + date.hashCode();
    }

    public String toString() {
        return "Dining of " + amount + " charged to '" + creditCardNumber + "' by '" + merchantNumber + "' on " + date;
    }
}
