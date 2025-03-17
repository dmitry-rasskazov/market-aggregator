package tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.support.ProductImageId;

import java.io.Serializable;

@Entity
@Data
public class ProductImage implements Serializable
{
    @EmbeddedId
    private ProductImageId productImageId;

    private short serialNumber;
}
