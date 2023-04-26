package com.market.isteucuzagelsin.Service.ServiceImpl;

import com.market.isteucuzagelsin.Dto.Request.HotelRequest;
import com.market.isteucuzagelsin.Dto.Response.HotelResponse;

import java.util.List;

public interface HotelServiceImpl {
    public String createHotel(HotelRequest hotelRequest);
    public String deleteHotel(int hotelId);
    public String updateHotel(HotelRequest hotelRequest,int hotelId);
    public List<HotelResponse>hotelList();
    public List<HotelResponse>hotelListByName(String hotelName);
}
