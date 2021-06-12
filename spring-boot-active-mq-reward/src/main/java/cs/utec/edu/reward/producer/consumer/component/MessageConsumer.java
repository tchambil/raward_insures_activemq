package cs.utec.edu.reward.producer.consumer.component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.springframework.jms.annotation.JmsListener;
@Component
public class MessageConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);
    @JmsListener(destination = "reward-queue")
    public void messageListener(Object systemMessage) {
        LOGGER.info("Message received! {}", systemMessage);
    }

}