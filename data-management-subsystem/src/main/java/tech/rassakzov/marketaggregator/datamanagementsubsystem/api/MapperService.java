package tech.rassakzov.marketaggregator.datamanagementsubsystem.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.entities.Feedback;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.ResultResponse;

@ApplicationScoped
public class MapperService
{
    public Feedback feedbackToEntity(tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Feedback feedback)
    {
        var result = new Feedback();

        return null;
    }

    public <X> Response createSuccessResponse(X object)
    {
        return this.creeateResponse(Response.Status.OK, object);
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
