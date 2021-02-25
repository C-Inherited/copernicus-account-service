package com.ironhack.account.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.account.dto.AccountDTO;
import com.ironhack.account.enums.Industry;
import com.ironhack.account.model.Account;
import com.ironhack.account.service.impl.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AccountControllerTest {


    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;
    private AccountDTO accountDto;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        accountDto = new AccountDTO(1, Industry.ECOMMERCE.name(), 50, "madrid", "espana");

    }


    @Test
    void findAccountCorrectly() throws Exception {
        String expectedResponse = "{\"id\":1,\"industry\":\"ECOMMERCE\",\"employeeCount\":50,\"city\":\"madrid\",\"country\":\"espana\"}";
        when(accountService.getAccount(1)).thenReturn(accountDto);

        MvcResult result = mockMvc
                .perform(get("/account/1")
                        .header("Authorization", "Bearer auth"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponse, result.getResponse().getContentAsString());

    }

    @Test
    void findAllAccountsCorrectly() throws Exception {
        String expectedResponse = "[{\"id\":1,\"industry\":\"ECOMMERCE\",\"employeeCount\":50,\"city\":\"madrid\",\"country\":\"espana\"}]";
        when(accountService.findAll()).thenReturn(List.of(accountDto));

        MvcResult result = mockMvc
                .perform(
                        get("/accounts")
                                .header("Authorization", "Bearer auth"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }

    @Test
    void createAccountCorrectly() throws Exception {
        String expectedResponse = "{\"id\":1,\"industry\":\"ECOMMERCE\",\"employeeCount\":50,\"city\":\"madrid\",\"country\":\"espana\"}";
        when(accountService.createAccount(accountDto)).thenReturn(accountDto);

        String body = objectMapper.writeValueAsString(accountDto);

        MvcResult result = mockMvc
                .perform(post("/account")
                        .header("Authorization", "Bearer auth")
                        .content(body).contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andReturn();

        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }

    @Test
    void updateAccountCorrectly() throws Exception {
        String expectedResponse = "{\"id\":1,\"industry\":\"ECOMMERCE\",\"employeeCount\":50,\"city\":\"madrid\",\"country\":\"espana\"}";
        when(accountService.updateAccount(accountDto, 1)).thenReturn(accountDto);

        String body = objectMapper.writeValueAsString(accountDto);

        MvcResult result = mockMvc
                .perform(put("/account/1")
                        .content(body)
                        .header("Authorization", "Bearer auth")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }

    @Test
    void deleteAccountCorrectly() throws Exception {
        when(accountService.updateAccount(accountDto, 1)).thenReturn(accountDto);

        mockMvc
                .perform(delete("/account/1")
                        .header("Authorization", "Bearer auth"))
                .andExpect(status().isOk())
                .andReturn();
    }

}

