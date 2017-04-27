package com.ambuj;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Aj on 25-04-2017.
 */
@Service
public class ScheduledMetricsExample {

    private final CounterService counterService;

    public ScheduledMetricsExample(CounterService counterService){
        this.counterService = counterService;
    }

    @Scheduled(fixedRate = 60000L)
    public void scheduledMethod() {
        this.counterService.increment("custom.metrics.value");
    }

}
