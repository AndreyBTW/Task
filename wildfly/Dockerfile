FROM quay.io/wildfly/wildfly:34.0.1.Final-jdk17

USER root
# Создаём директорию модуля и копируем туда драйвер + module.xml
COPY wildfly/modules/com/mariadb /opt/jboss/wildfly/modules/com/mariadb
COPY wildfly/configure-ds.cli /opt/jboss/wildfly/standalone/configure-ds.cli
COPY target/hotel-api-1.0.0.war /opt/jboss/wildfly/standalone/deployments/app.war

USER jboss
ENTRYPOINT ["/bin/sh","-c", "\
  /opt/jboss/wildfly/bin/jboss-cli.sh --file=/opt/jboss/wildfly/standalone/configure-ds.cli && \
  /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 \
"]
EXPOSE 8080 9990
