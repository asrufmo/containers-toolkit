package com.testing.containers.core.interfaces;

import org.testcontainers.containers.GenericContainer;

public interface ContainerProvider<T extends GenericContainer<?>> {
    T getContainer();
    String getName();
}