package tech.rasskazov.marketaggregator.resourceadaptationssubsystem;

import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.generated.model.Product;

import java.util.List;

public interface ResourceAdapter
{
    List<Product> extractProductList();

    Product extractProduct();

    Product extractProductBySourceId(String sourceId);
}
