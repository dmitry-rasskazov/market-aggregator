package tech.rasskazov.marketaggregator.dataaccesssubsystem.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.component.ResponseFactory;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.api.NotFoundException;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.api.impl.ProductApiServiceImpl;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.model.ResultResponse;

@ApplicationScoped
@Specializes
@Slf4j
public class ProductApiService extends ProductApiServiceImpl
{
    private static final String DATA_MANAGEMENT_PRODUCT_URL = "http://data-management-subsystem:8080/api/product";

    private final Client client;

    private final ResponseFactory responseFactory;

    @Inject
    public ProductApiService(ResponseFactory responseFactory)
    {
        this.client = ClientBuilder.newClient();
        this.responseFactory = responseFactory;
    }

    @Override
    public Response productGet(String productId, SecurityContext securityContext) throws NotFoundException
    {
        var targetProductById = this.client.target(DATA_MANAGEMENT_PRODUCT_URL);

        log.info("Запрос с параметром: " + productId);

        try {
            var result = targetProductById.queryParam("productId", productId).request(MediaType.APPLICATION_JSON_TYPE).get(ResultResponse.class);

            return this.responseFactory.createSuccessResponse(result);
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return this.responseFactory.createInternalServerError("Extracting product error!");
        }
    }
}
