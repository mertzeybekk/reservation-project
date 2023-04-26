package com.market.isteucuzagelsin.Dto.Request;

public class CustomerRequest {
    private String customerFirstName;
    private String customerLastName;
    private String customerNumberPhone;

    private String customerEmail;


    public CustomerRequest(String customerFirstName, String customerLastName, String customerNumberPhone, String customerEmail) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerNumberPhone = customerNumberPhone;

        this.customerEmail = customerEmail;

    }

    public CustomerRequest() {
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerNumberPhone() {
        return customerNumberPhone;
    }

    public void setCustomerNumberPhone(String customerNumberPhone) {
        this.customerNumberPhone = customerNumberPhone;
    }


    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


}
