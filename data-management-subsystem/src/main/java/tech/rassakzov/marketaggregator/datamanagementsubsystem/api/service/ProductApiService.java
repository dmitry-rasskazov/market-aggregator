package tech.rassakzov.marketaggregator.datamanagementsubsystem.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.api.MapperService;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.component.ResponseFactory;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.repo.ProductRepository;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.api.impl.ProductApiServiceImpl;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.ResultResponse;

import java.util.UUID;

@Slf4j
@ApplicationScoped
@Specializes
public class ProductApiService extends ProductApiServiceImpl
{
    private final ProductRepository productRepository;

    private final ResponseFactory responseFactory;

    private final MapperService mapperService;

    @Inject
    public ProductApiService(
            ProductRepository productRepository,
            ResponseFactory responseFactory,
            MapperService mapperService
    ) {
        this.productRepository = productRepository;
        this.responseFactory = responseFactory;
        this.mapperService = mapperService;
    }

    @Override
    public Response productGet(String productId, SecurityContext securityContext)
    {
        try {
            return this.responseFactory.createSuccessResponse(
                    this.productRepository.findById(UUID.fromString(productId))
                            .map((this.mapperService::productToApiModel))
                            .orElse(null)
            );
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return this.responseFactory.createInternalServerError("Fetch product failed.");
        }
    }

    @Override
    public Response productPost(tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Product product, SecurityContext securityContext)
    {
        try {
            return this.responseFactory.createSuccessResponse(new ResultResponse());
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return this.responseFactory.createBadRequestError("Fail mutation product!");
        }
    }
}
