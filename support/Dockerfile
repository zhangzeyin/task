FROM openjdk:8-jre-alpine

WORKDIR /target

RUN apk update && apk add ca-certificates && \
    apk add tzdata && \
    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone

RUN mkdir logs 

COPY test-0.0.1-SNAPSHOT.jar ./

EXPOSE 8080

CMD java -jar *.jar 