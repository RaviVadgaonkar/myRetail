package com.target.myretail.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDetails {

    private String id;
    private String name;
    @JsonProperty("current_price")
    private Price currentPrice;

    public ProductDetails(String id, String name, Price currentPrice) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public ProductDetails(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Price getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Price currentPrice) {
        this.currentPrice = currentPrice;
    }

    public static class Price {
        Double value;
        @JsonProperty("currency_code")
        String currencyCode;

        public Price(Double value, String currencyCode) {
            this.value = value;
            this.currencyCode = currencyCode;
        }

        public Price(){}

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }
    }
}

