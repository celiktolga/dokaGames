package com.doka.games.dto;

import com.doka.games.model.Product;

public class ProductMapper {

    public ProductMapper() {

    }

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setBuyerId(product.getBuyer().getId());
        productDto.setId(product.getId());
        return productDto;
    }

    public static Product toModel(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setBuyer(product.getBuyer());
        return product;
    }
}
