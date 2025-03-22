package tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

public abstract class AbstractRepository<T, K>
{
    @PersistenceContext
    protected EntityManager em;

    public Optional<T> findById(K id)
    {
        return Optional.ofNullable(this.em.find(this.getEntityClass(), id));
    }

    public void save(T entity)
    {
        if(this.getKey(entity) == null) {
            this.em.persist(entity);
        } else {
            this.em.merge(entity);
        }
    }

    public void delete(T entity)
    {
        if(this.em.contains(entity)) {
            this.em.remove(entity);
        } else {
            this.em.merge(entity);
        }
    }

    public void create(T entity)
    {
        this.em.persist(entity);
    }

    public void update(T entity)
    {
        this.em.merge(entity);
    }

    protected abstract Class<T> getEntityClass();

    protected abstract K getKey(T entity);
}
