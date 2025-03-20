package tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
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

    private String measurement;

    private int quantity;

    private int saledQuantity;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> characteristics;

    private int rating;

    private String link;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @OrderColumn(name = "serial_number")
    private Collection<ProductImage> images;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Collection<Feedback> feedback;

    private LocalDateTime timeStamp;
}
