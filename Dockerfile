FROM alpine:3.7
RUN apk update
RUN apk add maven
EXPOSE 8080
VOLUME /tmp

COPY ./target/shop-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
