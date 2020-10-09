package com.doka.games.service;

import com.doka.games.dto.ProductDto;
import com.doka.games.dto.ProductMapper;
import com.doka.games.model.Buyer;
import com.doka.games.model.Product;
import com.doka.games.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;
    @Autowired
    BuyerService buyerService;

    @Override
    public List<ProductDto> getAll() {
        logger.info("Getting all buyers");
        try {
            return productRepository.findAll().stream().map(ProductMapper::toDto).collect(Collectors.toList());
        } catch (Exception ex) {
            logger.error(String.valueOf(ex));
            throw ex;
        }
    }

    @Override
    public void addProduct(List<ProductDto> productDto) {
        logger.info("Adding products");
        for (ProductDto dto : productDto) {
            Buyer buyer = buyerService.getById(dto.getBuyerId());
            Product product = new Product();
            product.setBuyer(buyer);
            product.setName(dto.getName());
            productRepository.save(product);
        }
    }

    @Override
    public Product getById(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Optional<Product> getAllById(Long productId) {
        return productRepository.findById(productId);
    }
}
