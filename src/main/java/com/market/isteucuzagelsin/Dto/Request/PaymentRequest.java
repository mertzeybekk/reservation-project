package com.market.isteucuzagelsin.Dto.Request;

public class PaymentRequest {
    private String paymentDate;

    private int reservasionNumber;
    private String crediCardNumber;

    public PaymentRequest(String paymentDate, int reservasionNumber, String crediCardNumber) {
        this.paymentDate = paymentDate;
        this.reservasionNumber = reservasionNumber;
        this.crediCardNumber = crediCardNumber;
    }
    public  PaymentRequest(){}

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getReservasionNumber() {
        return reservasionNumber;
    }

    public void setReservasionNumber(int reservasionNumber) {
        this.reservasionNumber = reservasionNumber;
    }

    public String getCrediCardNumber() {
        return crediCardNumber;
    }

    public void setCrediCardNumber(String crediCardNumber) {
        this.crediCardNumber = crediCardNumber;
    }
}
