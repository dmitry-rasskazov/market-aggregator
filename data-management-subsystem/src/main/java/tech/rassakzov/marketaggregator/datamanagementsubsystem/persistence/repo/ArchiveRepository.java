package tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.repo;

import jakarta.enterprise.context.ApplicationScoped;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.entities.Archive;

import java.util.UUID;

@ApplicationScoped
public class ArchiveRepository extends AbstractRepository<Archive, UUID>
{
    @Override
    protected Class<Archive> getEntityClass() {
        return Archive.class;
    }

    @Override
    protected UUID getKey(Archive entity) {
        return entity.getId();
    }
}
