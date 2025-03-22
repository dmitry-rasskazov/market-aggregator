package tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class Image implements Serializable
{
    @Id
    private UUID id;

    private String link;
}
