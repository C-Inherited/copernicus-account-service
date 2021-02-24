package com.ironhack.account.controller.impl;

import com.ironhack.account.controller.interfaces.IAccountController;
import com.ironhack.account.dto.AccountDTO;
import com.ironhack.account.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountController  {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO getAccount(@PathVariable(name = "id") Integer id, @RequestHeader(value = "Authorization") String authorizationHeader) {
        return accountService.getAccount(id);
    }

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> getAllAccounts(@RequestHeader(value = "Authorization") String authorizationHeader) {
        return accountService.findAll();
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO saveAccount(@RequestBody @Valid AccountDTO accountDTO, @RequestHeader(value = "Authorization") String authorizationHeader) {
        return accountService.createAccount(accountDTO);
    }

    @PutMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO updateAccount(@RequestBody @Valid AccountDTO accountDTO, @PathVariable(name = "id") Integer id, @RequestHeader(value = "Authorization") String authorizationHeader) {
        return accountService.updateAccount(accountDTO, id);
    }

    @DeleteMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable(name = "id") Integer id, @RequestHeader(value = "Authorization") String authorizationHeader) {
        accountService.deleteAccount(id);
    }
}
