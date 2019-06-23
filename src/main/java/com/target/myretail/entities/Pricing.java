package com.target.myretail.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pricing {

    @Id
    private String skuId;
    private Double currentPrice;
    private String currency;

    public Pricing(String skuId, Double currentPrice, String currency) {
        this.skuId = skuId;
        this.currentPrice = currentPrice;
        this.currency = currency;
    }

    public Pricing(){}

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double price) {
        this.currentPrice = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

}
