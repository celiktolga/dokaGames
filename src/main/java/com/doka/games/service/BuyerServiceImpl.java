package com.doka.games.service;

import com.doka.games.dto.BuyerDto;
import com.doka.games.dto.BuyerMapper;
import com.doka.games.dto.ProductDto;
import com.doka.games.dto.ProductMapper;
import com.doka.games.model.Buyer;
import com.doka.games.model.Product;
import com.doka.games.repository.BuyerRepository;
import com.doka.games.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuyerServiceImpl implements BuyerService {

    private static Logger logger = LoggerFactory.getLogger(BuyerServiceImpl.class);

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    ProductService productService;

    @Override
    public List<BuyerDto> getAll() {
        logger.info("Getting all buyers");
        try {
            /*List<Buyer> buyers = buyerRepository.findAll();
            if(buyers.isEmpty()){
                throw new CustomException(RestConstants.RNF);
            }*/
            List<BuyerDto> dtoList = buyerRepository.findAll().stream().map(BuyerMapper::toDto).collect(Collectors.toList());
            return dtoList;
        } catch (Exception ex) {
            logger.error(String.valueOf(ex));
            throw ex;
        }
    }

    @Override
    public void addBuyer(List<BuyerDto> buyerDtos) {
        logger.info("Adding buyers");
        buyerDtos.stream().forEach(buyerDto -> {
            Buyer buyer = BuyerMapper.toModel(buyerDto);
            buyerRepository.save(buyer);
        });
    }

    public Buyer getById(Long buyerId) {
        return buyerRepository.getOne(buyerId);
    }
}
