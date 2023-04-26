package com.market.isteucuzagelsin.Dto.Response;

public class AccountResponse {
    private String accountNumber;
    private String createdDate;
    private Double cash;
    private String customerFirstName;
    private String customerLastName;
    private String customerNumberPhone;

    public AccountResponse(String accountNumber, String createdDate,
                           Double cash, String customerFirstNameName,
                           String customerLastName, String customerNumberPhone) {
        this.accountNumber = accountNumber;
        this.createdDate = createdDate;
        this.cash = cash;
        this.customerFirstName = customerFirstNameName;
        this.customerLastName = customerLastName;
        this.customerNumberPhone = customerNumberPhone;
    }

    public AccountResponse() {
    }

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

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerNumberPhone() {
        return customerNumberPhone;
    }

    public void setCustomerNumberPhone(String customerNumberPhone) {
        this.customerNumberPhone = customerNumberPhone;
    }
}
