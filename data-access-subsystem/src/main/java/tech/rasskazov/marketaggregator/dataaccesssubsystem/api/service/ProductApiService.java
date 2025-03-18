package tech.rasskazov.marketaggregator.dataaccesssubsystem.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.api.NotFoundException;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.api.impl.ProductApiServiceImpl;

@ApplicationScoped
@Specializes
@Slf4j
public class ProductApiService extends ProductApiServiceImpl
{
    private static final String DATA_MANAGEMENT_PRODUCT_URL = "http://data-management-subsystem:8080/api/product";

    private final Client client;

    public ProductApiService()
    {
        this.client = ClientBuilder.newClient();
    }

    @Override
    public Response productGet(String productId, SecurityContext securityContext) throws NotFoundException
    {
        log.info("Test: " + productId);
        return this.client.target(DATA_MANAGEMENT_PRODUCT_URL).queryParam("productId", productId).request().get();
    }
}
