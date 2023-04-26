package com.market.isteucuzagelsin.Service.ServiceImpl;

import com.market.isteucuzagelsin.Dto.Request.PaymentRequest;
import com.market.isteucuzagelsin.Dto.Response.PaymentResponse;

import java.util.List;

public interface PaymentServiceImpl {
    public String reservationPayment(PaymentRequest paymentRequest);
    public String reservationPaymentDelete(int reservationNumber);
    public List<PaymentResponse>getPaymentList();
}
