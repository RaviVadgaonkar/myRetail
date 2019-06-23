package com.target.myretail.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PdpService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PricingService pricingService;

    @Value("${redSky.url}")
    private String redSkyBaseUrl;

    @Value("${redSky.pdpPath}")
    private String pdpPathTemplate;

    public String getNameFromPdp(String id) throws IOException {

        String pdpUri = redSkyBaseUrl + pdpPathTemplate;
        Map<String, String> params = new HashMap<>();
        params.put("id", id);

        ResponseEntity<String> response
                = restTemplate.getForEntity(pdpUri, String.class, params);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode title = root.at("/product/item/product_description/title");
        return title.asText();
    }
}

