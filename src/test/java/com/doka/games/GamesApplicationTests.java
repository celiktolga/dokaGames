package com.doka.games;

import com.doka.games.dto.BuyerDto;
import com.doka.games.dto.ProductDto;
import com.doka.games.model.Buyer;
import com.doka.games.model.Product;
import com.doka.games.utils.ResponseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown=true)
@SpringBootTest(classes = GamesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GamesApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    @Order(1)
    public void contextLoads() {
    }

    @Test
    @Order(2)
    public void testAddBuyer() {
        List<BuyerDto> buyerDtos = new ArrayList<>();
        System.out.println("adding buyers..");
        buyerDtos.add(new BuyerDto().setName("Ankara Bayii"));
        buyerDtos.add(new BuyerDto().setName("Istanbul Bayii"));

        ResponseEntity<ResponseModel> postResponse = restTemplate.postForEntity(getRootUrl() + "/buyer/add", buyerDtos, ResponseModel.class);
        org.junit.jupiter.api.Assertions.assertNotNull(postResponse);
        org.junit.jupiter.api.Assertions.assertNotNull(postResponse.getBody());
    }


    @Test
    @Order(3)
    public void testGetAllBuyer() {
        testAddBuyer();
        HttpHeaders headers = new HttpHeaders();
        System.out.println("Get all buyers..");
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<ResponseModel> response = restTemplate.exchange(getRootUrl() + "/buyer/all",
                HttpMethod.GET, entity, ResponseModel.class);
        Assertions.assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }
	 
}
