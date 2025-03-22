package tech.rasskazov.marketaggregator.datamanagementsubsystem.persistence.support;

import lombok.Getter;

@Getter
public class Sort
{
    private final String field;

    private final boolean ascending;

    public Sort(String field, boolean ascending)
    {
        this.field = field;
        this.ascending = ascending;
    }
}
