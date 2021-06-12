package business.service;

import cs.utec.edu.reward.producer.rewards.AccountContribution;
import cs.utec.edu.reward.producer.rewards.RewardConfirmation;
import com.google.gson.Gson;
import cs.utec.edu.reward.producer.common.datetime.SimpleDate;
import  data.dtos.DiningDto;
import  data.entities.Account;
import data.entities.Restaurant;
import  data.entities.Reward;
import  data.repositories.IAccountRepository;
import  data.repositories.IRestaurantRepository;
import  data.repositories.IRewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;
@Service
@Transactional
public class RewardService {
    @Autowired
    private IRewardRepository rewardRepository  ;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IRestaurantRepository restaurantRepository  ;
    @Autowired
    private JmsTemplate jmsTemplate;
    private RewardConfirmation confirmReward(AccountContribution contribution, DiningDto dining){
        var reward = new Reward();
        String confirmationNumber = nextConfirmationNumber();
        reward.setConfirmationNumber(confirmationNumber);
        reward.setAmount(contribution.getAmount());
        reward.setCreationDate(SimpleDate.today());
        reward.setAccountNumber(contribution.getAccountNumber());
        reward.setDinningMerchantNumber(dining.getMerchantNumber());
        //reward.setDinnigDate(new SimpleDate(dining.getDate().getYear(),dining.getDate().getMonth(), dining.getDate().getDay()));
        reward.setDinnigDate(SimpleDate.today());
        reward.setDinnigAmount(dining.getAmount());
        var output =  rewardRepository.save(reward);
        var textMessage = new Gson().toJson(getRewardConfirmation(contribution, output));
        jmsTemplate.convertAndSend("reward-queue", textMessage);
        return getRewardConfirmation(contribution, output);
    }
    private RewardConfirmation getRewardConfirmation(AccountContribution contribution, Reward output) {
        return new RewardConfirmation(output.getConfirmationNumber(), contribution);
    }
    public RewardConfirmation rewardAccountFor(DiningDto dining){
        Account account = accountRepository.findByCreditCard(dining.getCreditCardNumber());
        Restaurant restaurant = restaurantRepository.findByMerchantNumber(dining.getMerchantNumber());
        BigDecimal amount = restaurant.calculateBenefitFor(account,dining);
        AccountContribution contribution = account.makeContribution(amount);
        return confirmReward(contribution,dining);
    }
    private String nextConfirmationNumber() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
