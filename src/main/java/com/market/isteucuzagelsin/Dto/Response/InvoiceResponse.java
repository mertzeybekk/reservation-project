package com.market.isteucuzagelsin.Dto.Response;

public class InvoiceResponse {
    private int invoiceNumber;
    private double invoiceAmount;
    private String customerFirstName;
    private String customerLastName;
    private String message;

    public InvoiceResponse(int invoiceNumber, double invoiceAmount, String customerName, String customerLastName, String message) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceAmount = invoiceAmount;
        this.customerFirstName = customerName;
        this.customerLastName = customerLastName;
        this.message = message;
    }
    public InvoiceResponse(){}

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getCustomerName() {
        return customerFirstName;
    }

    public void setCustomerName(String customerName) {
        this.customerFirstName = customerName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
