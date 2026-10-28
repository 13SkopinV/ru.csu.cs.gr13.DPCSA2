package org.example.observer.subscriber;

import org.example.observer.event.UsageEvent;
import org.example.observer.monitor.CPUUsageObserver;

public class UsageLog implements CPUUsageObserver {

    @Override
    public void onUsageChanged(UsageEvent usageEvent) {
        System.out.println("Нагрузка: " + usageEvent.getUsage() + " Замер: " + usageEvent.getTimestamp());
    }
}
