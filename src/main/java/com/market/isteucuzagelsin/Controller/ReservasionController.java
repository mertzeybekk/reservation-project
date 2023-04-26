package com.market.isteucuzagelsin.Controller;

import com.market.isteucuzagelsin.Dto.Request.ReservasionRequest;
import com.market.isteucuzagelsin.Dto.Response.ReservationResponse;
import com.market.isteucuzagelsin.Service.ServiceBusinessLayer.ReservasionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservasion")
public class ReservasionController {
    private ReservasionService reservasionService;

    public ReservasionController(ReservasionService reservasionService) {
        this.reservasionService = reservasionService;
    }

    @PostMapping("/createReservasion")
    public String createReservasion(@RequestBody ReservasionRequest reservasionRequest) {
        return this.reservasionService.reservasionCreate(reservasionRequest);
    }

    @PostMapping("/deleteReservasion/{reservasionNumber}")
    public String deleteReservation(@PathVariable int reservationNumber) {
        return this.reservasionService.reservasionDelete(reservationNumber);
    }

    @PostMapping("/updateReservasion/{reservasionFirstDate}/{reservasionLastDate}/{reservasionNumber}/{customerCount}/{type}")
    public String updateReservasion(@PathVariable String reservasionFirstDate, @PathVariable String reservasionLastDate, @PathVariable int reservationNumber, @PathVariable int customerCount,@PathVariable String type) {
        return this.reservasionService.reservasionUpdate(reservasionFirstDate, reservasionLastDate, reservationNumber, customerCount,type);
    }

    @GetMapping("/getAllReservasion")
    public List<ReservationResponse> reservationList() {
        return this.reservasionService.reservasionList();
    }

    @GetMapping("/getReservasionNumber/{reservasionNumber}")
    public ReservationResponse getreservationNumber(@PathVariable int reservationNumber) {
        return this.reservasionService.reservasionNumberList(reservationNumber);
    }
}