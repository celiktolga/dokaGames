package com.doka.games.dto;

import com.doka.games.model.Buyer;
import com.doka.games.model.Product;

import java.util.ArrayList;
import java.util.List;

public class BuyerMapper {

    public BuyerMapper() {

    }

    public static BuyerDto toDto(Buyer buyer) {
        BuyerDto buyerDto = new BuyerDto();
        buyerDto.setBuyerId(buyer.getId());
        buyerDto.setName(buyer.getName());
        List<ProductDto> dtoList = new ArrayList<>();

        for (Product product : buyer.getProductList()) {
            ProductDto dto = ProductMapper.toDto(product);
            dtoList.add(dto);
        }
        buyerDto.setProductDtoList(dtoList);
        return buyerDto;
    }

    public static Buyer toModel(BuyerDto buyerDto) {
        Buyer buyer = new Buyer();
        buyer.setId(buyerDto.getBuyerId());
        buyer.setName(buyerDto.getName());
        return buyer;
    }
}
