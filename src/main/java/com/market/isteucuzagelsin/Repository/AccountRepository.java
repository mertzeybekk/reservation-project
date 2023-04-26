package com.market.isteucuzagelsin.Repository;

import com.market.isteucuzagelsin.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByAccountNumber(String accountNumber);
    void deleteByAccountNumber(String accountNumber);
}
