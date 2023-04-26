package com.market.isteucuzagelsin.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Reservasion")
public class Reservasion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "reservasionStartDate")
    private String reservationStartDate;
    @Column(name = "reservasionLastDate")
    private String reservationLastDate;
    @Column(name = "reservationNumber")
    private int reservationNumber;
    @Column(name = "totalPaymnet")
    private Double totalPayment;
    @Column(name = "customerCount")
    private int customerCount;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customers;
    @Column(name = "status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;

    public Reservasion() {
    }

    public Reservasion(int id, String reservationStartDate, boolean status, String reservationLastDate, int reservationNumber, Double totalPayment, int customerCount, Customer customers, Hotel hotel) {
        this.id = id;
        this.reservationStartDate = reservationStartDate;
        this.reservationLastDate = reservationLastDate;
        this.reservationNumber = reservationNumber;
        this.totalPayment = totalPayment;
        this.customerCount = customerCount;
        this.customers = customers;
        this.hotel = hotel;
        this.status = status;

    }

    public Reservasion(int id, String reservationLastDate, String reservationStartDate, int reservationNumber, Double totalPayment, Hotel hotel, Customer customers) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReservationStartDate() {
        return reservationStartDate;
    }

    public void setReservationStartDate(String reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    public String getReservationLastDate() {
        return reservationLastDate;
    }

    public void setReservationLastDate(String reservationLastDate) {
        this.reservationLastDate = reservationLastDate;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;

    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
