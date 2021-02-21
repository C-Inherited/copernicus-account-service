package com.ironhack.account.controller.impl;

import com.ironhack.account.controller.interfaces.IAccountStatsController;
import com.ironhack.account.service.impl.AccountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountStatsController implements IAccountStatsController {

    @Autowired
    private AccountStatsService accountStatsService;

    @GetMapping("/stats/findMeanEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public Object[] findMeanEmployeeCount(){
        return accountStatsService.findMeanEmployeeCount();
    }

    @GetMapping("/stats/orderEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> orderEmployeeCount(){
        return accountStatsService.orderEmployeeCount();
    }

    @GetMapping("/stats/findMinEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public Object[] findMinEmployeeCount(){
        return accountStatsService.findMinEmployeeCount();
    }

    @GetMapping("/stats/findMaxEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public Object[] findMaxEmployeeCount(){
        return  accountStatsService.findMaxEmployeeCount();
    }

}
