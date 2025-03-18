package tech.rasskazov.marketaggregator.dataaccesssubsystem.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.api.MapperService;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.api.NotFoundException;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.api.impl.ProductApiServiceImpl;

@ApplicationScoped
@Specializes
public class ProductApiService extends ProductApiServiceImpl
{
    private final MapperService responseCreator;

    @Inject
    public ProductApiService(MapperService responseCreator)
    {
        this.responseCreator = responseCreator;
    }

    @Override
    public Response productGet(String productId, SecurityContext securityContext) throws NotFoundException
    {
        try {
            return this.responseCreator.createSuccessResponse();
        } catch (Exception exception) {
            return this.responseCreator.createBadRequestError("ProductId is incorrect");
        }
    }
}
