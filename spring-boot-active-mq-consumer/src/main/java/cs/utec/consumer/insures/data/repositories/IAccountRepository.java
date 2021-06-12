package cs.utec.consumer.insures.data.repositories;

import java.math.BigDecimal;


public interface IAccountRepository {
    void updateSavings(  BigDecimal psavings, String accountNumber);
}
