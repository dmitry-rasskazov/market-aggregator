package tech.rasskazov.marketaggregator.resourceadaptationssubsystem;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.generated.model.Product;

import java.util.List;

@ApplicationScoped
public class ResourceAdaptationService
{
    private final AdapterProvider adapterProvider;

    @Inject
    public ResourceAdaptationService(AdapterProvider adapterProvider)
    {
        this.adapterProvider = adapterProvider;
    }

    public List<Product> extractProductList()
    {
        return this.adapterProvider.nextAdapter().extractProductList();
    }

    public Product extractProduct()
    {
        return this.adapterProvider.nextAdapter().extractProduct();
    }
}
