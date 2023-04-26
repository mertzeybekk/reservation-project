package com.market.isteucuzagelsin.Repository;

import com.market.isteucuzagelsin.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerFirstNameAndCustomerLastName(String firstName, String lastName);
    Customer findByCustomerEmail(String email);
    Customer findByCustomerNumberPhone(String numberPhone);
}
