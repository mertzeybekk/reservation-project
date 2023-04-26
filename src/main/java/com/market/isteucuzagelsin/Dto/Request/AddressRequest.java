package com.market.isteucuzagelsin.Dto.Request;

import com.market.isteucuzagelsin.Entity.Address;

public class AddressRequest {
    private String city;
    private String district;
    private String postalCode;
    private int customerId;

    public AddressRequest(String city, String district, String postalCode, int customerId) {
        this.city = city;
        this.district = district;
        this.postalCode = postalCode;
        this.customerId = customerId;
    }

    public AddressRequest() {
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
