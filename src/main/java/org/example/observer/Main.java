package org.example.observer;

import org.example.observer.monitor.CPUMonitor;
import org.example.observer.subscriber.UsageLog;

public class Main {
    public static void main(String[] args) {
        CPUMonitor monitor = new CPUMonitor();
        UsageLog log = new UsageLog();
        monitor.addObserver(log);
        monitor.publishUsage(50);
        monitor.publishUsage(90);
        monitor.removeObserver(log);
        monitor.publishUsage(20);
    }
}
