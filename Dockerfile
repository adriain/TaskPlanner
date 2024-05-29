FROM gradle:latest AS BUILD
WORKDIR /usr/task-planner/
COPY . . 
RUN gradle build



FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ENV APP_HOME=/usr/task-planner/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
COPY --from=BUILD $APP_HOME/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/usr/task-planner/app.jar"]
EXPOSE 8080