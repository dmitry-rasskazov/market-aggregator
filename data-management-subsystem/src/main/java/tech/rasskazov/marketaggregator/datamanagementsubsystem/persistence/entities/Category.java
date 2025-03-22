package tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
public class Category implements Serializable
{
    @Id
    private UUID id;

    private String name;

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="category")
    private Collection<Product> products;
}
