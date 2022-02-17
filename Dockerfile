FROM openjdk:8-jdk-alpine
ADD target/timesheet-ci-*.jar /asus/timesheet-ci.jar/
CMD ["java","-jar","/asus/timesheet-ci.jar"]