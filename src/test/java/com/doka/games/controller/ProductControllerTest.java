package com.doka.games.controller;

import com.doka.games.dto.ProductDto;
import com.doka.games.model.Buyer;
import com.doka.games.model.Product;
import com.doka.games.service.BuyerService;
import com.doka.games.service.ProductService;
import com.doka.games.utils.ResponseModel;
import com.doka.games.utils.RestConstants;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductController productController;

    @MockBean
    ProductService productService;
    @MockBean
    BuyerService buyerService;

    @Test
    public void tetsAddProduct() {
        List<ProductDto> dtoList = Mockito.mock(List.class);
        ProductDto productDto = Mockito.mock(ProductDto.class);
        when(dtoList.get(0)).thenReturn(productDto);
        when(dtoList.get(0).getBuyerId()).thenReturn(1L);
        Buyer mockedBuyer = mock(Buyer.class);
        Mockito.when(buyerService.getById(1L)).thenReturn(mockedBuyer);
//        Mockito.doNothing().when(productService.addProduct(dtoList));
        ResponseEntity<ResponseModel> mockresponseEntity = productController.addProduct(dtoList);
        Assertions.assertNotNull(mockresponseEntity);
    }
 
}
