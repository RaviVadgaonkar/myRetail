package com.target.myretail.service;

import com.target.myretail.domain.ProductDetails;
import com.target.myretail.entities.Pricing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ProductDetailsService {

    @Autowired
    PdpService pdpService;

    @Autowired
    PricingService pricingService;

    public ProductDetails getProductDetailsById(String id) throws IOException, IllegalArgumentException {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Product id cannot be null or empty");
        }
        return new ProductDetails(id, pdpService.getNameFromPdp(id), getCurrentPrice(id));
    }


    private ProductDetails.Price getCurrentPrice(String id) {
        Double price = pricingService.getCurrentPrice(id);
        return new ProductDetails.Price(price, "USD");
    }

    public ProductDetails saveProductPricing(ProductDetails productDetails) {
        Pricing pricing = pricingService.saveOrUpdate(new Pricing(
                productDetails.getId(),
                productDetails.getCurrentPrice().getValue(),
                productDetails.getCurrentPrice().getCurrencyCode()
        ));
        return new ProductDetails(
                productDetails.getId(),
                productDetails.getName(),
                new ProductDetails.Price(pricing.getCurrentPrice(), pricing.getCurrency()));
    }
}
