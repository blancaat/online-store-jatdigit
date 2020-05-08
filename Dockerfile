FROM openjdk:8-jre
ADD target/online-store-microservices-2.0.2.RELEASE.jar app.jar
EXPOSE 1111
EXPOSE 2222
EXPOSE 3333
EXPOSE 4444
# ENTRYPOINT ["java","-jar","/app.jar","accounts"]
