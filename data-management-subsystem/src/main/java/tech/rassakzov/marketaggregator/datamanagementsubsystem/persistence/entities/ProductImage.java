package tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.entities.support.ProductImageId;

import java.io.Serializable;

@Entity
@Table(name = "product_image")
@Data
public class ProductImage implements Serializable
{
    @EmbeddedId
    private ProductImageId productImageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("imageId")
    private Image image;

    @Column(name = "serial_number")
    private short serialNumber;
}
