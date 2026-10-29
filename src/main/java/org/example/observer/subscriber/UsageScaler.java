package org.example.observer.subscriber;

import org.example.observer.event.UsageEvent;
import org.example.observer.monitor.CPUUsageObserver;

public class UsageScaler implements CPUUsageObserver {
    private static final double lowThreshold = 30;
    private static final double highThreshold = 75;

    @Override
    public void onUsageChanged(UsageEvent usageEvent) {
        if (usageEvent.getUsage() < lowThreshold) {
            System.out.println("Нужно убрать ядро");
        } else if (usageEvent.getUsage() > highThreshold){
            System.out.println("Нужно добавить ядро");
        }
    }
}
