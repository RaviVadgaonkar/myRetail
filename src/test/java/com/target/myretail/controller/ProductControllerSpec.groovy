package com.target.myretail.controller

import com.target.myretail.service.BaseFixture
import com.target.myretail.service.ProductDetailsService
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class ProductControllerSpec extends BaseFixture {
    ProductDetailsService productDetailsService = Mock(ProductDetailsService)
    ProductController productController = new ProductController(
            productDetailsService: productDetailsService
    )

    def "GET endpoint request mapping Spec"() {
        setup:
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(productController).build()

        when:
        def response = mockMvc.perform(get("/myretail/product-details/$BaseFixture.TEST_PROD_ID")).andReturn().response

        then:
        1 * productDetailsService.getProductDetailsById(BaseFixture.TEST_PROD_ID) >> BaseFixture.TEST_PROD_DETAILS

        response.status == HttpStatus.OK.value()
        response.contentType == 'application/json;charset=UTF-8'
        response.contentAsString == BaseFixture.TEST_EXPECTED_RESPONSE
    }

    /* PUT endpoint request mapping and response entity creation could
        be tested same as done for GET request above
     */

    def "PUT endpoint request mapping Spec - #scenario"() {

    }


    /* GET endpoint error response creation will be tested in same way
     */

    def "Get endpoint Exception response mapping Spec - Invalid product id requested"() {

    }

    /* PUT endpoint error response creation will be tested in same way
     */

    def "PUT endpoint Exception response mapping Spec - Invalid product id requested"() {

    }
}
