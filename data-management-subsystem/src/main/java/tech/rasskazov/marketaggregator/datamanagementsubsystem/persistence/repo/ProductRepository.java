package tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.repo;

import jakarta.enterprise.context.ApplicationScoped;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.entities.Product;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.support.Filter;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.support.Pagination;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.support.Sort;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ProductRepository extends AbstractRepository<Product, UUID>
{
    public Optional<Product> findBySourceId(String sourceId)
    {
        return Optional.ofNullable(this.em.createQuery("SELECT p" +
                " FROM Product p " +
                "inner join p.category " +
                "inner join p.vendor " +
                "inner join p.images" +
                " WHERE p.sourceId = :sourceId", Product.class)
                .setParameter("sourceId", sourceId)
                .getSingleResult());
    }

    public Collection<Product> findBySearchAndFiltersAndSorting(String text, List<Filter> filters, List<Sort> sorts, Pagination pagination)
    {
        Collection<Product> results;

        if(text != null && !text.isEmpty())
        {
            results = this.em.createQuery("SELECT p" +
                    " FROM Product p " +
                    "inner join p.category " +
                    "inner join p.vendor " +
                    "inner join p.images" +
                    " WHERE p.name LIKE :text", Product.class)
                    .setParameter("text", "%" + text + "%")
                    .getResultList();

        } else {
            results = this.em.createQuery("SELECT p" +
                            " FROM Product p " +
                            "inner join p.category " +
                            "inner join p.vendor " +
                            "inner join p.images", Product.class)
                    .getResultList();
        }

        return results;
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    protected UUID getKey(Product entity) {
        return entity.getId();
    }
}
