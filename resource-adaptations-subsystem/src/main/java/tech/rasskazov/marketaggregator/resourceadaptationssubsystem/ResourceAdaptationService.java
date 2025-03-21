package tech.rasskazov.marketaggregator.resourceadaptationssubsystem;

import jakarta.enterprise.context.ApplicationScoped;
import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.generated.model.Product;
import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.generated.model.ProductCategory;
import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.generated.model.ProductVendor;
import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.generated.model.Image;
import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.generated.model.VendorImage;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@ApplicationScoped
public class ResourceAdaptationService
{
    public List<Product> extractProductList()
    {
        return Stream.generate(this::extractProduct).limit(10).toList();
    }

    public Product extractProduct()
    {
        return this.extractProductBySourceId(UUID.randomUUID().toString());
    }

    public Product extractProductBySourceId(String sourceId)
    {
        var product = new Product();
        var productImage = new Image();
        var vendorImage = new VendorImage();
        var category = new ProductCategory();
        var vendor = new ProductVendor();
        category.setId(UUID.randomUUID().toString());
        category.setName("Товары для ремонта!");

        vendor.setId(UUID.randomUUID().toString());
        vendor.setName("Поставщик");
        vendor.setLink("https://localhost:8080/api/search");
        vendor.setImage(vendorImage);

        productImage.setId(UUID.randomUUID().toString());
        productImage.setLink("https://localhost:8080/api/search");

        product.setSourceId(sourceId);
        product.setCategory(category);
        product.setImages(List.of(productImage));
        product.setVendor(vendor);
        product.setPrice(1000);
        product.setQuantity(20);
        product.setSaledQuantity(2500);

        return product;
    }
}
