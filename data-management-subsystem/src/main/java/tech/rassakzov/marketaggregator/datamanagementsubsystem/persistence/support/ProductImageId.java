package tech.rassakzov.marketaggregator.datamanagementsubsystem.persistence.support;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductImageId implements Serializable
{
    private UUID productId;

    private UUID imageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        var that = (ProductImageId) o;
        return Objects.equals(this.productId, that.productId) &&
                Objects.equals(this.imageId, that.imageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.productId, this.imageId);
    }
}
