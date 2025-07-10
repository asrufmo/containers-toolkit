package com.testing.containers.core;

import com.testing.containers.core.interfaces.ContainerManager;

import java.util.ArrayList;
import java.util.List;

public class ContainerOrchestrator {
    private final List<ContainerManager> managers = new ArrayList<>();

    public void register(ContainerManager manager) {
        this.managers.add(manager);
    }

    public void startAll() {
        this.managers.forEach(ContainerManager::startAll);
    }

    public void stopAll() {
        this.managers.forEach(ContainerManager::stopAll);
    }
}