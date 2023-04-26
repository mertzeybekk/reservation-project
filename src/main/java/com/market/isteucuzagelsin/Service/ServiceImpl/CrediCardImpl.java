package com.market.isteucuzagelsin.Service.ServiceImpl;

import com.market.isteucuzagelsin.Dto.Request.CrediCardRequest;
import com.market.isteucuzagelsin.Dto.Response.CrediCardResponse;

import java.util.List;

public interface CrediCardImpl {
    public String crediCardCreate(CrediCardRequest crediCardRequest);
    public String crediCardDelete(String crediCardNumber);
    public String crediCardUpdate(String crediCardNumber,int crediCardPassword);
    public List<CrediCardResponse>crediCardAllList();
    public List<CrediCardResponse>crediCardByCardNumber(String crediCardNumber);
}
