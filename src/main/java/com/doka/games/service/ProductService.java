package com.doka.games.service;

import com.doka.games.dto.ProductDto;
import com.doka.games.model.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    public List<ProductDto> getAll();

    public void addProduct(List<ProductDto> productDto);

    public Product getById(Long productId);

    public Optional<Product> getAllById(Long productId);

}
