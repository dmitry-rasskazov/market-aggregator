package tech.rassakzov.marketaggregator.datamanagementsubsystem.api.service;

import jakarta.enterprise.inject.Specializes;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.api.MapperService;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.repo.FeedbackRepository;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.repo.ProductRepository;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.api.impl.FeedbackApiServiceImpl;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Feedback;
import tech.rasskazov.marketaggregator.common.ResponseFactory;

import java.util.UUID;

@Specializes
@Slf4j
public class FeedbackApiService extends FeedbackApiServiceImpl
{
    @Inject
    private FeedbackRepository feedbackRepository;

    @Inject
    private ProductRepository productRepository;

    @Inject
    private ResponseFactory responceCreator;

    @Inject
    private MapperService mapperService;

    @Override
    public Response feedbackPost(Feedback feedback, SecurityContext securityContext)
    {
        try {
            var productId = UUID.fromString(feedback.getProductId());
            var product = this.productRepository.findById(productId);

            if(product.isEmpty()) {
                return this.responceCreator.createBadRequestError("ProductId is incorrect!");
            }

            var storedFeedback = this.feedbackRepository.findByProductIdAndEmail(productId, feedback.getEmail());

            if(storedFeedback.isEmpty()) {
                var entity = this.mapperService.feedbackToEntity(feedback);
                entity.setProduct(product.get());
                entity.setId(UUID.randomUUID());

                this.feedbackRepository.save(entity);

                feedback.setId(entity.getId().toString());
            } else {
                return this.responceCreator.createBadRequestError("Feedback already exist!");
            }
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return this.responceCreator.createInternalServerError("Failed store feedback");
        }

        return this.responceCreator.createSuccessResponse(feedback);
    }
}
