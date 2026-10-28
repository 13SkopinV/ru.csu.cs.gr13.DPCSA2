package org.example.observer.monitor;

import org.example.observer.event.UsageEvent;

public interface CPUUsageObserver {
    void onUsageChanged(UsageEvent usageEvent);

}

