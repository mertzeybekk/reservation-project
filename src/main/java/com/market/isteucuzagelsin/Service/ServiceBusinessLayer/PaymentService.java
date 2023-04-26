package com.market.isteucuzagelsin.Service.ServiceBusinessLayer;

import com.market.isteucuzagelsin.Dto.Request.PaymentRequest;
import com.market.isteucuzagelsin.Dto.Response.PaymentResponse;
import com.market.isteucuzagelsin.Entity.CrediCard;
import com.market.isteucuzagelsin.Entity.Hotel;
import com.market.isteucuzagelsin.Entity.Paymnet;
import com.market.isteucuzagelsin.Entity.Reservasion;
import com.market.isteucuzagelsin.Mapper.ModelMapperService;
import com.market.isteucuzagelsin.Repository.CrediCardRepository;
import com.market.isteucuzagelsin.Repository.PaymentRepository;
import com.market.isteucuzagelsin.Repository.ReservasionRepository;
import com.market.isteucuzagelsin.Service.ServiceImpl.PaymentServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService implements PaymentServiceImpl {
    private PaymentRepository paymentRepository;
    private ModelMapperService modelMapperService;
    private ReservasionRepository reservasionRepository;
    private CrediCardRepository crediCardRepository;

    public PaymentService(PaymentRepository paymentRepository, ModelMapperService modelMapperService, ReservasionRepository reservasionRepository, CrediCardRepository crediCardRepository) {
        this.paymentRepository = paymentRepository;
        this.modelMapperService = modelMapperService;
        this.reservasionRepository = reservasionRepository;
        this.crediCardRepository = crediCardRepository;
    }
    public PaymentService(){}

    @Override
    public String reservationPayment(PaymentRequest paymentRequest) {
        Optional<Reservasion> reservasion = Optional.ofNullable(this.reservasionRepository.findByReservationNumber(paymentRequest.getReservasionNumber()));
        List<CrediCard> crediCard = this.crediCardRepository.findByCrediCardNumber(paymentRequest.getCrediCardNumber());
        Paymnet payment = new Paymnet();
        for (CrediCard card : crediCard) {
            if (card.getAccount().getCashAmount() < reservasion.get().getTotalPayment()) {
                throw new RuntimeException("not enough balance");
            }
            card.getAccount().setCashAmount(card.getAccount().getCashAmount() - reservasion.get().getTotalPayment());
            this.crediCardRepository.save(card);

        }
        payment.setCrediCard(crediCard.get(0));
        payment.setReservasionList(reservasion.get());
        payment.setPaymentDate(paymentRequest.getPaymentDate());
        payment.setPaymentAmount(reservasion.get().getTotalPayment());

        this.paymentRepository.save(payment);
        return "success payment";
    }

    @Override
    @Transactional
    public String reservationPaymentDelete(int reservationNumber) {
        Optional<Reservasion> reservasion = Optional.ofNullable(this.reservasionRepository.findByReservationNumber(reservationNumber));
        reservasion.get().setStatus(false);
        Double lastcash = reservasion.get().getTotalPayment();
        Double newcash = reservasion.get().getCustomers().getAccountList().get(reservasion.get().getCustomers().getId() - 1).getCashAmount();
        CrediCard crediCard = reservasion.get().getCustomers().getCrediCardList().get(0);
        Double total = lastcash + newcash;
        crediCard.getAccount().setCashAmount(total);
        this.crediCardRepository.save(crediCard);
        this.reservasionRepository.save(reservasion.get());
        return "deleted";
    }

    @Override
    public List<PaymentResponse> getPaymentList() {
        List<Paymnet>paymnetList=this.paymentRepository.findAll();
        List<PaymentResponse>paymentResponses=paymnetList.stream().map(paymnet -> this.modelMapperService.forResponse().map(paymnet,PaymentResponse.class)).collect(Collectors.toList());
        return paymentResponses;
    }


    public int getReservationDurationInDays(String reservasionStartDate, String reservasionLastDate) {
        LocalDate startDate = LocalDate.parse(reservasionStartDate);
        LocalDate lastDate = LocalDate.parse(reservasionLastDate);
        long daysBetween = ChronoUnit.DAYS.between(startDate, lastDate);
        return (int) daysBetween;
    }

}
