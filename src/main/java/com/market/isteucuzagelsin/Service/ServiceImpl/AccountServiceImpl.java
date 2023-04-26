package com.market.isteucuzagelsin.Service.ServiceImpl;

import com.market.isteucuzagelsin.Dto.Request.AccountRequest;
import com.market.isteucuzagelsin.Dto.Response.AccountResponse;

import java.util.List;

public interface AccountServiceImpl {
    public String accountCreate(AccountRequest accountRequest);
    public String accountDelete(String accountNumber);
    public String accountUpdated(Double cash,String accountNumber,String movement);
    public List<AccountResponse>accountList();
    public List<AccountResponse>customergetByAccountNumber(String accountNumber);

}
