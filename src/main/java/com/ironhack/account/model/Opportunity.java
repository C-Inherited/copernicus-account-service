package com.ironhack.account.model;

import com.ironhack.account.enums.*;
import com.ironhack.account.model.Contact;
import com.ironhack.account.model.Account;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int opportunityId;
    @Enumerated(EnumType.STRING)
    private Product product;
    private int quantity;

    @OneToOne
    @JoinColumn(name="contact_id")
    private Contact decisionMaker;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer salesRepId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Opportunity() {
    }

    public Opportunity(int opportunityId, Product product, int quantity, Contact decisionMaker, Status status, Integer salesRepId, Account account) {
        this.opportunityId = opportunityId;
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRepId = salesRepId;
        this.account = account;
    }

    public Account getAccountId() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public int getOpportunityId() {
        return opportunityId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOpportunityId(int opportunityId) {
        this.opportunityId = opportunityId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Integer getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(Integer salesRepId) {
        this.salesRepId = salesRepId;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opportunity that = (Opportunity) o;
        return quantity == that.quantity &&
               product == that.product &&
               Objects.equals(decisionMaker, that.decisionMaker) &&
                status == that.status;
    }
}
