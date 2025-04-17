FROM gradle:8.10-jdk21-alpine AS builder

USER root
WORKDIR /app

ARG JAR_FILE
ENV JAR_FILE=${JAR_FILE}
ENV JAVA_OPTS="-Dnetworkaddress.cache.ttl=5 -Dnetworkaddress.cache.negative.ttl=5 -Dspring.profiles.active=dev-docker"
ENV APP_BASE_DIR=/app

COPY . .

RUN gradle build --no-daemon

FROM eclipse-temurin:21.0.1_12-jre-alpine

USER root
WORKDIR /app

COPY docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod +x /docker-entrypoint.sh

COPY --from=builder /app/build/libs/${JAR_FILE:-*.jar} /app/app.jar

EXPOSE 80
HEALTHCHECK --start-period=30s --start-interval=10s --interval=30s --timeout=3s --retries=5 CMD wget http://localhost:8080/actuator/health -q -O - 2>&1 | grep UP

ENTRYPOINT ["/docker-entrypoint.sh"]
