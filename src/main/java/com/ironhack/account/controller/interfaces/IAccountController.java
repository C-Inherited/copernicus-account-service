package com.ironhack.account.controller.interfaces;

import com.ironhack.account.dto.AccountDTO;

import java.util.List;

public interface IAccountController {

    public AccountDTO getAccount( Integer id);
    public List<AccountDTO> getAllAccounts();
    public AccountDTO saveAccount( AccountDTO accountDTO);
    public AccountDTO updateAccount( AccountDTO accountDTO, Integer id);
    public void deleteAccount(Integer id);
}
