package com.testing.containers.providers;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Map;

public class GenericSpringBootContainer extends GenericContainer<GenericSpringBootContainer> {

    public GenericSpringBootContainer(String image, Map<String, String> springProps) {
        super(DockerImageName.parse(image));
        addExposedPort(8080);

        springProps.forEach((k, v) -> {
            String envKey = "SPRING_" + k.toUpperCase().replace(".", "_");
            addEnv(envKey, v);
        });

        waitingFor(org.testcontainers.containers.wait.strategy.Wait.forHttp("/actuator/health").forStatusCode(200));
    }

    public String getBaseUrl() {
        return "http://" + getHost() + ":" + getMappedPort(8080);
    }
}
