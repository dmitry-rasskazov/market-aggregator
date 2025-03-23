package tech.rasskazov.marketaggregator.informationparsingsubsystem.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class Scheduler
{
    @Inject
    private ResourcePollingService resourcePollingService;

    public Scheduler()
    {
        Executors.newScheduledThreadPool(Runtime.getRuntime()
                .availableProcessors())
                .scheduleWithFixedDelay(this.resourcePollingService::resourcePull, 0, 2, TimeUnit.HOURS);
    }
}
