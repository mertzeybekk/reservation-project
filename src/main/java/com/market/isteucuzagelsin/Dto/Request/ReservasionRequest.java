package com.market.isteucuzagelsin.Dto.Request;

public class ReservasionRequest {
    private String reservationStartDate;
    private String reservationLastDate;
    private int customerCount;
    private int customerId;
    private int hotelId;

    public ReservasionRequest(String reservationStartDate, String reservationLastDate, int customerCount, int customerId, int hotelId) {
        this.reservationStartDate = reservationStartDate;
        this.reservationLastDate = reservationLastDate;
        this.customerCount = customerCount;
        this.customerId = customerId;
        this.hotelId = hotelId;
    }
    public ReservasionRequest(){}

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


    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
