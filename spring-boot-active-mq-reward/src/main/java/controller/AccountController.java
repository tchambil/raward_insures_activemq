package controller;

import business.service.AccountService;
import  data.dtos.AccountDto;
import  data.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{creditCard}")
    public Account findByCreditCard( @PathVariable String creditCard){
        return accountService.findByCreditCard(creditCard);
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccount(id);
    }
    @PostMapping
    public Account postAccount(@RequestBody AccountDto input){
        return accountService.Update(input);
    }

}
