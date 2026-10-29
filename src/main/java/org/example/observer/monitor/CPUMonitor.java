package org.example.observer.monitor;

import org.example.observer.event.UsageEvent;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CPUMonitor {

    private final List<CPUUsageObserver> observers = new ArrayList<>();

    public void addObserver(CPUUsageObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CPUUsageObserver observer) {
        observers.remove(observer);
    }

    public void publishUsage(double usage) {
        UsageEvent event = new UsageEvent(usage, Instant.now());
        for (CPUUsageObserver observer : observers) {
            observer.onUsageChanged(event);
        }
    }
}
