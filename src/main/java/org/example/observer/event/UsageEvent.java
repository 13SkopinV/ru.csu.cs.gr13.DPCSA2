package org.example.observer.event;

import java.time.Instant;

public class UsageEvent {
    private final double usage;
    private final Instant timestamp;

    public UsageEvent(double usage, Instant timestamp) {
        this.usage = usage;
        this.timestamp = timestamp;
    }

    public double getUsage() {
        return usage;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}