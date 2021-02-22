package com.ironhack.account.service.impl;

import com.ironhack.account.dto.AccountDTO;
import com.ironhack.account.enums.Industry;
import com.ironhack.account.model.Account;
import com.ironhack.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class AccountServiceTest {

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    private Account account;
    private AccountDTO accountDto;

    @BeforeEach
    void setUp() {
         account = new Account(Industry.ECOMMERCE,50,"madrid","espana");
         accountDto = new AccountDTO(null,Industry.ECOMMERCE.name(), 50,"madrid", "espana");
    }

    @Test
    void findById_Exception() {
        when(accountRepository.findById(account.getId())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()-> accountService.getAccount(account.getId()));
    }

    @Test
    void findAll() {
        when(accountRepository.findAll()).thenReturn(List.of(account));

        List<AccountDTO> accounts = accountService.findAll();

        assertEquals(List.of(accountDto),accounts);
    }

    @Test
    void getAccount() {
        when(accountRepository.findById(account.getId())).thenReturn(ofNullable(account));

        AccountDTO accountDTO = accountService.getAccount(account.getId());

        assertEquals(accountDto,accountDTO);
    }

    @Test
    void createAccount() {
        when(accountRepository.save(account)).thenReturn(account);

        AccountDTO accountDtoResponse = accountService.createAccount(accountDto);

        assertEquals(accountDto,accountDtoResponse);
    }

    @Test
    void deleteAccount() {
        when(accountRepository.findById(account.getId())).thenReturn(ofNullable(account));

        accountService.deleteAccount(account.getId());

        verify(accountRepository).delete(account);
    }

    @Test
    void updateAccount() {
        AccountDTO accountDto = new AccountDTO(1, Industry.MEDICAL.name(), 20, "sevilla", "espana");
        Account accountModified= new Account(Industry.MEDICAL, 20, "sevilla", "espana");
        account.setId(1);
        accountModified.setId(1);
        when(accountRepository.findById(account.getId())).thenReturn(ofNullable(account));
        when(accountRepository.save(accountModified)).thenReturn(accountModified);

        AccountDTO accountDtoResponse = accountService.updateAccount(accountDto,1);

        assertEquals(accountDto, accountDtoResponse);
    }
}
