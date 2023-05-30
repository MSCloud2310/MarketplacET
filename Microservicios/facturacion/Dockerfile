FROM maven AS build
WORKDIR /app-src
COPY src src
COPY pom.xml .

RUN mvn clean package

FROM khipu/openjdk17-alpine AS server
ENV SERVER_PORT=9070
EXPOSE ${SERVER_PORT}
WORKDIR /

VOLUME /tmp
COPY --from=build /app-src/target/app.jar .

COPY start.sh .
RUN chmod +x start.sh

ENTRYPOINT ["/start.sh"]