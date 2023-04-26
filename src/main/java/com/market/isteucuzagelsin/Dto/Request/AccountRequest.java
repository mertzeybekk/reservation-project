package com.market.isteucuzagelsin.Dto.Request;

public class AccountRequest {
    private String accountNumber;
    private String createdDate;
    private Double cash;
    private int customerId;

    public AccountRequest(String accountNumber, String createdDate,
                          Double cash, int customerId) {
        this.accountNumber = accountNumber;
        this.createdDate = createdDate;
        this.cash = cash;
        this.customerId = customerId;
    }
    public AccountRequest(){}

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
