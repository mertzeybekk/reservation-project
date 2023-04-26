package com.market.isteucuzagelsin.Service.ServiceImpl;

import com.market.isteucuzagelsin.Dto.Request.CustomerRequest;
import com.market.isteucuzagelsin.Dto.Response.CustomerResponse;

import java.util.List;

public interface CustomerServiceImpl {
    public String customerAdd(CustomerRequest customerRequest);
    public String customerDelete(int customerId);
    public String customerUpdate(CustomerRequest customerRequest,int customerId);
    public List<CustomerResponse> customerList();
    public CustomerResponse customergetById(int id);
    public List< CustomerResponse> customerNameAndLastName(String customerName,String customerLastName);
    public CustomerResponse customergetEmail(String email);
    public CustomerResponse customergetPhoneNumber(String phoneNumber);

}