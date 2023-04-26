package com.market.isteucuzagelsin.Service.ServiceBusinessLayer;

import com.market.isteucuzagelsin.Dto.Request.ReservasionRequest;
import com.market.isteucuzagelsin.Dto.Response.ReservationResponse;
import com.market.isteucuzagelsin.Entity.Customer;
import com.market.isteucuzagelsin.Entity.Hotel;
import com.market.isteucuzagelsin.Entity.Reservasion;
import com.market.isteucuzagelsin.Mapper.ModelMapperService;
import com.market.isteucuzagelsin.Repository.CustomerRepository;
import com.market.isteucuzagelsin.Repository.HotelRepository;
import com.market.isteucuzagelsin.Repository.ReservasionRepository;
import com.market.isteucuzagelsin.Service.ServiceImpl.ReservasionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ReservasionService implements ReservasionServiceImpl {
    @Autowired
    private ReservasionRepository reservasionRepository;
    @Autowired
    private ModelMapperService modelMapperService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private HotelRepository hotelRepository;

    public ReservasionService(ReservasionRepository reservasionRepository, ModelMapperService modelMapperService, CustomerRepository customerRepository, HotelRepository hotelRepository) {
        this.reservasionRepository = reservasionRepository;
        this.modelMapperService = modelMapperService;
        this.customerRepository = customerRepository;
        this.hotelRepository = hotelRepository;
    }

    public ReservasionService() {
    }

    @Override
    public String reservasionCreate(ReservasionRequest reservasionRequest) {
        Optional<Customer> customer = this.customerRepository.findById(reservasionRequest.getCustomerId());
        Optional<Hotel> hotel = this.hotelRepository.findById(reservasionRequest.getHotelId());
        int diffirenceDay = getReservationDurationInDays(reservasionRequest.getReservationStartDate(), reservasionRequest.getReservationLastDate());
        Double totalPayment = hotel.get().getHotelPrice() * reservasionRequest.getCustomerCount() * diffirenceDay;
        Random random = new Random();
        Reservasion reservasion = new Reservasion();
        reservasion.setReservationLastDate(reservasionRequest.getReservationLastDate());
        reservasion.setReservationStartDate(reservasionRequest.getReservationStartDate());
        reservasion.setCustomers(customer.get());
        reservasion.setHotel(hotel.get());
        reservasion.setCustomerCount(reservasionRequest.getCustomerCount());
        reservasion.setReservationNumber(random.nextInt(100000));
        reservasion.setTotalPayment(totalPayment);
        reservasion.setStatus(true);
        hotel.get().setRoomOccupancy(hotel.get().getRoomOccupancy() - reservasionRequest.getCustomerCount());
        this.hotelRepository.save(hotel.get());
        this.reservasionRepository.save(reservasion);


        return "success reservasion";
    }

    @Override
    public String reservasionDelete(int reservationNumber) {
        this.reservasionRepository.deleteByReservationNumber(reservationNumber);
        return "success reservasion delete";
    }

    @Override
    public String reservasionUpdate(String reservasionFirstDate, String reservasionLastDate, int reservationNumber, int customerCount, String type) {
        Optional<Reservasion> reservasion = Optional.ofNullable(this.reservasionRepository.findByReservationNumber(reservationNumber));
        Hotel hotel = reservasion.get().getHotel();
        if (type.equals("H")) {
            if (reservasion.get().getCustomerCount() == customerCount) {
                int diffirenceDay = getReservationDurationInDays(reservasionFirstDate, reservasionLastDate);
                Double totalPayment = hotel.getHotelPrice() * reservasion.get().getCustomerCount() * diffirenceDay;
                reservasion.get().setTotalPayment(totalPayment);
                this.reservasionRepository.save(reservasion.get());
            } else {
                int diffirenceDay = getReservationDurationInDays(reservasionFirstDate, reservasionLastDate);
                Double totalPayment = hotel.getHotelPrice() * customerCount * diffirenceDay;
                reservasion.get().setTotalPayment(totalPayment);
                this.reservasionRepository.save(reservasion.get());
            }
        }
        if (type.equals("F")) {
            if (reservasion.get().getCustomerCount() == customerCount) {
                String rezervationLastDate = reservasion.get().getReservationLastDate();
                int diffirenceDay = getReservationDurationInDays(reservasionFirstDate, rezervationLastDate);
                Double totalPayment = hotel.getHotelPrice() * reservasion.get().getCustomerCount() * diffirenceDay;
                reservasion.get().setTotalPayment(totalPayment);
                this.reservasionRepository.save(reservasion.get());
            } else {
                String rezervationLastDate = reservasion.get().getReservationLastDate();
                int diffirenceDay = getReservationDurationInDays(reservasionFirstDate, rezervationLastDate);
                Double totalPayment = hotel.getHotelPrice() * customerCount * diffirenceDay;
                reservasion.get().setTotalPayment(totalPayment);
                this.reservasionRepository.save(reservasion.get());
            }
        }
        if (type.equals("L")) {
            if (reservasion.get().getCustomerCount() == customerCount) {
                String rezervationFirstDate = reservasion.get().getReservationStartDate();
                int diffirenceDay = getReservationDurationInDays(rezervationFirstDate, reservasionLastDate);
                Double totalPayment = hotel.getHotelPrice() * reservasion.get().getCustomerCount() * diffirenceDay;
                reservasion.get().setTotalPayment(totalPayment);
                this.reservasionRepository.save(reservasion.get());
            } else {
                String rezervationFirstDate = reservasion.get().getReservationStartDate();
                int diffirenceDay = getReservationDurationInDays(rezervationFirstDate, reservasionLastDate  );
                Double totalPayment = hotel.getHotelPrice() * customerCount * diffirenceDay;
                reservasion.get().setTotalPayment(totalPayment);
                this.reservasionRepository.save(reservasion.get());
            }
        }


        return "success updated";
    }

    @Override
    public List<ReservationResponse> reservasionList() {
        List<Reservasion> reservasionList = this.reservasionRepository.findAll();
        List<ReservationResponse> reservationResponses = reservasionList.stream().
                map(reservasion -> this.modelMapperService.forResponse().map(reservasion, ReservationResponse.class))
                .collect(Collectors.toList());
        return reservationResponses;
    }

    @Override
    public ReservationResponse reservasionNumberList(int reservationNumber) {
        Reservasion reservasion = this.reservasionRepository.findByReservationNumber(reservationNumber);
        ReservationResponse reservationResponses = this.modelMapperService.forResponse().map(reservasion, ReservationResponse.class);
        return reservationResponses;
    }

    public int getReservationDurationInDays(String reservasionStartDate, String reservasionLastDate) {
        LocalDate startDate = LocalDate.parse(reservasionStartDate);
        LocalDate lastDate = LocalDate.parse(reservasionLastDate);
        long daysBetween = ChronoUnit.DAYS.between(startDate, lastDate);
        return (int) daysBetween;
    }
}
