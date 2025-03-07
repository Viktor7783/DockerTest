# Используем официальный образ Java
FROM eclipse-temurin:23-jdk

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR файл в контейнер
COPY target/DockerTest-1.0-SNAPSHOT.jar DockerTest.jar

# Запускаем приложение
CMD ["java", "-jar", "DockerTest.jar"]