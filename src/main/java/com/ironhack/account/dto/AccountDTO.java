package com.ironhack.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ironhack.account.model.Account;
import com.ironhack.account.model.Contact;
import com.ironhack.account.model.Opportunity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<OpportunityDTO> opportunities = null;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ContactDTO> contacts = null;

    public AccountDTO() {
    }


    public AccountDTO(Integer id, @NotEmpty String industry, @NotNull @Min(value = 0, message = "can not less than 0") Integer employeeCount, @NotEmpty String city, @NotEmpty String country) {
        this.id = id;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
    }

    public AccountDTO(Integer id, @NotEmpty String industry, @NotNull @Min(value = 0, message = "can not less than 0") Integer employeeCount, @NotEmpty String city, @NotEmpty String country, List<OpportunityDTO> opportunities, List<ContactDTO> contacts) {
        this.id = id;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.opportunities = opportunities;
        this.contacts = contacts;
    }

    public static AccountDTO parseFromAccount(Account account) {
        return new AccountDTO(
                account.getId(),
                account.getIndustry().name(),
                account.getEmployeeCount(),
                account.getCity(),
                account.getCountry(),
                account.getOpportunityList().stream().map(OpportunityDTO::parseFromOpportunity).collect(Collectors.toList()),
                account.getContactList().stream().map(ContactDTO::new).collect(Collectors.toList())
        );
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<OpportunityDTO> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<OpportunityDTO> opportunities) {
        this.opportunities = opportunities;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDTO that = (AccountDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(industry, that.industry) && Objects.equals(employeeCount, that.employeeCount) && Objects.equals(city, that.city) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, industry, employeeCount, city, country);
    }
}
