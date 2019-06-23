package com.target.myretail.service

import com.target.myretail.domain.ProductDetails
import spock.lang.Unroll

class ProductDetailsServiceSpec extends BaseFixture {

    ProductDetailsService productDetailsService = new ProductDetailsService(
            pricingService: Mock(PricingService),
            pdpService: Mock(PdpService)
    )

    def "get product details for id"() {
        setup:
        ProductDetails expectedProdDetails = new ProductDetails(
                id: TEST_PROD_ID,
                name: TEST_PROD_NAME,
                currentPrice: new ProductDetails.Price(
                        value: TEST_PROD_PRICE_VALUE,
                        currencyCode: TEST_PROD_CURRENCY_CODE
                )
        )

        when:
        ProductDetails actualProdDetails = productDetailsService.getProductDetailsById(TEST_PROD_ID)

        then:
        1 * productDetailsService.pdpService.getNameFromPdp(TEST_PROD_ID) >> TEST_PROD_NAME
        1 * productDetailsService.pricingService.getCurrentPrice(TEST_PROD_ID) >> TEST_PROD_PRICE_VALUE

        actualProdDetails.id == expectedProdDetails.id
        actualProdDetails.name == expectedProdDetails.name
        actualProdDetails.currentPrice.value == expectedProdDetails.currentPrice.value
        actualProdDetails.currentPrice.currencyCode == expectedProdDetails.currentPrice.currencyCode
    }

    @Unroll
    def "invalid product id throws exception, #scenario"() {
        when:
        productDetailsService.getProductDetailsById(productId)

        then:
        thrown(IllegalArgumentException)


        where:
        scenario           | productId
        'null product id'  | null
        'empty product id' | ''
    }

/*
 TODO: Tests similar to above need to be written for saveOrUpdate method
 */
}
