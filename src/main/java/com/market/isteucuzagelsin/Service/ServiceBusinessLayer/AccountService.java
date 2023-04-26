package com.market.isteucuzagelsin.Service.ServiceBusinessLayer;

import com.market.isteucuzagelsin.Dto.Request.AccountRequest;
import com.market.isteucuzagelsin.Dto.Response.AccountResponse;
import com.market.isteucuzagelsin.Entity.Account;
import com.market.isteucuzagelsin.Entity.Customer;
import com.market.isteucuzagelsin.Mapper.ModelMapperService;
import com.market.isteucuzagelsin.Repository.AccountRepository;
import com.market.isteucuzagelsin.Repository.CustomerRepository;
import com.market.isteucuzagelsin.Service.ServiceImpl.AccountServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService implements AccountServiceImpl {
    private AccountRepository accountRepository;

    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    public AccountService(AccountRepository accountRepository, ModelMapperService modelMapperService, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.modelMapperService = modelMapperService;
        this.customerRepository = customerRepository;
    }

    @Override
    public String accountCreate(AccountRequest accountRequest) {
        Optional<Customer> customerById = this.customerRepository.findById(accountRequest.getCustomerId());
        if (accountRequest.getAccountNumber().length() < 16) {
            throw new RuntimeException("account number must be at least 16 characters");
        }
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String createdDate = formatter.format(today);
        Account account = new Account();
        account.setAccountNumber(accountRequest.getAccountNumber());
        account.setCreatedDate(createdDate);
        account.setCashAmount(accountRequest.getCash());
        account.setCustomer(customerById.get());
        this.accountRepository.save(account);

        return "account created !";
    }

    @Override
    public String accountDelete(String accountNumber) {
        Optional<Account> getAccountNumber = Optional.ofNullable(this.accountRepository.findByAccountNumber(accountNumber));
        if (getAccountNumber.isPresent()) {
            this.accountRepository.deleteByAccountNumber(accountNumber);
        }
        return "account deleted !";
    }

    @Override
    public String accountUpdated(Double cash, String accountNumber, String movement) {
        Optional<Account> account = Optional.ofNullable(this.accountRepository.findByAccountNumber(accountNumber));
        Double amount = account.get().getCashAmount();
        if (movement.equals("pull")) {
            if (account.get().getCashAmount() < cash) {
                throw new RuntimeException("there is not enough balance in your account");
            }
            amount -= cash;
            account.get().setCashAmount(amount);
            accountRepository.save(account.get());
        } else {
            amount += cash;
            account.get().setCashAmount(amount);
            accountRepository.save(account.get());
        }

        return "balance in your account" + account.get().getCashAmount();
    }

    @Override
    public List<AccountResponse> accountList() {
        List<Account> accountList = this.accountRepository.findAll();
        List<AccountResponse> accountResponses = accountList.stream().
                map(product -> this.modelMapperService.forResponse().map(product, AccountResponse.class))
                .collect(Collectors.toList());
        return accountResponses;
    }

    @Override
    public List<AccountResponse> customergetByAccountNumber(String accountNumber) {
        List<Account> accountList = Collections.singletonList(this.accountRepository.findByAccountNumber(accountNumber));
        List<AccountResponse> accountResponses = accountList.stream().
                map(product -> this.modelMapperService.forResponse().map(product, AccountResponse.class))
                .collect(Collectors.toList());
        return accountResponses;
    }
}
