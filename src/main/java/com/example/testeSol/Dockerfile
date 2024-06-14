FROM eclipse-temurin:21
LABEL authors="Artur Maciel"

COPY ./ /app
COPY ./TesteSolApplication.java /APP
COPY ./ScoreController.java /APP
COPY ./ScoreService.java /APP
COPY ./envioScore.java /APP

WORKDIR /app
#COPY script.sh /app

EXPOSE 8080

ENTRYPOINT ["top", "-b"]
#CMD ["java", "-jar", "TesteSolApplication.jar"]
