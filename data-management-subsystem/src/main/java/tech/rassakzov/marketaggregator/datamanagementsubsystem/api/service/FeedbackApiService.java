package tech.rassakzov.marketaggregator.datamanagementsubsystem.api.service;

import jakarta.enterprise.inject.Specializes;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.api.MapperService;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.repo.FeedbackRepository;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.api.impl.FeedbackApiServiceImpl;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Feedback;

import java.util.UUID;

@Specializes
@Slf4j
public class FeedbackApiService extends FeedbackApiServiceImpl
{
    @Inject
    private FeedbackRepository feedbackRepository;

    @Inject
    private MapperService mapperService;

    @Override
    public Response feedbackPost(Feedback feedback, SecurityContext securityContext)
    {
        try {
            var storedFeedback = this.feedbackRepository.findByProductIdAndEmail(UUID.fromString(feedback.getProductId()), feedback.getEmail());

            if(storedFeedback.isEmpty()) {
                var entity = this.mapperService.feedbackToEntity(feedback);

                this.feedbackRepository.save(entity);

                feedback.setId(entity.getId().toString());
            } else {
                return this.mapperService.createBadRequestError("Feedback already exist!");
            }
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return this.mapperService.createInternalServerError("Failed store feedback");
        }

        return this.mapperService.createSuccessResponse(feedback);
    }
}
