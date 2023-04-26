package com.market.isteucuzagelsin.Dto.Response;

public class ReservationResponse {
    private int reservationNumber;
    private Double totelPrice;
    private String customerFirstName;
    private String customerLastName;
    private int customerCount;

    public ReservationResponse(int reservationNumber, Double totelPrice, String customerFirstName, String customerLastName, int customerCount) {
        this.reservationNumber = reservationNumber;
        this.totelPrice = totelPrice;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerCount = customerCount;
    }

    public ReservationResponse() {
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Double getTotelPrice() {
        return totelPrice;
    }

    public void setTotelPrice(Double totelPrice) {
        this.totelPrice = totelPrice;
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

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }
}
