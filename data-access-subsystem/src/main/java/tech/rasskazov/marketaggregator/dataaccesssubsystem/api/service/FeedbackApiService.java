package tech.rasskazov.marketaggregator.dataaccesssubsystem.api.service;

import jakarta.enterprise.inject.Specializes;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.api.impl.FeedbackApiServiceImpl;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.model.Feedback;
import tech.rasskazov.marketaggregator.common.ResponseFactory;

@Specializes
public class FeedbackApiService extends FeedbackApiServiceImpl
{
    private static final String DATA_MANAGEMENT_FEEDBACK_URL = "http://data-management-subsystem:8080/api/feedback";

    private final Client client;

    @Inject
    public FeedbackApiService(ResponseFactory mapperService)
    {
        this.client = ClientBuilder.newClient();
    }

    @Override
    public Response feedbackPost(Feedback feedback, SecurityContext securityContext)
    {
        return this.client.target(DATA_MANAGEMENT_FEEDBACK_URL)
                .request()
                .post(Entity.entity(feedback, MediaType.APPLICATION_JSON_TYPE));
    }
}
