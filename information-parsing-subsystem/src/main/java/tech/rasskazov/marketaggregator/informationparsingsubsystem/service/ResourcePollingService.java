package tech.rasskazov.marketaggregator.informationparsingsubsystem.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

@ApplicationScoped
public class ResourcePollingService
{
    private final Client client;

    public ResourcePollingService()
    {
        this.client = ClientBuilder.newClient();
    }


}
