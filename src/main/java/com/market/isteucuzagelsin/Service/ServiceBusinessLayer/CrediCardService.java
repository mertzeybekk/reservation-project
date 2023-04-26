package com.market.isteucuzagelsin.Service.ServiceBusinessLayer;

import com.market.isteucuzagelsin.Dto.Request.CrediCardRequest;
import com.market.isteucuzagelsin.Dto.Response.AccountResponse;
import com.market.isteucuzagelsin.Dto.Response.CrediCardResponse;
import com.market.isteucuzagelsin.Entity.CrediCard;
import com.market.isteucuzagelsin.Entity.Customer;
import com.market.isteucuzagelsin.Mapper.ModelMapperService;
import com.market.isteucuzagelsin.Repository.AccountRepository;
import com.market.isteucuzagelsin.Repository.CrediCardRepository;
import com.market.isteucuzagelsin.Repository.CustomerRepository;
import com.market.isteucuzagelsin.Service.ServiceImpl.CrediCardImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrediCardService implements CrediCardImpl {
    @Autowired
    private CrediCardRepository crediCardRepository;
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    public CrediCardService(CrediCardRepository crediCardRepository, ModelMapperService modelMapperService, AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.crediCardRepository = crediCardRepository;
        this.modelMapperService = modelMapperService;
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public CrediCardService() {
    }

    @Override
    public String crediCardCreate(CrediCardRequest crediCardRequest) {
        if (crediCardRequest == null) {
            throw new RuntimeException("Credi Card not blank");
        }
        if (crediCardRequest.getCrediCardNumber().length() < 16) {
            throw new RuntimeException("credit card number cannot be less than 16 characters");
        }
        Optional<Customer> customerById = this.customerRepository.findById(crediCardRequest.getCustomerId());
        if (!customerById.isPresent()) {
            throw new RuntimeException("Customer with id " + crediCardRequest.getCustomerId() + " not found");
        }

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String createdDate = formatter.format(today);
        CrediCard crediCard = new CrediCard();
        crediCard.setCrediCardNumber(crediCardRequest.getCrediCardNumber());
        crediCard.setValidtyDate(createdDate);
        crediCard.setCustomer(customerById.get());
        crediCard.setAccount(customerById.get().getAccountList().get(crediCard.getCustomer().getId() - 1));
        crediCard.setSecurityNumber(crediCardRequest.getSecurityNumber());
        crediCard.setCrediCardPassword(crediCardRequest.getCrediCardPassword());
        this.crediCardRepository.save(crediCard);
        return "success add crediCard!!";
    }

    @Override
    public String crediCardDelete(String crediCardNumber) {
        Optional<CrediCard> crediCard = this.crediCardRepository.deleteByCrediCardNumber(crediCardNumber);
        return "Success delete crediCard";
    }

    @Override
    public String crediCardUpdate(String crediCardNumber, int crediCardPassword) {
        List<CrediCard> crediCard = this.crediCardRepository.findByCrediCardNumber(crediCardNumber);
        for (CrediCard card : crediCard) {
            if (card.getCrediCardPassword() != crediCardPassword) {
                card.setCrediCardPassword(crediCardPassword);
                this.crediCardRepository.save(card);
            }
        }
        return "success update";
    }

    @Override
    public List<CrediCardResponse> crediCardAllList() {
        List<CrediCard> crediCards = this.crediCardRepository.findAll();
        List<CrediCardResponse> crediCardResponses = crediCards.stream().
                map(crediCard -> this.modelMapperService.forResponse().map(crediCard, CrediCardResponse.class))
                .collect(Collectors.toList());
        return crediCardResponses;
    }

    @Override
    public List<CrediCardResponse> crediCardByCardNumber(String crediCardNumber) {
        List<CrediCard> crediCards = this.crediCardRepository.findByCrediCardNumber(crediCardNumber);
        List<CrediCardResponse> crediCardResponses = crediCards.stream().
                map(crediCard -> this.modelMapperService.forResponse().map(crediCard, CrediCardResponse.class))
                .collect(Collectors.toList());
        return crediCardResponses;

    }
}
