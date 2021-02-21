package com.ironhack.account.dto;

import com.ironhack.account.model.Contact;

public class ContactDTO {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private Integer accountId;

    public ContactDTO() {
    }

    public ContactDTO(Contact contact){
        setName(contact.getName());
        setPhoneNumber(contact.getPhoneNumber());
        setEmail(contact.getEmail());
        setCompanyName(contact.getCompanyName());
        setAccountId(contact.getAccount().getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}