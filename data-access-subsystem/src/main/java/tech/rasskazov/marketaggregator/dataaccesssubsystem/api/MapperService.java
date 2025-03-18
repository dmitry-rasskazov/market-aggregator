package tech.rasskazov.marketaggregator.dataaccesssubsystem.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.model.Product;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.model.ResultResponse;

@ApplicationScoped
public class MapperService
{
    public Response createSuccessResponse()
    {
        return this.creeateResponse(Response.Status.OK, new Product());
    }

    public Response createInternalServerError(String message)
    {
        var result =  new ResultResponse();
        result.setErrorCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        result.setErrorMessage(message);

        return this.creeateResponse(Response.Status.INTERNAL_SERVER_ERROR, result);
    }

    public Response createBadRequestError(String message)
    {
        var result =  new ResultResponse();
        result.setErrorCode(Response.Status.BAD_REQUEST.getStatusCode());
        result.setErrorMessage(message);

        return this.creeateResponse(Response.Status.BAD_REQUEST, result);
    }

    private Response creeateResponse(Response.Status status, Object entity)
    {
        return Response.status(status).entity(entity).build();
    }
}
