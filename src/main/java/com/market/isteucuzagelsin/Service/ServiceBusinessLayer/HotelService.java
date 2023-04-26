package com.market.isteucuzagelsin.Service.ServiceBusinessLayer;

import com.market.isteucuzagelsin.Dto.Request.HotelRequest;
import com.market.isteucuzagelsin.Dto.Response.CrediCardResponse;
import com.market.isteucuzagelsin.Dto.Response.HotelResponse;
import com.market.isteucuzagelsin.Entity.Hotel;
import com.market.isteucuzagelsin.Mapper.ModelMapperService;
import com.market.isteucuzagelsin.Repository.HotelRepository;
import com.market.isteucuzagelsin.Service.ServiceImpl.HotelServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelService implements HotelServiceImpl {
    private HotelRepository hotelRepository;
    private ModelMapperService modelMapperService;

    public HotelService(HotelRepository hotelRepository, ModelMapperService modelMapperService) {
        this.hotelRepository = hotelRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public String createHotel(HotelRequest hotelRequest) {
        Hotel hotel = new Hotel();
        hotel.setHotelAddress(hotelRequest.getHotelAddress());
        hotel.setHotelPhone(hotelRequest.getHotelPhone());
        hotel.setHotelPrice(hotelRequest.getHotelPrice());
        hotel.setCityCenterDistance(hotelRequest.getCityCenterDistance());
        hotel.setHotelName(hotelRequest.getHotelName());
        hotel.setHotelRoomNumber(hotelRequest.getHotelRoomNumber());
        this.hotelRepository.save(hotel);
        return "hotel created";
    }

    @Override
    public String deleteHotel(int hotelId) {
        Optional<Hotel> hotel = this.hotelRepository.findById(hotelId);
        if (hotel.isPresent()) {
            this.hotelRepository.deleteById(hotelId);
        }
        return "deleted hotel";
    }

    @Override
    public String updateHotel(HotelRequest hotelRequest, int hotelId) {
        Optional<Hotel> hotel = this.hotelRepository.findById(hotelId);
        if (hotel.isPresent()) {
            hotel.get().setHotelPrice(hotelRequest.getHotelPrice());
            this.hotelRepository.save(hotel.get());
        }
        return "hotel price updated";
    }

    @Override
    public List<HotelResponse> hotelList() {
        List<Hotel> hotelList = this.hotelRepository.findAll();
        List<HotelResponse> hotelResponses = hotelList.stream().
                map(hotel -> this.modelMapperService.forResponse().map(hotel, HotelResponse.class))
                .collect(Collectors.toList());
        return hotelResponses;
    }

    @Override
    public List<HotelResponse> hotelListByName(String hotelName) {
        List<Hotel> hotelList = this.hotelRepository.findByHotelName(hotelName);
        List<HotelResponse> hotelResponses = hotelList.stream().map(hotel -> this.modelMapperService.forResponse().map(hotel, HotelResponse.class))
                .collect(Collectors.toList());
        return hotelResponses;
    }
}
