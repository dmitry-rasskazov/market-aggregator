package tech.rasskazov.marketaggregator.datamanagementsubsystem.api;

import jakarta.enterprise.context.ApplicationScoped;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.entities.*;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.support.Filter;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.support.Pagination;
import tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.support.Sort;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class MapperService
{
    public Product productToEntity(tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Product product)
    {
        var entity = new Product();

        entity.setId(UUID.randomUUID());
        entity.setCategory(this.categoryToEntity(product.getCategory()));
        entity.setVendor(this.vendorToEntity(product.getVendor()));
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setMeasurement(product.getMeasurement());
        entity.setQuantity(product.getQuantity());
        entity.setSaledQuantity(product.getSaledQuantity());
        entity.setCharacteristics(this.characteristicsToMap(product.getCharacteristics()));
        entity.setRating(product.getRating());
        entity.setLink(product.getLink());
        entity.setImages(product.getImages().stream().map(this::imageToEntity).toList());

        return entity;
    }

    public tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Product productToApiModel(Product entity)
    {
        var product = new tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Product();

        product.setId(entity.getId().toString());
        product.setCategory(this.categoryToApiModel(entity.getCategory()));
        product.setVendor(this.vendorToApiModel(entity.getVendor()));
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setMeasurement(entity.getMeasurement());
        product.setQuantity(entity.getQuantity());
        product.setSaledQuantity(entity.getSaledQuantity());
        product.setRating(entity.getRating());
        product.setLink(entity.getLink());
        product.setImages(entity.getImages().stream().map(this::imageToApiModel).toList());

        return product;
    }


    public Feedback feedbackToEntity(tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Feedback feedback)
    {
        var result = new Feedback();

        result.setId(UUID.randomUUID());
        result.setEmail(feedback.getEmail());
        result.setDescription(feedback.getDescription());
        result.setFullName(feedback.getFullName());

        return result;
    }

    public tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Feedback feedbackToApiModel(Feedback feedback)
    {
        var result = new tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Feedback();

        result.setId(feedback.getId().toString());
        result.setFullName(feedback.getFullName());
        result.setDescription(feedback.getDescription());

        return result;
    }

    public Category categoryToEntity(tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.ProductCategory category)
    {
        return null;
    }

    public Vendor vendorToEntity(tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.ProductVendor vendor)
    {
        return null;
    }

    public Map<String, Object> characteristicsToMap(List<tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Characteristic> characteristics)
    {
        return null;
    }

    public ProductImage imageToEntity(tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Image image)
    {
        return null;
    }

    public tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.ProductCategory categoryToApiModel(Category category)
    {
        return null;
    }

    public tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.ProductVendor vendorToApiModel(Vendor vendor)
    {
        return null;
    }

    public List<String> characteristicsToString(Map<String, Object> characteristicsMap)
    {
        return null;
    }

    public tech.rasskazov.marketaggregator.datamanagementsubsystem.generated.model.Image imageToApiModel( ProductImage image)
    {
        return null;
    }

    public List<Filter> parseFilters(String filters)
    {
        return null;
    }

    public List<Sort> parseSorts(String filters)
    {
        return null;
    }

    public Pagination parsePagination(Integer limit, Integer offset)
    {
        return null;
    }
}
