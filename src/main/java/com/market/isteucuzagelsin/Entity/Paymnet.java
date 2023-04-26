package com.market.isteucuzagelsin.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "paymnent")
public class Paymnet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "paymentDate")
    private String paymentDate;
    @Column(name = "paymentAmount")
    private double paymentAmount;
    @ManyToOne
    @JoinColumn(name = "crediCard_id")
    @JsonIgnore
    private CrediCard crediCard;
    @OneToOne(mappedBy = "paymnet")
    private Invoice invoice;
    @OneToOne
    @JoinColumn(name = "reservasion_id")
    private Reservasion reservasionList;

    public Paymnet(int id, String paymentDate, double paymentAmount, CrediCard crediCard, Invoice invoice, Reservasion reservasionList) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.crediCard = crediCard;
        this.invoice = invoice;
        this.reservasionList = reservasionList;

    }

    public Paymnet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public CrediCard getCrediCard() {
        return crediCard;
    }

    public void setCrediCard(CrediCard crediCard) {
        this.crediCard = crediCard;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Reservasion getReservasionList() {
        return reservasionList;
    }

    public void setReservasionList(Reservasion reservasionList) {
        this.reservasionList = reservasionList;
    }
}
