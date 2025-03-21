package tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.repo;

import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.entities.Archive;

import java.util.UUID;

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
