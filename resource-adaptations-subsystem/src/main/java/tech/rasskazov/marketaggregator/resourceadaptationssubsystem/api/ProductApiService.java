package tech.rasskazov.marketaggregator.resourceadaptationssubsystem.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.ResourceAdaptationService;
import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.generated.model.ResultResponse;
import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.generated.model.ResultResponseResult;
import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.generated.api.impl.ProductApiServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@Specializes
public class ProductApiService extends ProductApiServiceImpl
{
    private final ResourceAdaptationService resourceAdaptationService;

    @Inject
    public ProductApiService(ResourceAdaptationService resourceAdaptationService)
    {
        this.resourceAdaptationService = resourceAdaptationService;
    }

    @Override
    public Response productListGet(SecurityContext securityContext)
    {
        var result = new ResultResponse();
        var resultResponseResult = new ResultResponseResult();
        resultResponseResult.setResults(this.resourceAdaptationService.extractProductList());
        result.setErrorCode(200);
        result.setErrorMessage("OK");
        result.setResult(resultResponseResult);

        return Response.ok().entity(result).build();
    }

    @Override
    public Response productGet(String sourceId, SecurityContext securityContext)
    {
        return Response.ok().entity(this.resourceAdaptationService.extractProduct()).build();
    }
}
