package com.testing.containers.providers;

import com.testing.containers.core.interfaces.ContainerProvider;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

public class PostgresContainerProvider implements ContainerProvider<PostgreSQLContainer<?>> {

    private final PostgreSQLContainer<?> container;

    public PostgresContainerProvider() {
        this.container = new PostgreSQLContainer<>("postgres:15")
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test")
                .waitingFor(Wait.forListeningPort()); // Wait until it's ready
    }

    public PostgresContainerProvider withNetwork(Network network) {
        container.withNetwork(network);
        return this;
    }

    public PostgresContainerProvider withAlias(String alias) {
        container.withNetworkAliases(alias);
        return this;
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
