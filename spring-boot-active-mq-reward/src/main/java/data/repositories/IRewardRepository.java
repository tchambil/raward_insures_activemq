package  data.repositories;

import cs.utec.edu.reward.producer.rewards.RewardConfirmation;
import cs.utec.edu.reward.producer.common.datetime.SimpleDate;
import  data.entities.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface IRewardRepository  extends JpaRepository<Reward, Long> {
    /**
 * Load a REWARD entity
* @param confirmationNumber the  Confirmation Number
* @param Amount the Amount
* @param CreationDate the  Creation Date
* @param AccountNumber the Account Number
* @param DinnigDate the  Dinnig Date
* @param DinningMerchantNumber the merchant number
* @param DinnigAmount the Dinnig Amount
* @return the RewardConfirmation
*/
    @Query(value = "insert into T_REWARD (CONFIRMATION_NUMBER, AMOUNT, REWARD_DATE, ACCOUNT_NUMBER, DINING_MERCHANT_NUMBER, DINING_DATE, DINING_AMOUNT) values (?, ?, ?, ?, ?, ?, ?)",nativeQuery = true)
    public RewardConfirmation confirmReward(String confirmationNumber,BigDecimal Amount,SimpleDate CreationDate, String AccountNumber,String DinningMerchantNumber, SimpleDate DinnigDate, BigDecimal DinnigAmount);
}

