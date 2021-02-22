package com.ironhack.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ironhack.account.model.Opportunity;

import java.util.Objects;

public class OpportunityDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String product;
    private Integer quantity;
    private Integer contactId;
    private Integer salesRepId;
    private Integer accountId;

    private String status;

    public OpportunityDTO() {
    }

    public OpportunityDTO(Integer id, String product, Integer quantity, Integer contactId, Integer salesRepId, Integer accountId, String status) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.contactId = contactId;
        this.salesRepId = salesRepId;
        this.accountId = accountId;
        this.status = status;
    }

    public static OpportunityDTO parseFromOpportunity(Opportunity opportunity){
        return new OpportunityDTO(opportunity.getId(),
                opportunity.getProduct().toString(),
                opportunity.getQuantity(),
                opportunity.getDecisionMaker().getId(),
                opportunity.getSalesRepId(),
                opportunity.getAccount().getId(),
                opportunity.getStatus().toString());
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(Integer salesRepId) {
        this.salesRepId = salesRepId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpportunityDTO that = (OpportunityDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(quantity, that.quantity) && Objects.equals(contactId, that.contactId) && Objects.equals(salesRepId, that.salesRepId) && Objects.equals(accountId, that.accountId) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, quantity, contactId, salesRepId, accountId, status);
    }
}
