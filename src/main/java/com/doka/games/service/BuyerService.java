package com.doka.games.service;

import com.doka.games.dto.BuyerDto;
import com.doka.games.model.Buyer;

import java.util.List;


public interface BuyerService {

    public List<BuyerDto> getAll();

    public  void addBuyer(List<BuyerDto> buyerDto);

    public Buyer getById(Long buyerId);
}
