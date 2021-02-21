package com.ironhack.account.service.impl;

import com.ironhack.account.repository.AccountRepository;
import com.ironhack.account.service.interfaces.IAccountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountStatsService implements IAccountStatsService {

    @Autowired
    private AccountRepository accountRepository;

    public Object[] findMeanEmployeeCount(){
       return accountRepository.findMeanEmployeeCount();
    }

    public List<Object[]> orderEmployeeCount(){
     return accountRepository.orderEmployeeCount();
    }

    public Object[] findMinEmployeeCount(){
       return accountRepository.findMinEmployeeCount();
    }
    public Object[] findMaxEmployeeCount(){
        return  accountRepository.findMaxEmployeeCount();
    }
}
