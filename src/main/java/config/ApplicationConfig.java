package config;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        // Регистрируем все JAX-RS ресурсы
        classes.add(rest.HotelResource.class);

        // Регистрируем провайдеры (если есть)
        // classes.add(providers.JsonProcessingExceptionMapper.class);

        return classes;
    }
}