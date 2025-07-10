package com.testing.containers.managers;

import com.testing.containers.core.interfaces.ContainerManager;
import com.testing.containers.core.interfaces.ContainerProvider;
import org.testcontainers.containers.GenericContainer;

import java.util.List;

public class DatabaseContainerManager implements ContainerManager {

    private final List<ContainerProvider<? extends GenericContainer<?>>> providers;

    public DatabaseContainerManager(List<ContainerProvider<? extends GenericContainer<?>>> providers) {
        this.providers = providers;
    }

    @Override
    public void startAll() {
        providers.forEach(p -> p.getContainer().start());
    }

    @Override
    public void stopAll() {
        providers.forEach(p -> p.getContainer().stop());
    }

    @Override
    public boolean isRunning() {
        return providers.stream().allMatch(p -> p.getContainer().isRunning());
    }
}