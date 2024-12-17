# Etapa 1: Construção do WAR com Maven
FROM maven:3.8.6-openjdk-8-slim AS build

# Define o diretório de trabalho para copiar o código do projeto
WORKDIR /app

# Copia o arquivo pom.xml e os diretórios necessários para o contêiner
COPY pom.xml .

# Baixa as dependências do Maven
RUN mvn dependency:go-offline

# Copia o restante do código-fonte
COPY src /app/src

# Compila o WAR usando Maven
RUN mvn clean package -DskipTests

# Etapa 2: Rodando o WAR no Tomcat
FROM tomcat:9-jdk8-openjdk-slim

# Copia o WAR gerado para o diretório webapps do Tomcat
COPY --from=build /app/target/project-task-manager.war /usr/local/tomcat/webapps/

# Expõe a porta 8080, que é a porta padrão do Tomcat
EXPOSE 8080

# Comando para rodar o Tomcat
CMD ["catalina.sh", "run"]