package org.example.observer.monitor;

import org.example.observer.event.UsageEvent;
import org.example.observer.source.CPUUsage;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CPUMonitor {

    private final List<CPUUsageObserver> observers = new CopyOnWriteArrayList<>();
    private final CPUUsage cpuUsage;
    private volatile boolean running = false;
    private Thread worker;

    public CPUMonitor(CPUUsage cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public void addObserver(CPUUsageObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CPUUsageObserver observer) {
        observers.remove(observer);
    }

    public void publishUsage(double usage) {
        UsageEvent event = new UsageEvent(usage, Instant.now());

        for (CPUUsageObserver observer : observers) {
            try {
                observer.onUsageChanged(event);
            } catch (Exception e) {
                System.out.println("Что то не так " + e.getMessage());
            }
        }

    }

    public void start() {
        if (running) {
            return;
        }
        running = true;
        worker = new Thread(() -> {
            while (running) {
                publishUsage(cpuUsage.getUsage());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        worker.start();
    }

    public void stop() {
        running = false;
        if (worker != null) {
            worker.interrupt();
        }
    }
}
