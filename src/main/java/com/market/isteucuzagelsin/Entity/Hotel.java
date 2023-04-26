package com.market.isteucuzagelsin.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "hotelName")
    private String hotelName;
    @Column(name = "hotelAddress")
    private String hotelAddress;
    @Column(name = "hotelRoomNumber")
    private int hotelRoomNumber;
    @Column(name = "hotelPhone")
    private String hotelPhone;
    @OneToMany(mappedBy = "hotel")
    private List<Reservasion> reservasionList;
    @Column(name = "cityCenterDistance")
    private Double cityCenterDistance;
    @Column(name = "hotelPrice")
    private double hotelPrice;
    @Column(name = "roomOccupancy")
    private int roomOccupancy;

    public Hotel(int id,
                 String hotelName,
                 String hotelAddress,
                 int hotelRoomNumber,
                 String hotelPhone,
                 List<Reservasion> reservasionList,
                 Double cityCenterDistance,
                 double hotelPrice,
                 int roomOccupancy) {
        this.id = id;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelRoomNumber = hotelRoomNumber;
        this.hotelPhone = hotelPhone;
        this.reservasionList = reservasionList;
        this.cityCenterDistance = cityCenterDistance;
        this.hotelPrice = hotelPrice;
        this.roomOccupancy = roomOccupancy;
    }

    public Hotel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Reservasion> getReservasionList() {
        return reservasionList;
    }

    public void setReservasionList(List<Reservasion> reservasionList) {
        this.reservasionList = reservasionList;
        for (Reservasion reservasion : reservasionList) {
            reservasion.setHotel(this);
        }
    }

    public Double getCityCenterDistance() {
        return cityCenterDistance;
    }

    public void setCityCenterDistance(Double cityCenterDistance) {
        this.cityCenterDistance = cityCenterDistance;
    }

    public double getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(double hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public int getRoomOccupancy() {
        return roomOccupancy;
    }

    public void setRoomOccupancy(int roomOccupancy) {
        this.roomOccupancy = roomOccupancy;
    }
}
