FROM registry.access.redhat.com/ubi8/openjdk-17:1.18

ENV LANGUAGE='pt_BR'

COPY --chown=185 target/quarkus-app/lib/ /deployments/lib/
COPY --chown=185 target/quarkus-app/*.jar /deployments/
COPY --chown=185 target/quarkus-app/app/ /deployments/app/
COPY --chown=185 target/quarkus-app/quarkus/ /deployments/quarkus/

ENV QUARKUS_DATASOURCE_URL jdbc:postgresql://postgres:5432/dbseletivosesp
ENV QUARKUS_DATASOURCE_USERNAME seletivosesp
ENV QUARKUS_DATASOURCE_PASSWORD seletivosesp

EXPOSE 9090
USER 185
ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

ENTRYPOINT [ "/opt/jboss/container/java/run/run-java.sh" ]

# COMANDOS PARA LEVANTAR APLICAÇÃO
# ./mvnw -Dquarkus.profile=dev package
# docker build -t  api-sesp-quarkus .
# docker run -p 9090:8080 --name apisesp apisesp-quarkus
# docker-compose up -d
# docker-compose down
# docker logs projetopratico_quarkus-app_1
# docker rm -f sesp-api


