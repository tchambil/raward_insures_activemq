package business.service;

import business.custom_exceptions.CustomNotFoundException;
import  data.dtos.AccountDto;
import  data.entities.Account;
import  data.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @SuppressWarnings("unchecked")
    public Account findByCreditCard(String creditCardNumber) {
        Account accounts  = accountRepository.findByCreditCard(creditCardNumber);
        return accounts;

    }

    @SuppressWarnings("unchecked")
    public List<Account> getAllAccounts() {
        List<Account> accounts = accountRepository.getAllAccounts();
        return accounts;
    }
    public Account getAccount(Long id){
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isPresent()) return accountOptional.get();
        else throw new CustomNotFoundException("La cuenta con el id " + id + " no existe!");
    }
    public Account Update(AccountDto input){
        var account = new Account();
        account.setNumber(input.getNumber());
        account.setName(input.getName());
        account.setCreditCardNumber(input.getCreditCardNumber());
        account.setSavings(input.getSavings());
        return accountRepository.save(account);

    }
}
