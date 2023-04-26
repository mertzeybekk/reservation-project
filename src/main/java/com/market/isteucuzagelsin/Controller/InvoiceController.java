package com.market.isteucuzagelsin.Controller;

import com.market.isteucuzagelsin.Dto.Request.InvoiceRequest;
import com.market.isteucuzagelsin.Service.ServiceBusinessLayer.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ınvoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    public InvoiceController(){}
    @PostMapping("/createInvoice")
    public String createInvoice(@RequestBody InvoiceRequest invoiceRequest){
        return this.invoiceService.ınvioceCreate(invoiceRequest);
    }
}
