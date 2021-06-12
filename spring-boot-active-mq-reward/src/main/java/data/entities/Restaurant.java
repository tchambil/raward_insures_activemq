package data.entities;


import data.dtos.DiningDto;

import javax.persistence.*;
import java.math.BigDecimal;

import static config.GlobalConstants.*;


/**
 * A restaurant establishment in the network. Like AppleBee's.
 *
 * Restaurants calculate how much benefit may be awarded to an account for dining based on a availability policy and a
 * benefit percentage.
 */
@Entity
@Table(name="T_Restaurant")
public class Restaurant {
    private Long entityId;
    private String number;
    private String name;
    private BigDecimal benefitPercentage;
    private String benefitAvailabilityPolicy;
    public Restaurant() {
    }

    public Restaurant(String number, String name, BigDecimal benefitPercentage, String benefitAvailabilityPolicy) {
        this.number = number;
        this.name = name;
        this.benefitPercentage = benefitPercentage;
        this.benefitAvailabilityPolicy = benefitAvailabilityPolicy;
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
     * Returns the number used to uniquely identify this Restaurant.
     */
    @Column(name="NUMBER", nullable=false, length=DB_DNI_LENGTH)
    public String getNumber() {
        return number;
    }

    /**
     * Sets the number used to uniquely identify this Restaurant.
     * @param number The number for this account
     */
    public void setNumber(String number) {
        this.number = number;
    }
    /**
     * Returns the name on file for this Restaurant.
     */
    @Column(name="NAME", nullable=false, length=DB_NAME_LENGTH)
    public String getName() {
        return name;
    }

    /**
     * Sets the name on file for this Restaurant.
     * @param name The name for this Restaurant
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the percentage benefit to be awarded for eligible dining transactions.
     * @param benefitPercentage the benefit percentage
     */
    @Column(name="benefitPercentage", nullable=false)
    public void setBenefitPercentage(BigDecimal benefitPercentage) {
        this.benefitPercentage = benefitPercentage;
    }
    /**
     * Returns this restaurant's benefit percentage.
     */
    public BigDecimal getBenefitPercentage() {
        return benefitPercentage;
    }

    /**
     * Sets the policy that determines if a dining by an account at this restaurant is eligible for benefit.
     * @param benefitAvailabilityPolicy the benefit availability policy
     */
    @Column(name="BenefitAvailability", nullable=false, length = 1)
    public void setBenefitAvailabilityPolicy(String benefitAvailabilityPolicy) {
        this.benefitAvailabilityPolicy = benefitAvailabilityPolicy;
    }
    /**
     * Returns this restaurant's benefit availability policy.
     */
    public String getBenefitAvailabilityPolicy() {
        return benefitAvailabilityPolicy;
    }
    /**
     * Calculate the benefit eligible to this account for dining at this restaurant.
     *  @param account the account that dined at this restaurant
     * @param dining a dining event that occurred
     * @return the benefit amount eligible for reward
     */
    public BigDecimal calculateBenefitFor(Account account, DiningDto dining) {
        BigDecimal points = BigDecimal.valueOf(0.0D) ;
        if (benefitAvailabilityPolicy.equals("A")) {
            if(account.getIsNotificationEmail()){
                points = dining.getAmount().multiply(BigDecimal.valueOf(POINTEMAILACTIVE));
            }
            else{
                points = (dining.getAmount().divide(BigDecimal.valueOf(2))).multiply(BigDecimal.valueOf(POINTEMAILNOTACTIVE));
            }
            /*Todo Implementar los demas condiciones */
        }
       return points;
    }
    public String toString() {
        return "Number = '" + number + "', name = '" + name + "', benefitPercentage = " + benefitPercentage
                + ", benefitAvailabilityPolicy = " + benefitAvailabilityPolicy;
    }
    //INSERT INTO reward.t_restaurant values(1,'N',10,'HUMM SAC','87654323')
    //INSERT INTO reward.t_restaurant values(2,'A',5,'TU COMIDA SAC','87654321')
}
