# online-store-microservices
Website dedicated to the sale of jewellery based on microservices. Developed with Spring Boot 2.1.10 and Spring Cloud Greenwich.
![Architecture](https://github.com/BlancaAsensio/online-store-microservices/blob/master/arquitectura.jpg)

· Service Discovery: registry where all microservices configurations are stored.
· Products Server: responsible for storing and managing all store products and providing through a REST API all the operations necessary for the web.
· Cart Server: responsible for managing all the products that the user adds to the shopping cart and providing through a REST API all the operations necessary for the web.
· Web Server: responsible for managing all views of the application using HTML, CSS and JavaScript; sending requests to other microservices and to process their response to such requests.

