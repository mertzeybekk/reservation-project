package com.market.isteucuzagelsin.Dto.Response;

public class CrediCardResponse {
    private String crediCardNumber;
    private String validtyDate;
    private String securityNumber;
    private String customerFirstName;
    private String customerLastName;
    private String accountNumber;
    private int crediCardPassword;

    public CrediCardResponse(String crediCardNumber,
                             String validtyDate,
                             String securityNumber,
                             String customerName,
                             String customerLastName,
                             int crediCardPassword,
                             String accountNumber) {
        this.crediCardNumber = crediCardNumber;
        this.validtyDate = validtyDate;
        this.securityNumber = securityNumber;
        this.customerFirstName = customerName;
        this.customerLastName = customerLastName;
        this.accountNumber = accountNumber;
        this.crediCardPassword = crediCardPassword;
    }

    public CrediCardResponse() {
    }

    public String getCrediCardNumber() {
        return crediCardNumber;
    }

    public void setCrediCardNumber(String crediCardNumber) {
        this.crediCardNumber = crediCardNumber;
    }

    public String getValidtyDate() {
        return validtyDate;
    }

    public void setValidtyDate(String validtyDate) {
        this.validtyDate = validtyDate;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public String getCustomerName() {
        return customerFirstName;
    }

    public void setCustomerName(String customerName) {
        this.customerFirstName = customerName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }
}
