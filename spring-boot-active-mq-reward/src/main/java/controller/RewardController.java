package controller;

import business.service.RewardService;
import cs.utec.edu.reward.producer.rewards.RewardConfirmation;
import  data.dtos.DiningDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reward")
public class RewardController {
    @Autowired
    private RewardService rewardService;
    @PostMapping
    public RewardConfirmation rewardAccountFor(@RequestBody DiningDto input){
        return rewardService.rewardAccountFor(input);
    }
}
