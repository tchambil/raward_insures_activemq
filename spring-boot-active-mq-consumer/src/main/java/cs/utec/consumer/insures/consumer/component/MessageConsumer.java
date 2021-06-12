package cs.utec.consumer.insures.consumer.component;


import com.google.gson.Gson;
import cs.utec.consumer.insures.data.repositories.AccountRepository;
import cs.utec.consumer.insures.data.repositories.IAccountRepository;
import cs.utec.consumer.insures.reward.RewardConfirmation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

/**
 *
 * @author cs
 *
 */
@Component
public class MessageConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);
    @JmsListener(destination = "reward-queue")
    public void messageListener(String Message) {
        try {
            IAccountRepository accountRepository = new AccountRepository();
            RewardConfirmation confirmation = getJsonRewardConfirmation(Message);
            BigDecimal amount = confirmation.getAccountContribution().getAmount();
            accountRepository.updateSavings(amount, confirmation.getAccountContribution().getAccountNumber());
            LOGGER.info("Mensaje procesado correctamente {}",Message);
        }
        catch (Exception ex) {
            LOGGER.info("Ocurrió un error al procesar mensaje {}",Message);
        }
    }

    private RewardConfirmation getJsonRewardConfirmation(String Message) {
       return new Gson().fromJson(Message, RewardConfirmation.class);

           /*RewardConfirmation confirmation = new RewardConfirmation();
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(systemMessage);
            String confirmationNumber = (String) jsonObject.get("confirmationNumber");
            JSONObject accountContribution = (JSONObject) jsonObject.get("accountContribution");
            Long amount = (Long) accountContribution.get("amount");
            String accountNumber = (String) accountContribution.get("accountNumber");
            return new RewardConfirmation  (confirmationNumber,new AccountContribution(accountNumber, BigDecimal.valueOf(amount)));

        } catch (ParseException e) {
            LOGGER.info("Error al convertir message");
        }
        return confirmation;*/
    }
}
