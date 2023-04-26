package com.market.isteucuzagelsin.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "crediCard")
public class CrediCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "crediCardNumber")
    private String crediCardNumber;
    @Column(name = "validtyDate")
    private String validtyDate;
    @Column(name = "securityNumber")
    private String securityNumber;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
    @Column(name = "crediCardPassword")
    private int crediCardPassword;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public CrediCard(int id, String crediCardNumber, String validtyDate, String securityNumber, Customer customer, Account account,int crediCardPassword) {
        this.id = id;
        this.crediCardNumber = crediCardNumber;
        this.validtyDate = validtyDate;
        this.securityNumber = securityNumber;
        this.customer = customer;
        this.account = account;
        this.crediCardPassword=crediCardPassword;
    }
    public CrediCard(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getCrediCardPassword() {
        return crediCardPassword;
    }

    public void setCrediCardPassword(int crediCardPassword) {
        this.crediCardPassword = crediCardPassword;
    }
}
