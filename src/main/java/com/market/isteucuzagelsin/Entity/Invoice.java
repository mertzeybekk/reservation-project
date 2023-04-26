package com.market.isteucuzagelsin.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice")

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "invoiceNumber")
    private int invoiceNumber;
    @Column(name = "invoiceAmount")
    private double invoiceAmount;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "payment_id")
    private Paymnet paymnet;

    public Invoice(int id, int invoiceNumber, double invoiceAmount, Customer customer,Paymnet paymnet) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.invoiceAmount = invoiceAmount;
        this.customer = customer;
        this.paymnet=paymnet;
    }
    public Invoice(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Paymnet getPaymnet() {
        return paymnet;
    }

    public void setPaymnet(Paymnet paymnet) {
        this.paymnet = paymnet;
    }
}
