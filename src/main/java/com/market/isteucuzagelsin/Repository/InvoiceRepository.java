package com.market.isteucuzagelsin.Repository;

import com.market.isteucuzagelsin.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
