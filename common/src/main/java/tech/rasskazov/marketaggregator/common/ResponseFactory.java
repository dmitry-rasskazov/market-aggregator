package tech.rasskazov.marketaggregator.common;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tech.rasskazov.marketaggregator.common.generated.model.ResultResponse;

public class ResponseFactory
{
    public <X> Response createSuccessResponse(X responseDto)
    {
        return this.creeateResponse(Response.Status.OK, responseDto);
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
        return Response.status(status).entity(entity).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
