package com.ironhack.account.controller.interfaces;

import java.util.List;

public interface IAccountStatsController {

    public Object[] findMeanEmployeeCount();
    public List<Object[]> orderEmployeeCount();
    public Object[] findMinEmployeeCount();
    public Object[] findMaxEmployeeCount();
}
