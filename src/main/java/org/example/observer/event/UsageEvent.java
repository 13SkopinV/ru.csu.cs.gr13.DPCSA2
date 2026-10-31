package org.example.observer.event;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UsageEvent {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

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

    public String getFormattedUsage() {
        return String.format(Locale.forLanguageTag("ru"), "%.2f %%", usage);
    }

    public String getFormattedTime() {
        return TIME_FORMAT.format(timestamp);
    }
}