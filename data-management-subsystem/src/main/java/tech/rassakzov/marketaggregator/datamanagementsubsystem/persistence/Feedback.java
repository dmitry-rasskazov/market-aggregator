package tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class Feedback implements Serializable
{
    @Id
    private UUID id;

    @ManyToOne
    private Product product;

    private String fullName;

    private String email;

    private String description;
}
