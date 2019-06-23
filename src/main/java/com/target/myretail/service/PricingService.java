package com.target.myretail.service;

import com.target.myretail.entities.Pricing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.target.myretail.repository.PricingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PricingService {
    @Autowired
    PricingRepository pricingRepository;

    public Double getCurrentPrice(String id) {
        Pricing pricing = getPricingById(id);
        if (pricing != null) {
            return pricing.getCurrentPrice();
        }
        return null;
    }

    private Pricing getPricingById(String id) {
        Optional<Pricing> pricing = pricingRepository.findById(id);
        if (pricing.isPresent()) {
            return pricing.get();
        }
        return null;
    }

    public Pricing saveOrUpdate(Pricing pricing) {
        return pricingRepository.save(pricing);
    }

/*    public void delete(String id) {
        pricingRepository.deleteById(id);
    }

    public List<Pricing> getAllPrices() {
        List<Pricing> prices = new ArrayList<>();
        pricingRepository.findAll().forEach(prices::add);
        return prices;
    }
*/
}
