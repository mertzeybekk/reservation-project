package com.market.isteucuzagelsin.Dto.Response;

import com.market.isteucuzagelsin.Entity.*;

import java.util.List;
import java.util.Map;

public class CustomerResponse {
    private String customerFirstName;
    private String customerLastName;
    private String customerNumberPhone;
    private String customerEmail;
    private Map<Integer, Address> adressList;
    private Map<Integer, Account> accountList;
    private Map<Integer, Reservasion> reservasion;
    private Map<Integer, Invoice> invoiceList;
    private Map<Integer, CrediCard> crediCardList;


    public CustomerResponse() {
    }

    public CustomerResponse(String customerFirstName, String customerLastName, String customerPhoneNumber, String customerEmail, Map<Integer, Address> addressList, Map<Integer, Account> accountList, Map<Integer, Reservasion> reservasionList,
                            Map<Integer, Invoice> invoiceList, Map<Integer, CrediCard> crediCardList) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerNumberPhone = customerPhoneNumber;
        this.customerEmail = customerEmail;
        this.adressList = addressList;
        this.accountList = accountList;
        this.reservasion = reservasionList;
        this.invoiceList = invoiceList;
        this.crediCardList = crediCardList;
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

    public String getCustomerPhoneNumber() {
        return customerNumberPhone;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerNumberPhone = customerPhoneNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Map<Integer, Address> getAddressList() {
        return adressList;
    }

    public void setAddressList(Map<Integer, Address> addressList) {
        this.adressList = addressList;
    }

    public Map<Integer, Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(Map<Integer, Account> accountList) {
        this.accountList = accountList;
    }

    public Map<Integer, Reservasion> getReservasionList() {
        return reservasion;
    }

    public void setReservasionList(Map<Integer, Reservasion> reservasionList) {
        this.reservasion = reservasionList;
    }

    public Map<Integer, Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(Map<Integer, Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public String getCustomerNumberPhone() {
        return customerNumberPhone;
    }

    public void setCustomerNumberPhone(String customerNumberPhone) {
        this.customerNumberPhone = customerNumberPhone;
    }

    public Map<Integer, Address> getAdressList() {
        return adressList;
    }

    public void setAdressList(Map<Integer, Address> adressList) {
        this.adressList = adressList;
    }

    public Map<Integer, Reservasion> getReservasion() {
        return reservasion;
    }

    public void setReservasion(Map<Integer, Reservasion> reservasion) {
        this.reservasion = reservasion;
    }

    public Map<Integer, CrediCard> getCrediCardList() {
        return crediCardList;
    }

    public void setCrediCardList(Map<Integer, CrediCard> crediCardList) {
        this.crediCardList = crediCardList;
    }
}
