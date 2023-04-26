package com.market.isteucuzagelsin.Controller;

import com.market.isteucuzagelsin.Dto.Request.HotelRequest;
import com.market.isteucuzagelsin.Dto.Response.HotelResponse;
import com.market.isteucuzagelsin.Service.ServiceBusinessLayer.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/createdHotel")
    public String createdHotel(@RequestBody HotelRequest hotelRequest) {
        return this.hotelService.createHotel(hotelRequest);
    }
    @PostMapping("/deleteHotel/{hotelId}")
    public String deleteHotel(@PathVariable int hotelId){
        return this.hotelService.deleteHotel(hotelId);
    }
    @PostMapping("/updateHotel/{hotelId}")
    public String updateHotel(@RequestBody HotelRequest hotelRequest,@PathVariable int hotelId){
        return this.hotelService.updateHotel(hotelRequest,hotelId);
    }
    @GetMapping("/getAllHotelList")
    public List<HotelResponse>hotelList(){
        return this.hotelService.hotelList();
    }
    @GetMapping("/getByNameHotelList/{hotelName}")
    public List<HotelResponse>hotelByNameList(@PathVariable String hotelName){
        return this.hotelService.hotelListByName(hotelName);
    }
}
