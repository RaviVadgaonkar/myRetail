package com.target.myretail.service

import com.target.myretail.domain.ProductDetails
import com.target.myretail.entities.Pricing
import org.springframework.web.client.HttpClientErrorException
import spock.lang.Specification

class BaseFixture extends Specification {

    static final String TEST_PROD_ID = "some-prod-id";
    static final Pricing TEST_VALID_PRICING_OBJECT = new Pricing(currentPrice: 123.00, currency: 'USD');
    static final Pricing TEST_VALID_PRICING_OBJECT_FROM_REPOSITORY = new Pricing(currentPrice: 123.00, currency: 'USD')
    static final String TEST_PROD_NAME = "Samsung TV"
    static final Double TEST_PROD_PRICE_VALUE = 122.00
    static final String TEST_PROD_CURRENCY_CODE = 'USD'
    static final ProductDetails TEST_PROD_DETAILS = new ProductDetails(
            id: TEST_PROD_ID,
            name: TEST_PROD_NAME,
            currentPrice: new ProductDetails.Price(
                    value: TEST_PROD_PRICE_VALUE,
                    currencyCode: TEST_PROD_CURRENCY_CODE
            )
    )

    static final String TEST_EXPECTED_RESPONSE = """{"id":"$TEST_PROD_ID","name":"$TEST_PROD_NAME",""" +
            """"current_price":{"value":$TEST_PROD_PRICE_VALUE,"currency_code":"$TEST_PROD_CURRENCY_CODE"}}"""

    static final String TEST_PROD_NOT_FOUND_RESPONSE = """{"id":"$TEST_PROD_ID","name":"$TEST_PROD_NAME",""" +
            """"current_price":{"value":$TEST_PROD_PRICE_VALUE,"currency_code":"$TEST_PROD_CURRENCY_CODE"}}"""

    HttpClientErrorException.NotFound TEST_NOT_FOUND_EXCEPTION = new HttpClientErrorException.NotFound(
            'some text',
            null,
            null,
            null
    )

}