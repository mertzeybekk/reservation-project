package com.market.isteucuzagelsin.Dto.Response;

public class PaymentResponse {
    private String paymentDate;
    private double paymentAmount;
    private int reservationId;

    public PaymentResponse(String paymentDate, double paymentAmount,int reservationId) {
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.reservationId=reservationId;
    }

    public PaymentResponse() {
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

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
}
