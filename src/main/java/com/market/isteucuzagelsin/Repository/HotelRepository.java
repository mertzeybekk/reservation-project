package com.market.isteucuzagelsin.Repository;

import com.market.isteucuzagelsin.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    List<Hotel>findByHotelName(String hotelName);
}
