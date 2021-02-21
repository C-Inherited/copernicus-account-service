package com.ironhack.account.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountDTO {


    private Integer id;
    @NotEmpty
    private String industry;
    @NotNull
    @Min(value = 0, message = "can not less than 0")
    private Integer employeeCount;
    @NotEmpty
    private String city;
    @NotEmpty
    private String country;




}
