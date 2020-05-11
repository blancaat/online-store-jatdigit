# Run Using Docker

We are going to run the Online-Store-Microservice application using four docker containers.

## Build the image

1. Build using `mvn install`

   This will create the jar: `target/online-store-microservices-2.0.2.RELEASE.jar`

1. This is the content of the Dockerfile:

    ```sh
    FROM openjdk:8-jre
    ADD target/online-store-microservices-2.2.0.RELEASE.jar app.jar
    EXPOSE 1111
    EXPOSE 2222
    EXPOSE 3333
    EXPOSE 4444
    ```

    What this does:

    * Use the OpenJDK 8 docker base image. 
    * Copy the demo jar into the container and rename it to `app.jar` to save typing later.  By default, `app.jar` will be copied into the root of the container file system.
    * Expose ports 1111, 2222, 3333 and 4444.

1. To build the container (**note** the `.` at the end, indicating to use the current directory as its working directory):

    ```sh
    docker build -t online-store-microservice .
    ```

1. Check it worked.

    ```sh
    docker images
    ```

## Running the Application

We will run the container three times, each time running the Java application in a different mode.

![Example Microservices System](mini-system.jpg)

1. They need to talk to each other, so let's give them a network:

    ```sh
    docker network create online-store-net
    ```

1. Now run the first container. This runs up the Eureka registration server, which will allow the other microservices to find each other:

    ```sh
    docker run --name reg --hostname reg --network online-store-net -p 1111:1111 online-store-microservice java -jar app.jar reg
    ```

    The `-d` (detach) flag is missing so all output will stream to the console so we can see what is happening.
    
    As soon as the application starts up, it displays its IP address. Remember this for later.

1. In your browser, go to http://localhost:1111 and you should see the Eureka dashboard. There are no instances registered.

1. _In a new CMD/Terminal window_, run a second container for the PRODUCTS microservice.

    ```sh
    docker run --name products --hostname products --network online-store-net -p 2222:2222 online-store-microservice java -jar app.jar products  --registration.server.hostname=<reg server ip addr>
    ```

    Replace `<reg server ip addr>` with the IP address you determined earlier.

1. Return to the Eureka Dashboard in your browser and refresh the screen.  You should see that `PRODUCTS-SERVICE` is now registered.

1. _In a new CMD/Terminal window_, run a third container for the CART microservice.

    ```sh
    docker run --name cart --hostname cart --network online-store-net -p 4444:4444 online-store-microservice java -jar app.jar products  --registration.server.hostname=<reg server ip addr>
    ```

    Replace `<reg server ip addr>` with the IP address you determined earlier.

1. Return to the Eureka Dashboard in your browser and refresh the screen.  You should see that `PRODUCTS-SERVICE` and `CART-SERVICE` is now registered.

1. _In a new CMD/Terminal window_, run a fourth container for the WEB microservice. This is a web-application for viewing the information by requesting from all the microservices.

    ```sh
    docker run --name web --hostname web --network online-store-net -p 3333:3333 online-store-microservice java -jar app.jar web --registration.server.hostname=<eg server ip addr>
    ```

    Replace `<reg server ip addr>` with the IP address you determined earlier.

1. Return to the Eureka Dashboard in your browser and refresh the screen.  You should see that `PRODUCTS-SERVICE`, `CART-SERVICE` and `WEB-SERVICE` are now registered.

1. In a second browser tab, go to http://localhost:3333.  This is the web interface you just deployed and you should be able to view, list and search for information.
