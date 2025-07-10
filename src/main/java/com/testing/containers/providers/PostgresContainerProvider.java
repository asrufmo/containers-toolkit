package com.testing.containers.providers;

import com.testing.containers.core.interfaces.ContainerProvider;
import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresContainerProvider implements ContainerProvider<PostgreSQLContainer<?>> {
    private final PostgreSQLContainer<?> container;

    public PostgresContainerProvider() {
        this.container = new PostgreSQLContainer<>("postgres:15")
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test");
    }

    @Override
    public PostgreSQLContainer<?> getContainer() {
        return container;
    }

    @Override
    public String getName() {
        return "postgres";
    }
}