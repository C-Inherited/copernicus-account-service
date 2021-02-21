package com.ironhack.account.service.interfaces;

import java.util.List;

public interface IAccountStatsService {
    public Object[] findMeanEmployeeCount();
    public List<Object[]> orderEmployeeCount();
    public Object[] findMinEmployeeCount();
    public Object[] findMaxEmployeeCount();
}
