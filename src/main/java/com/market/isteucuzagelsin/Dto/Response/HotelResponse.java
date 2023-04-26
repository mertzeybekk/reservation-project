package com.market.isteucuzagelsin.Dto.Response;

import com.market.isteucuzagelsin.Entity.Reservasion;

import java.util.Map;

public class HotelResponse {
    private Map<Integer, Reservasion> reservasionList;
    private String hotelName;
    private int hotelRoomNumber;
    private String hotelAddress;
    private double cityCenterDistance;

    public HotelResponse(Map<Integer, Reservasion> reservasionList, String hotelName, int hotelRoomNumber, String hotelAddress, double cityCenterDistance) {
        this.reservasionList = reservasionList;
        this.hotelName = hotelName;
        this.hotelRoomNumber = hotelRoomNumber;
        this.hotelAddress = hotelAddress;
        this.cityCenterDistance = cityCenterDistance;
    }

    public Map<Integer, Reservasion> getReservasionList() {
        return reservasionList;
    }

    public void setReservasionList(Map<Integer, Reservasion> reservasionList) {
        this.reservasionList = reservasionList;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelRoomNumber() {
        return hotelRoomNumber;
    }

    public void setHotelRoomNumber(int hotelRoomNumber) {
        this.hotelRoomNumber = hotelRoomNumber;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public double getCityCenterDistance() {
        return cityCenterDistance;
    }

    public void setCityCenterDistance(double cityCenterDistance) {
        this.cityCenterDistance = cityCenterDistance;
    }
}
