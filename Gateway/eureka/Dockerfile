FROM maven:3 AS build
WORKDIR /app-src
COPY src src
COPY pom.xml .

RUN mvn clean package

# Para solo ejecutar hasta este punto:
# docker build --target builder -t calculadora-build

#-----------------------------------
FROM khipu/openjdk17-alpine AS server
ENV SERVER_PORT=8761
EXPOSE ${SERVER_PORT}


VOLUME /tmp
COPY --from=build /app-src/target/app.jar .
ENTRYPOINT ["java","-jar","./app.jar"]