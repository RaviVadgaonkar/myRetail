**myRetail** is a demo project which exposes rest webservices for consolidating product details from different data sources which includes pdp rest webservice hosted on redsky as well as Pricing database maintained by this project itself. The PUT endpint could be used to update pricing for any product.

myRetail project is built using below tech stack,

1. Spring Boot framework
2. H2 embedded database
3. Gradle as build tool
4. Spock/MockMvc framework for unit tests


Prerequisites:
--------------

* JDK 11

IntelliJ Setup:
---------------

Open the project in IntelliJ:

1. Select **File** -> **Open** and choose the repository root.
2. On the Import Project from Gradle screen, check Auto Import


Building:
---------

    ./gradlew clean build

Running Boot Application
--------------------

    ./gradlew bootRun

The web server will be running and you should be able to navigate to [http://localhost:8080/actuator/health]()

Test results
------------
Below are some test results using curl.

**PUT Request**
curl -X PUT \
  http://localhost:8080/myretail/product-details/13860428 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: eae27482-173d-4dba-b223-babb0ede6bd8' \
  -H 'cache-control: no-cache' \
  -d '{"id":"13860428","name":"Any Name as we are ignoring the name","current_price":{"value":311.99,"currency_code":"USD"}}'

*Response* - {"id":"13860428","name":"Any Name as we are ignoring the name","current_price":{"value":311.99,"currency_code":"USD"}}

**GET Request**
curl -X GET http://localhost:8080/myretail/product-details/13860428

*Response* - {"id":"13860428","name":"The Big Lebowski (Blu-ray)","current_price":{"value":311.99,"currency_code":"USD"}}

**Get Request Invalid product**
curl -X GET http://localhost:8080/myretail/product-details/xxxxx

*Response* - {"errorType":"INVALID_PRODUCT","errorMessage":"We could not locate this product. Please check if the product id is correct."}
