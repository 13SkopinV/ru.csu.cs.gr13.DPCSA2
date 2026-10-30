package org.example.observer.subscriber;

import org.example.observer.event.UsageEvent;
import org.example.observer.monitor.CPUUsageObserver;
import org.example.observer.source.CPUUsage;

public class UsageScaler implements CPUUsageObserver {
    private static final double lowThreshold = 30;
    private static final double highThreshold = 75;
    private final CPUUsage cpuUsage;

    public UsageScaler(CPUUsage cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    @Override
    public void onUsageChanged(UsageEvent usageEvent) {
        if (usageEvent.getUsage() < lowThreshold) {
            cpuUsage.removeCore();
            System.out.println("Ядро добавлено, текущее количество: " + cpuUsage.getCoreCount());
        } else if (usageEvent.getUsage() > highThreshold){
            cpuUsage.addCore();
            System.out.println("Ядро убрано, текущее количество: " + cpuUsage.getCoreCount());
        }
    }
}
