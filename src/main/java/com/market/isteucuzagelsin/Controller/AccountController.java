package com.market.isteucuzagelsin.Controller;

import com.market.isteucuzagelsin.Dto.Request.AccountRequest;
import com.market.isteucuzagelsin.Dto.Response.AccountResponse;
import com.market.isteucuzagelsin.Service.ServiceBusinessLayer.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accountCreate")
    public String accountCreate(@RequestBody AccountRequest accountRequest) {
        return this.accountService.accountCreate(accountRequest);
    }

    @GetMapping("/accountDelete/{accountNumber}")
    public String accountDelete(@PathVariable String accountNumber) {
        return this.accountService.accountDelete(accountNumber);
    }

    @PostMapping("/accountUpdate/{cash}/{accountNumber}/{movement}")
    public String accountUpdate(@PathVariable Double cash, @PathVariable String accountNumber, @PathVariable String movement) {
        return this.accountService.accountUpdated(cash, accountNumber, movement);
    }

    @GetMapping("/accountAll")
    public List<AccountResponse> accountAll() {
        return this.accountService.accountList();
    }

    @GetMapping("/accountGetAccountNumber/{accountNumber}")
    public List<AccountResponse> accountGetAccountNumber(@PathVariable String accountNumber) {
        return this.accountService.customergetByAccountNumber(accountNumber);
    }
}
