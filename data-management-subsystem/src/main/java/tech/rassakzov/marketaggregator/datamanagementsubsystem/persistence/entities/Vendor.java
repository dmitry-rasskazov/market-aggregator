package tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
public class Vendor implements Serializable
{
    @Id
    private UUID id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vendor")
    private Collection<Product> product;

    @Nullable
    private String link;

    @OneToOne(cascade = CascadeType.ALL)
    @Nullable
    private Image image;
}
