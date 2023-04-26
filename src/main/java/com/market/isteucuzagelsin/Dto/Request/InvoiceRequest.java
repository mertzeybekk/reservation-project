package com.market.isteucuzagelsin.Dto.Request;

public class InvoiceRequest {
    private int reservationNumber;

    public InvoiceRequest(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
    public InvoiceRequest(){}

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
}
