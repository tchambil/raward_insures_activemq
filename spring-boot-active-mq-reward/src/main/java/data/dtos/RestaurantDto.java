package data.dtos;

import java.math.BigDecimal;

public class RestaurantDto {
    private Long entityId;
    private String number;

    private String name;

    private BigDecimal benefitPercentage;

    private String benefitAvailabilityPolicy;
    public RestaurantDto() {
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

    public BigDecimal getBenefitPercentage() {
        return benefitPercentage;
    }

    public void setBenefitPercentage(BigDecimal benefitPercentage) {
        this.benefitPercentage = benefitPercentage;
    }

    public String getBenefitAvailabilityPolicy() {
        return benefitAvailabilityPolicy;
    }

    public void setBenefitAvailabilityPolicy(String benefitAvailabilityPolicy) {
        this.benefitAvailabilityPolicy = benefitAvailabilityPolicy;
    }
}
