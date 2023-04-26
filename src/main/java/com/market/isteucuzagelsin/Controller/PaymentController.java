package com.market.isteucuzagelsin.Controller;

import com.market.isteucuzagelsin.Dto.Request.PaymentRequest;
import com.market.isteucuzagelsin.Dto.Response.PaymentResponse;
import com.market.isteucuzagelsin.Service.ServiceBusinessLayer.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public PaymentController(){}
    @PostMapping("/reservationPayment")
    public String reservationPayment(@RequestBody PaymentRequest paymentRequest){
        return this.paymentService.reservationPayment(paymentRequest);
    }
    @PostMapping("/reservationPayment/Delete/{reservationNumber}")
    public String deleteReservation(@PathVariable int reservationNumber){
        return this.paymentService.reservationPaymentDelete(reservationNumber);
    }
    @GetMapping("/getAllPayment")
    public List<PaymentResponse>paymentResponseList(){
        return this.paymentService.getPaymentList();
    }

}
