package com.testing.containers.core.interfaces;

public interface ContainerManager {
    void startAll();
    void stopAll();
    boolean isRunning();
}