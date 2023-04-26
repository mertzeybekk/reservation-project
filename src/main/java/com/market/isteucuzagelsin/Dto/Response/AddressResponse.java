package com.market.isteucuzagelsin.Dto.Response;

public class AddressResponse {
    private String city;
    private String district;
    private String postalCode;
    private String customerFirstName;
    private String customerLastName;

    public AddressResponse(String city, String district, String postalCode, String customerName, String customerLastName) {
        this.city = city;
        this.district = district;
        this.postalCode = postalCode;
        this.customerFirstName = customerName;
        this.customerLastName = customerLastName;
    }

    public AddressResponse() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
}
