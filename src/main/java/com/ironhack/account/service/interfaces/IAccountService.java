package com.ironhack.account.service.interfaces;

import com.ironhack.account.dto.AccountDTO;

public interface IAccountService {

    public AccountDTO getAccount(Integer id);
    public AccountDTO createAccount(AccountDTO accountDTO);
    public AccountDTO updateAccount(AccountDTO accountDTO, Integer id);
    public void deleteAccount(Integer id);
}
