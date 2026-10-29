package org.example.observer.subscriber;

import org.example.observer.event.UsageEvent;
import org.example.observer.monitor.CPUUsageObserver;

public class UsageNotification implements CPUUsageObserver {
    private boolean failing = false;

    public void setFailing(boolean failing) {
        this.failing = failing;
    }

    @Override
    public void onUsageChanged(UsageEvent usageEvent) {
        if (failing) {
            throw new RuntimeException("Внешний сервер не доступен");
        }
        System.out.println("Отправка во внешний сервис: нагрузка " + usageEvent.getUsage() + " Время " + usageEvent.getTimestamp());
    }
}
