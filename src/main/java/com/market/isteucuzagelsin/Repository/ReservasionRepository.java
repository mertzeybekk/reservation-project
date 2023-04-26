package com.market.isteucuzagelsin.Repository;

import com.market.isteucuzagelsin.Entity.Reservasion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasionRepository extends JpaRepository<Reservasion,Integer> {
    void  deleteByReservationNumber(int reservationNumber);
    Reservasion findByReservationNumber(int reservationNumber);

}
