package com.market.isteucuzagelsin.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "customerName")
    private String customerFirstName;
    @Column(name = "customerLastName")
    private String customerLastName;
    @Column(name = "customerPhone")
    private String customerNumberPhone;
    @OneToMany(mappedBy = "customer")
    private List<Address> adressList;
    @OneToMany(mappedBy = "customers")
    private List<Reservasion> reservasion;
    @Column(name = "customerEmail")
    private String customerEmail;
    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoiceList;
    @OneToMany(mappedBy = "customer")
    private List<Account> accountList;
    @OneToMany(mappedBy = "customer")
    private List<CrediCard> crediCardList;

    public Customer() {
    }

    public Customer(int id, String customerFirstName, String customerLastName, String customerNumberPhone, List<Address> adressList, List<Reservasion> reservasion, String customerEmail, List<Invoice> invoiceList, List<Account> accountList, List<CrediCard> crediCardList) {
        this.id = id;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerNumberPhone = customerNumberPhone;
        this.adressList = adressList;
        this.reservasion = reservasion;
        this.customerEmail = customerEmail;
        this.invoiceList = invoiceList;
        this.accountList = accountList;
        this.crediCardList = crediCardList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Address> getAdressList() {
        return adressList;
    }

    public void setAdressList(List<Address> adressList) {
        this.adressList = adressList;
        for (Address adress : adressList) {
            adress.setCustomer(this);
        }
        this.adressList = adressList;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<Reservasion> getReservasion() {
        return reservasion;
    }

    public void setReservasion(List<Reservasion> reservasion) {
        this.reservasion = reservasion;
        for (Reservasion reservasionlist : reservasion) {
            reservasionlist.setCustomers(this);
        }
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
        for (Invoice invoice : invoiceList) {
            invoice.setCustomer(this);
        }
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
        for (Account account : accountList) {
            account.setCustomer(this);
        }
    }

    public List<CrediCard> getCrediCardList() {
        return crediCardList;
    }

    public void setCrediCardList(List<CrediCard> crediCardList) {
        this.crediCardList = crediCardList;
        for(CrediCard crediCard:crediCardList){
            crediCard.setCustomer(this);
        }
    }
}
