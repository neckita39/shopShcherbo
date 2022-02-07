FROM openjdk:11-slim
ADD target/shop-0.0.1-SNAPSHOT.jar shop.jar
ENTRYPOINT ["java", "-jar", "shop.jar"]