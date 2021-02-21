package com.ironhack.account.dto;

import com.ironhack.account.model.Opportunity;

public class OpportunityDTO {
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
}