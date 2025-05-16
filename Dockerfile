FROM eclipse-temurin:21-jre-jammy
ENV TZ=Asia/Seoul
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]