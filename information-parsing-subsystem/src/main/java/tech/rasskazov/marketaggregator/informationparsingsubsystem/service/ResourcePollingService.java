package tech.rasskazov.marketaggregator.informationparsingsubsystem.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class ResourcePollingService
{
    private static final String RESOURCE_ADAPTATION_SUBSYSTEM_URL = "http://resource-adaptations-subsystem:8080/api";

    private static final String DATA_MANAGEMENT_SUBSYSTEM_URL = "http://resource-adaptations-subsystem:8080/api";

    private final Client client;

    public ResourcePollingService()
    {
        this.client = ClientBuilder.newClient();
    }

    public void resourcePull()
    {
        try {
            var resourceAdaptationSubsystemTarget = this.client.target(RESOURCE_ADAPTATION_SUBSYSTEM_URL);

            Response response = resourceAdaptationSubsystemTarget
                    .path("productList")
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get();
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}
