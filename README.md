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



