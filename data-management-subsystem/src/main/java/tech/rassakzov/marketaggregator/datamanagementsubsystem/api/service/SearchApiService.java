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

@Slf4j
@ApplicationScoped
@Specializes
public class SearchApiService extends tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.api.impl.SearchApiServiceImpl
{
    private final ProductRepository productRepository;

    private final ResponseFactory responseFactory;

    private final MapperService mapperService;

    @Inject
    public SearchApiService(
            ProductRepository productRepository,
            ResponseFactory responseFactory,
            MapperService mapperService
    ) {
        this.productRepository = productRepository;
        this.responseFactory = responseFactory;
        this.mapperService = mapperService;
    }

    @Override
    public Response searchGet(String text, String filters, String sorts, Integer limit, Integer offset, SecurityContext securityContext)
    {
        try {
            return this.responseFactory.createSuccessResponse(
                    this.productRepository.findBySearchAndFiltersAndSorting(
                                    text,
                                    this.mapperService.parseFilters(filters),
                                    this.mapperService.parseSorts(sorts),
                                    this.mapperService.parsePagination(limit, offset)
                            )
                            .stream()
                            .map(this.mapperService::productToApiModel)
                            .toList()
            );
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return this.responseFactory.createInternalServerError("Search failed.");
        }
    }
}
