package tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
public class Product implements Serializable
{
    @Id
    private UUID id;

    @ManyToOne
    @Nullable
    private Category category;

    @ManyToOne
    @Nullable
    private Vendor vendor;

    private String sourceId;

    private String name;

    private String description;

    private int price;

    private int quantity;

    private int saledQuantity;

    private String characteristics;

    private int rating;

    private String link;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @OrderColumn(name = "serial_number")
    private Collection<ProductImage> images;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Collection<Feedback> feedback;

    private LocalDateTime timeStamp;
}
