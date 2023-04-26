package com.market.isteucuzagelsin.Dto.Request;

public class HotelRequest {
    private String hotelName;
    private String hotelAddress;
    private int hotelRoomNumber;
    private String hotelPhone;
    private Double cityCenterDistance;
    private Double hotelPrice;


    public HotelRequest(String hotelName,
                        String hotelAddress,
                        int hotelRoomNumber,
                        String hotelPhone,
                        Double cityCenterDistance,
                        Double hotelPrice
                       ) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelRoomNumber = hotelRoomNumber;
        this.hotelPhone = hotelPhone;
        this.cityCenterDistance=cityCenterDistance;
        this.hotelPrice=hotelPrice;
    }
  public HotelRequest(){}
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public int getHotelRoomNumber() {
        return hotelRoomNumber;
    }

    public void setHotelRoomNumber(int hotelRoomNumber) {
        this.hotelRoomNumber = hotelRoomNumber;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public Double getCityCenterDistance() {
        return cityCenterDistance;
    }

    public void setCityCenterDistance(Double cityCenterDistance) {
        this.cityCenterDistance = cityCenterDistance;
    }

    public Double getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(Double hotelPrice) {
        this.hotelPrice = hotelPrice;
    }
}
