package com.market.isteucuzagelsin.Controller;

import com.market.isteucuzagelsin.Dto.Request.CustomerRequest;
import com.market.isteucuzagelsin.Dto.Response.CustomerResponse;
import com.market.isteucuzagelsin.Service.ServiceBusinessLayer.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }
    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody CustomerRequest customerRequest){
        return this.customerService.customerAdd(customerRequest);
    }
    @PostMapping("/deleteCustomer/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        return this.customerService.customerDelete(customerId);
    }
    @PostMapping("/updateCustomer/{customerId}")
    public String updateCustomer(@RequestBody CustomerRequest customerRequest,@PathVariable int customerId){
        return this.customerService.customerUpdate(customerRequest,customerId);
    }
    @GetMapping("/getAllCustomer")
    public List<CustomerResponse>customerResponseList(){
        return this.customerService.customerList();
    }
    @GetMapping("/getNameAndLastNameCustomer/{firstName}/{lastName}")
    public List<CustomerResponse>customerResponseListNameAndLastName(@PathVariable String firstName,@PathVariable String lastName){
        return (this.customerService.customerNameAndLastName(firstName, lastName));
    }
    @GetMapping("/getByIdCustomer/{customerId}")
    public CustomerResponse getByIdCustomer(@PathVariable int customerId){
        return this.customerService.customergetById(customerId);
    }
    @GetMapping("/getEmailCustomer/{customerEmail}")
    public CustomerResponse getEmailCustomer(@PathVariable String customerEmail){
        return this.customerService.customergetEmail(customerEmail);
    }
    @GetMapping("/getPhoneNumberCustomer/{phoneNumber}")
    public CustomerResponse getCustomerPhoneNumber(@PathVariable String  phoneNumber){
        return this.customerService.customergetPhoneNumber(phoneNumber);
    }

}
