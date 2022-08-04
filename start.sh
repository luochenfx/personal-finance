JAVA_OPTS="$JAVA_OPTS -Dspring.config.location=/home/cloud-phone/config/application.yml"
JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=dev"
JAVA_OPTS="$JAVA_OPTS -Dspring.development.autoconfigure.enabled=false"
JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.include=dev"
JAVA_OPTS="$JAVA_OPTS -Dspring.cloud.config.enabled=false"

