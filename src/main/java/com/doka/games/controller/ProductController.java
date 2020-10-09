package com.doka.games.controller;
 
import com.doka.games.dto.ProductDto;
import com.doka.games.service.ProductService;
import com.doka.games.utils.ResponseModel;
import com.doka.games.utils.RestConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @ResponseBody
    @GetMapping({RestConstants.V1 + RestConstants.ALL})
    public ResponseEntity<ResponseModel> getAllProducts() {
        List<ProductDto> fieldList = productService.getAll();

        if (fieldList.isEmpty()) {
            return new ResponseEntity(new ResponseModel()
                    .setStatus(RestConstants.OK)
                    .setMessage(RestConstants.EL)
                    .setObject(fieldList)
                    , HttpStatus.OK);
        }
        return new ResponseEntity(new ResponseModel()
                .setStatus(RestConstants.OK)
                .setMessage(RestConstants.SG)
                .setObject(fieldList)
                , HttpStatus.OK);
    }


    @PostMapping({RestConstants.V1 + RestConstants.ADD})
    public ResponseEntity<ResponseModel> addProduct(@RequestBody List<ProductDto> ProductDtos) {
        productService.addProduct(ProductDtos);
        return new ResponseEntity<>(new ResponseModel()
                .setStatus(RestConstants.OK)
                .setMessage(RestConstants.SS)
                .setObject(null)//ProductService.addProduct(ProductDtos)
                , HttpStatus.OK);
    }
}
