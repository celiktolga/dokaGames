package com.doka.games.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyerDto {

    private Long buyerId;
    private String name;
    private List<ProductDto> productDtoList;

    public BuyerDto setName(String name) {
        this.name = name;
        return this;
    }
}
