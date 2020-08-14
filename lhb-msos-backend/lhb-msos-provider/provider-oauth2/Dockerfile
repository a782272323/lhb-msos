FROM openjdk:8-jdk-alpine

# 写入作者信息
MAINTAINER Herbie <782272323@qq.com>

# 时区同步
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 监听端口来完成发布
ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

RUN mkdir /app
COPY provider-oauth2-0.3.0-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app.jar"]