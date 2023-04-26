package com.market.isteucuzagelsin.Service.ServiceBusinessLayer;

import com.market.isteucuzagelsin.Dto.Request.InvoiceRequest;
import com.market.isteucuzagelsin.Entity.Invoice;
import com.market.isteucuzagelsin.Entity.Paymnet;
import com.market.isteucuzagelsin.Entity.Reservasion;
import com.market.isteucuzagelsin.Mapper.ModelMapperService;
import com.market.isteucuzagelsin.Repository.InvoiceRepository;
import com.market.isteucuzagelsin.Repository.PaymentRepository;
import com.market.isteucuzagelsin.Repository.ReservasionRepository;
import com.market.isteucuzagelsin.Service.ServiceImpl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class InvoiceService implements InvoiceServiceImpl {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ModelMapperService modelMapperService;
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ReservasionRepository reservasionRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, ReservasionRepository reservasionRepository, ModelMapperService modelMapperService, PaymentRepository paymentRepository) {
        this.invoiceRepository = invoiceRepository;
        this.modelMapperService = modelMapperService;
        this.paymentRepository = paymentRepository;
        this.reservasionRepository = reservasionRepository;
    }

    public InvoiceService() {
    }

    @Override
    public String ınvioceCreate(InvoiceRequest invoiceRequest) {
        Reservasion reservasion = this.reservasionRepository.findByReservationNumber(invoiceRequest.getReservationNumber());
        Random random = new Random();
        Invoice invoice = new Invoice();
        invoice.setCustomer(reservasion.getCustomers());
        invoice.setInvoiceAmount(reservasion.getTotalPayment());
        invoice.setInvoiceNumber(random.nextInt(10000));
        this.invoiceRepository.save(invoice);
        return "success create invoice";
    }
}
