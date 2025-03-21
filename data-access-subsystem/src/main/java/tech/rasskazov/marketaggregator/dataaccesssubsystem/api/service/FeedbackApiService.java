package tech.rasskazov.marketaggregator.dataaccesssubsystem.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import org.apache.commons.text.StringEscapeUtils;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.api.impl.FeedbackApiServiceImpl;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.model.Feedback;

import java.util.UUID;

@ApplicationScoped
@Specializes
public class FeedbackApiService extends FeedbackApiServiceImpl
{
    private static final String DATA_MANAGEMENT_FEEDBACK_URL = "http://data-management-subsystem:8080/api/feedback";

    private final Client client;

    public FeedbackApiService()
    {
        this.client = ClientBuilder.newClient();
    }

    @Override
    public Response feedbackPost(Feedback feedback, SecurityContext securityContext)
    {
        feedback.setId(UUID.randomUUID().toString());
        feedback.setEmail(StringEscapeUtils.escapeJava(feedback.getEmail()));
        feedback.setDescription(StringEscapeUtils.escapeJava(feedback.getDescription()));
        feedback.setFullName(StringEscapeUtils.escapeJava(feedback.getFullName()));
        feedback.setProductId(StringEscapeUtils.escapeJava(feedback.getProductId()));

        return this.client.target(DATA_MANAGEMENT_FEEDBACK_URL)
                .request()
                .post(Entity.entity(feedback, MediaType.APPLICATION_JSON_TYPE));
    }
}
