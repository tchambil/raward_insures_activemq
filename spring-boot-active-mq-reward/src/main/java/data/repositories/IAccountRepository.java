package  data.repositories;

import data.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT * from t_account a  where a.credit_card = :creditCardNumber",nativeQuery = true)
    Account findByCreditCard(String creditCardNumber);
    @Query(value = "SELECT * from Account",nativeQuery = true)
    List<Account> getAllAccounts();

    @Modifying
    @Query(value = "UPDATE t_account a SET a.savings = :?1 WHERE a.credit_card = : ?2",nativeQuery = true)
    public void updateSavings(  BigDecimal psavings, String pcreditCardNumber);
}
