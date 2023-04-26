package com.market.isteucuzagelsin.Dto.Request;

import com.market.isteucuzagelsin.Entity.CrediCard;

public class CrediCardRequest {
    private String crediCardNumber;
    private String vaidtyDate;
    private String securityNumber;
    private int customerId;
    private int crediCardPassword;

    public CrediCardRequest(String crediCardNumber, String vaidtyDate,
                            String securityNumber, int customerId, int crediCardPassword) {
        this.crediCardNumber = crediCardNumber;
        this.vaidtyDate = vaidtyDate;
        this.securityNumber = securityNumber;
        this.customerId = customerId;
        this.crediCardPassword = crediCardPassword;
    }

    public CrediCardRequest() {
    }

    public String getCrediCardNumber() {
        return crediCardNumber;
    }

    public void setCrediCardNumber(String crediCardNumber) {
        this.crediCardNumber = crediCardNumber;
    }

    public String getVaidtyDate() {
        return vaidtyDate;
    }

    public void setVaidtyDate(String vaidtyDate) {
        this.vaidtyDate = vaidtyDate;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCrediCardPassword() {
        return crediCardPassword;
    }

    public void setCrediCardPassword(int crediCardPassword) {
        this.crediCardPassword = crediCardPassword;
    }
}
