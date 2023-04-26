package com.market.isteucuzagelsin.Repository;


import com.market.isteucuzagelsin.Entity.Paymnet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Paymnet,Integer> {
}
