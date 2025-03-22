package tech.rasskazov.marketaggregator.resourceadaptationssubsystem;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;
import tech.rasskazov.marketaggregator.resourceadaptationssubsystem.generated.model.Product;

import java.util.List;

@NoArgsConstructor
@ApplicationScoped
public class ResourceAdaptationService
{
    @Inject
    private AdapterProvider adapterProvider;

    public List<Product> extractProductList()
    {
        return this.adapterProvider.nextAdapter().extractProductList();
    }

    public Product extractProduct()
    {
        return this.adapterProvider.nextAdapter().extractProduct();
    }
}
