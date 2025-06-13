package config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;

import java.io.InputStream;

public class KeycloakConfigResolverImpl implements KeycloakConfigResolver {

    private KeycloakDeployment deployment;

    public KeycloakConfigResolverImpl() {
        InputStream config = getClass().getResourceAsStream("/keycloak.json");
        if (config != null) {
            deployment = KeycloakDeploymentBuilder.build(config);
        }
    }

    @Override
    public KeycloakDeployment resolve(OIDCHttpFacade.Request request) {
        return deployment;
    }
}