package tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.repo;

import jakarta.enterprise.context.ApplicationScoped;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.entities.Feedback;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class FeedbackRepository extends AbstractRepository<Feedback, UUID>
{
    public Optional<Feedback> findByProductIdAndEmail(UUID productId, String email)
    {
        return Optional.ofNullable(
                this.em
                        .createQuery("SELECT f " +
                                "FROM Feedback f " +
                                "INNER JOIN f.product p " +
                                "WHERE p.id = :productId AND f.email = :email",
                                Feedback.class)
                        .setParameter("productId", productId)
                        .setParameter("email", email)
                        .getSingleResult()
        );
    }

    @Override
    protected Class<Feedback> getEntityClass() {
        return Feedback.class;
    }

    @Override
    protected UUID getKey(Feedback entity) {
        return entity.getId();
    }
}
