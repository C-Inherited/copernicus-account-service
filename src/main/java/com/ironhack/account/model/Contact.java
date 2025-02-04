package com.ironhack.account.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Contact() {
    }

    public Contact(String name,
                   String phoneNumber,
                   String email,
                   String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccountId(Account account) {
        this.account = account;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) &&
               Objects.equals(phoneNumber, contact.phoneNumber) &&
               Objects.equals(email, contact.email) &&
               Objects.equals(companyName, contact.companyName);
    }
}
