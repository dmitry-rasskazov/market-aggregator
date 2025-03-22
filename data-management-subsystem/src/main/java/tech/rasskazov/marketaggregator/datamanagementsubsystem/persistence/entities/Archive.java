package tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Archive implements Serializable
{
    @Id
    private UUID id;

    @ManyToOne
    private Product product;

    private int price;

    private int availableQuantity;

    private int saledQuantity;

    private LocalDateTime timeStamp;
}
