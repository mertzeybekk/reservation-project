package com.market.isteucuzagelsin.Service.ServiceBusinessLayer;

import com.market.isteucuzagelsin.Dto.Request.CustomerRequest;
import com.market.isteucuzagelsin.Dto.Response.CustomerResponse;
import com.market.isteucuzagelsin.Entity.*;
import com.market.isteucuzagelsin.Mapper.ModelMapperService;
import com.market.isteucuzagelsin.Repository.CustomerRepository;
import com.market.isteucuzagelsin.Service.ServiceImpl.CustomerServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService implements CustomerServiceImpl {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    public CustomerService(CustomerRepository customerRepository, ModelMapperService modelMapperService) {
        this.customerRepository = customerRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public String customerAdd(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        if (customerRequest == null) {
            throw new RuntimeException("Customer user not blank");
        }
        if (!customerRequest.getCustomerEmail().contains("@")) {
            throw new RuntimeException("e-mail is invalid");

        }
        if (customerRequest.getCustomerNumberPhone().length() < 11) {
            throw new RuntimeException("phone number length cannot be less than 11 characters");
        }
        customer.setCustomerEmail(customerRequest.getCustomerEmail());
        customer.setCustomerNumberPhone(customerRequest.getCustomerNumberPhone());
        customer.setCustomerFirstName(customerRequest.getCustomerFirstName());
        customer.setCustomerLastName(customerRequest.getCustomerLastName());
        this.customerRepository.save(customer);
        return "Customer registration successful!";
    }

    @Override
    public String customerDelete(int customerId) {
        Optional<Customer> customerData = this.customerRepository.findById(customerId);
        if (customerData.isPresent()) {
            this.customerRepository.deleteById(customerId);

        }
        return "Customer deleted successful!";
    }

    @Override
    public String customerUpdate(CustomerRequest customerRequest, int customerId) {
        Optional<Customer> customer = this.customerRepository.findById(customerId);
        if (customer.isPresent()) {
            customer.get().setCustomerNumberPhone(customerRequest.getCustomerNumberPhone());
            customer.get().setCustomerEmail(customerRequest.getCustomerEmail());
            this.customerRepository.save(customer.get());
        }
        return "Customer updated successful!";
    }

    @Override
    public List<CustomerResponse> customerList() {
        // Tüm müşterileri veritabanından çek
        List<Customer> customerList = this.customerRepository.findAll();

        // Dönüş değeri olarak kullanılacak müşteri listesini oluştur
        List<CustomerResponse> customerResponses = new ArrayList<>();

        // Müşterilerin adres, hesap, fatura ve rezervasyon bilgilerini tutacak map'leri oluştur
        Map<Integer, Address> addressMap;
        Map<Integer, Account> accountMap;
        Map<Integer, Invoice> invoiceMap;
        Map<Integer, Reservasion> reservasionMap;
        Map<Integer, CrediCard> crediCardMap;

        // Her müşteri için aşağıdaki işlemleri yap
        for (Customer customer : customerList) {
            // Yeni bir müşteri yanıtı oluştur
            CustomerResponse customerResponse = new CustomerResponse();

            // Müşteri bilgilerini ayarla
            customerResponse.setCustomerEmail(customer.getCustomerEmail());
            customerResponse.setCustomerPhoneNumber(customer.getCustomerNumberPhone());
            customerResponse.setCustomerFirstName(customer.getCustomerFirstName());
            customerResponse.setCustomerLastName(customer.getCustomerLastName());

            // Müşterinin hesaplarını map'e ekle
            accountMap = new HashMap<>();
            if (customer.getAccountList() != null) {
                for (Account account : customer.getAccountList()) {
                    accountMap.put(account.getId(), account);
                }
            }

            customerResponse.setAccountList(accountMap);

            // Müşterinin faturalarını map'e ekle
            invoiceMap = new HashMap<>();
            if (customer.getInvoiceList() != null) {
                for (Invoice invoice : customer.getInvoiceList()) {
                    invoiceMap.put(invoice.getId(), invoice);
                }
            }

            customerResponse.setInvoiceList(invoiceMap);

            // Müşterinin adreslerini map'e ekle
            addressMap = new HashMap<>();
            if (customer.getAdressList() != null) {
                for (Address address : customer.getAdressList()) {
                    addressMap.put(address.getId(), address);
                }
            }

            customerResponse.setAddressList(addressMap);

            // Müşterinin rezervasyonlarını map'e ekle
            reservasionMap = new HashMap<>();
            if (customer.getReservasion() != null) {
                for (Reservasion reservasion : customer.getReservasion()) {
                    reservasionMap.put(reservasion.getId(), reservasion);
                }
            }

            customerResponse.setReservasionList(reservasionMap);
            crediCardMap = new HashMap<>();
            if (customer.getCrediCardList() != null) {
                for (CrediCard crediCard : customer.getCrediCardList()) {
                    crediCardMap.put(crediCard.getId(), crediCard);
                }
            }

            customerResponse.setCrediCardList(crediCardMap);

            // Müşteri yanıtını dönüş değeri listesine ekle
            customerResponses.add(customerResponse);
        }


        return customerResponses;
    }

    @Override
    public CustomerResponse customergetById(int id) {
        Optional<Customer> customer = this.customerRepository.findById(id);
        CustomerResponse customerResponse = this.modelMapperService.forResponse().map(customer, CustomerResponse.class);
        return customerResponse;
    }

    @Override
    public List<CustomerResponse> customerNameAndLastName(String customerName, String customerlastName) {
        List<Customer> customerNameAndLastName = this.customerRepository.findByCustomerFirstNameAndCustomerLastName(customerName, customerlastName);
        // Dönüş değeri olarak kullanılacak müşteri listesini oluştur
        List<CustomerResponse> customerResponses = new ArrayList<>();

        // Müşterilerin adres, hesap, fatura ve rezervasyon bilgilerini tutacak map'leri oluştur
        Map<Integer, Address> addressMap;
        Map<Integer, Account> accountMap;
        Map<Integer, Invoice> invoiceMap;
        Map<Integer, Reservasion> reservasionMap;

        // Her müşteri için aşağıdaki işlemleri yap
        for (Customer customer : customerNameAndLastName) {
            // Yeni bir müşteri yanıtı oluştur
            CustomerResponse customerResponse = new CustomerResponse();

            // Müşteri bilgilerini ayarla
            customerResponse.setCustomerEmail(customer.getCustomerEmail());
            customerResponse.setCustomerPhoneNumber(customer.getCustomerNumberPhone());
            customerResponse.setCustomerFirstName(customer.getCustomerFirstName());
            customerResponse.setCustomerLastName(customer.getCustomerLastName());

            // Müşterinin hesaplarını map'e ekle
            accountMap = new HashMap<>();
            if (customer.getAccountList() != null) {
                for (Account account : customer.getAccountList()) {
                    accountMap.put(account.getId(), account);
                }
            }

            customerResponse.setAccountList(accountMap);

            // Müşterinin faturalarını map'e ekle
            invoiceMap = new HashMap<>();
            if (customer.getInvoiceList() != null) {
                for (Invoice invoice : customer.getInvoiceList()) {
                    invoiceMap.put(invoice.getId(), invoice);
                }
            }

            customerResponse.setInvoiceList(invoiceMap);

            // Müşterinin adreslerini map'e ekle
            addressMap = new HashMap<>();
            if (customer.getAdressList() != null) {
                for (Address address : customer.getAdressList()) {
                    addressMap.put(address.getId(), address);
                }
            }

            customerResponse.setAddressList(addressMap);

            // Müşterinin rezervasyonlarını map'e ekle
            reservasionMap = new HashMap<>();
            if (customer.getReservasion() != null) {
                for (Reservasion reservasion : customer.getReservasion()) {
                    reservasionMap.put(reservasion.getId(), reservasion);
                }
            }

            customerResponse.setReservasionList(reservasionMap);

            // Müşteri yanıtını dönüş değeri listesine ekle
            customerResponses.add(customerResponse);
        }
        return customerResponses;
    }

    @Override
    public CustomerResponse customergetEmail(String email) {
        if (!email.contains("@") && (!email.contains(".com") || !email.contains(".outlook"))) {
            throw new RuntimeException("e-mail is invalid");
        }
        Customer customer = this.customerRepository.findByCustomerEmail(email);
        CustomerResponse customerResponse = this.modelMapperService.forResponse().map(customer, CustomerResponse.class);
        return customerResponse;
    }

    @Override
    public CustomerResponse customergetPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() < 11) {
            throw new RuntimeException("phone number length cannot be less than 11 characters");
        }
        if (!phoneNumber.matches("[0-9]+")) {
            throw new RuntimeException("The phone number must consist of numbers only.");
        }
        Customer customer = this.customerRepository.findByCustomerNumberPhone(phoneNumber);
        CustomerResponse customerResponse = this.modelMapperService.forResponse().map(customer, CustomerResponse.class);
        return customerResponse;
    }
}
