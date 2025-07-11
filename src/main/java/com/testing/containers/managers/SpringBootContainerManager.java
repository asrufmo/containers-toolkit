package com.testing.containers.managers;

import com.testing.containers.providers.GenericSpringBootContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.Wait;

import java.time.Duration;
import java.util.Map;

public class SpringBootContainerManager {

    private GenericSpringBootContainer container;
    private String image;
    private Map<String, String> springProps;
    private Network network;
    private String healthPath = "/api/health";

    public SpringBootContainerManager withImage(String image) {
        this.image = image;
        return this;
    }

    public SpringBootContainerManager withSpringProps(Map<String, String> props) {
        this.springProps = props;
        return this;
    }

    public SpringBootContainerManager withNetwork(Network network) {
        this.network = network;
        return this;
    }

    public SpringBootContainerManager withHealthEndpoint(String path) {
        this.healthPath = path;
        return this;
    }

    public void start() {
        container = new GenericSpringBootContainer(image, springProps)
                .withNetwork(network)
                .waitingFor(
                        Wait.forHttp(healthPath)
                                .forStatusCode(200)
                                .withStartupTimeout(Duration.ofSeconds(30))
                );
        container.start();
    }

    public String getBaseUrl() {
        return container.getBaseUrl();
    }

    public void stop() {
        if (container != null && container.isRunning()) {
            container.stop();
        }
    }

    public GenericSpringBootContainer getContainer() {
        return container;
    }
}
