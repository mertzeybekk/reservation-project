package com.market.isteucuzagelsin.Service.ServiceImpl;

import com.market.isteucuzagelsin.Dto.Request.ReservasionRequest;
import com.market.isteucuzagelsin.Dto.Response.ReservationResponse;

import java.util.List;

public interface ReservasionServiceImpl {
    public String reservasionCreate(ReservasionRequest reservasionRequest);
    public String reservasionDelete(int reservationNumber);
    public String reservasionUpdate(String reservasionFirstDate,String reservasionLastDate,int reservationNumber,int customerCount,String type);
    public List<ReservationResponse>reservasionList();
    public ReservationResponse reservasionNumberList(int reservationNumber);
}
