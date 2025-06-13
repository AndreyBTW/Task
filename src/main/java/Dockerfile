FROM quay.io/wildfly/wildfly:31.0.0.Final

# Установка драйвера MariaDB
COPY mariadb-java-client-3.3.2.jar /tmp/
RUN /opt/jboss/wildfly/bin/jboss-cli.sh --file=/wildfly-config/configure-datasource.cli

# Установка Keycloak адаптера
COPY keycloak-oidc-wildfly-adapter-24.0.2.zip /tmp/
RUN unzip /tmp/keycloak-oidc-wildfly-adapter-24.0.2.zip -d /tmp && \
    /tmp/keycloak-24.0.2/bin/kc-adapter.sh install /opt/jboss/wildfly

# Копирование приложения
COPY target/hotel-api.war /opt/jboss/wildfly/standalone/deployments/

# Настройка Keycloak
COPY --chown=wildfly:wildfly src/main/webapp/WEB-INF/keycloak.json /opt/jboss/wildfly/standalone/configuration/

# Запуск сервера
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]