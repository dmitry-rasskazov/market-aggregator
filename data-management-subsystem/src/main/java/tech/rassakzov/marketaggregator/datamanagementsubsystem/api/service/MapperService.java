package tech.rassakzov.marketaggregator.datamanagementsubsystem.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.entities.Feedback;

@ApplicationScoped
public class MapperService
{
    public Feedback feedbackToEntity(tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Feedback feedback)
    {
        var result = new Feedback();

        result.setEmail(feedback.getEmail());
        result.setDescription(feedback.getDescription());
        result.setFullName(feedback.getFullName());

        return result;
    }
}
