package com.target.myretail.service

import com.target.myretail.entities.Pricing
import com.target.myretail.repository.PricingRepository
import spock.lang.Unroll

class PricingServiceSpec extends BaseFixture {

    PricingService pricingService = new PricingService(
            pricingRepository: Mock(PricingRepository)
    )

    @Unroll
    def "get Pricing for given product id #scenario"() {
        when:
        Double actualCurrentPrice = pricingService.getCurrentPrice(TEST_PROD_ID)

        then:
        1 * pricingService.pricingRepository.findById(TEST_PROD_ID) >> priceFromRepository

        actualCurrentPrice == expectedCurrentPrice

        where:
        scenario                                        | priceFromRepository                    | expectedCurrentPrice
        'repository returns pricing'                    | Optional.of(TEST_VALID_PRICING_OBJECT) | 123.00
        'pricing not present for product in repository' | Optional.empty()                       | null
    }

    def "save given pricing for a product"() {
        when:
        Pricing actualPricing = pricingService.saveOrUpdate(TEST_VALID_PRICING_OBJECT)

        then:
        1 * pricingService.pricingRepository.save(TEST_VALID_PRICING_OBJECT) >> TEST_VALID_PRICING_OBJECT_FROM_REPOSITORY
        actualPricing == TEST_VALID_PRICING_OBJECT_FROM_REPOSITORY
    }
}
