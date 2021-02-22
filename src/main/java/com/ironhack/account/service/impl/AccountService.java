package com.ironhack.account.service.impl;

import com.ironhack.account.dto.AccountDTO;
import com.ironhack.account.enums.Industry;
import com.ironhack.account.model.Account;
import com.ironhack.account.repository.AccountRepository;
import com.ironhack.account.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<AccountDTO> findAll(){
        return accountRepository.findAll().stream().map(AccountDTO::parseFromAccount).collect(Collectors.toList());
    }

    public AccountDTO getAccount(Integer id){
        Account account = accountRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not Found"));

        return AccountDTO.parseFromAccount(account);
    }

    @Transactional
    public AccountDTO createAccount(AccountDTO accountDTO){
       Account account = accountRepository.save(new Account(Industry.valueOf(accountDTO.getIndustry()),accountDTO.getEmployeeCount(), accountDTO.getCity(), accountDTO.getCountry()));

       return new AccountDTO(account.getId(), account.getIndustry().name(),account.getEmployeeCount(),account.getCity(),account.getCountry());
    }

    public AccountDTO updateAccount(AccountDTO accountDTO, Integer id){
        accountRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not Found"));
        Account account = new Account(Industry.valueOf(accountDTO.getIndustry()),accountDTO.getEmployeeCount(), accountDTO.getCity(), accountDTO.getCountry());
        account.setId(id);
        Account accountUpdated = accountRepository.save(account);

        return AccountDTO.parseFromAccount(accountUpdated);
    }

    public void deleteAccount(Integer id){
        Account account = accountRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not Found"));

        accountRepository.delete(account);
    }


}
