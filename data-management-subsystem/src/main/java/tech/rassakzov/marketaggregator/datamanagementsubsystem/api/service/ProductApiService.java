package tech.rassakzov.marketaggregator.datamanagementsubsystem.api.service;

import jakarta.enterprise.inject.Specializes;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.repo.ProductRepository;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.api.impl.ProductApiServiceImpl;
import tech.rasskazov.marketaggregator.utils.ResponceCreator;

import java.util.UUID;

@Specializes
public class ProductApiService extends ProductApiServiceImpl
{
    @Inject
    private ProductRepository productRepository;

    @Inject
    private ResponceCreator responceCreator;

    @Override
    public Response productGet(String productId, SecurityContext securityContext)
    {
        return this.responceCreator.createSuccessResponse(this.productRepository.findById(UUID.fromString(productId)).orElse(null));
    }
}
