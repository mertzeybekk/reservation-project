package com.market.isteucuzagelsin.Controller;

import com.market.isteucuzagelsin.Dto.Request.CrediCardRequest;
import com.market.isteucuzagelsin.Dto.Response.AccountResponse;
import com.market.isteucuzagelsin.Dto.Response.CrediCardResponse;
import com.market.isteucuzagelsin.Service.ServiceBusinessLayer.CrediCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crediCard")
public class CrediCardController {
    private CrediCardService crediCardService;

    public CrediCardController(CrediCardService crediCardService) {
        this.crediCardService = crediCardService;
    }

    @PostMapping("/createCrediCard")
    public String createCrediCard(@RequestBody CrediCardRequest crediCardRequest) {
        return this.crediCardService.crediCardCreate(crediCardRequest);
    }

    @GetMapping("/getCrediCardNumber/{crediCardNumber}")
    public List<CrediCardResponse> getCrediCardResponse(@PathVariable String crediCardNumber) {
        return this.crediCardService.crediCardByCardNumber(crediCardNumber);
    }
}
