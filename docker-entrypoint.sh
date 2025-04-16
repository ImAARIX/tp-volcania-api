#!/bin/ash

# shellcheck disable=SC2011
JAR_FILE=${JAR_FILE:-$(ls /app/*.jar | xargs -n 1 basename)}
JAR_FILE_TO_EXECUTE="${APP_BASE_DIR}/${JAR_FILE}"

exec java "${JAVA_OPTS}" -jar "/app/${JAR_FILE_TO_EXECUTE}"
