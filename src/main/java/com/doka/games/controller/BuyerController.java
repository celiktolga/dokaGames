package com.doka.games.controller;

import com.doka.games.dto.BuyerDto;
import com.doka.games.model.Buyer;
import com.doka.games.utils.ResponseModel;
import com.doka.games.utils.RestConstants;
import com.doka.games.service.BuyerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    private static Logger LOGGER = LoggerFactory.getLogger(BuyerController.class);

    @Autowired
    BuyerService buyerService;

    @ResponseBody
    @GetMapping({RestConstants.V1 + RestConstants.ALL})
    public ResponseEntity<ResponseModel> getAllBuyers() {
        List<BuyerDto> fieldList = buyerService.getAll();

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

    @ResponseBody
    @GetMapping(value = {RestConstants.V1 + RestConstants.ID}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Buyer> getByBuyerId(@PathVariable(value = "id") Long buyerId) {
        System.out.println("Buyer is getting with ID " + buyerId);
        Buyer buyer = buyerService.getById(buyerId);  
        return new ResponseEntity<Buyer>(buyer, HttpStatus.OK);
    }


    @PostMapping({RestConstants.V1 + RestConstants.ADD})
    public ResponseEntity<ResponseModel> addBuyer(@RequestBody List<BuyerDto> buyerDtos) {
        buyerService.addBuyer(buyerDtos);
        return new ResponseEntity<>(new ResponseModel()
                .setStatus(RestConstants.OK)
                .setMessage(RestConstants.SS)
                .setObject(null)
                , HttpStatus.OK);
    }


}
