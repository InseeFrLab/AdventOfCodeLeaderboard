FROM adoptopenjdk:11-jre-openj9
ADD target/adventcalendar*.jar /app/adventcalendar.jar
CMD java -jar /app/adventcalendar.jar
