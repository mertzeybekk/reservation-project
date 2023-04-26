package com.market.isteucuzagelsin.Repository;

import com.market.isteucuzagelsin.Entity.CrediCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CrediCardRepository extends JpaRepository<CrediCard,Integer> {
    List<CrediCard> findByCrediCardNumber(String crediCardNumber);
    Optional<CrediCard> deleteByCrediCardNumber(String crediCardNumber);
}
