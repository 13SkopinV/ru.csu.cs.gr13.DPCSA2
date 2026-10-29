package org.example.observer;

import org.example.observer.monitor.CPUMonitor;
import org.example.observer.subscriber.UsageLog;
import org.example.observer.subscriber.UsageNotification;
import org.example.observer.subscriber.UsageScaler;


public class Main {
    public static void main(String[] args) {
        CPUMonitor monitor = new CPUMonitor();
        UsageLog log = new UsageLog();
        UsageNotification server = new UsageNotification();
        UsageScaler scaler = new UsageScaler();


        monitor.addObserver(log);
        monitor.addObserver(server);
        monitor.addObserver(scaler);

        monitor.publishUsage(50);
        monitor.publishUsage(90);
        monitor.publishUsage(20);
        monitor.publishUsage(30);
        monitor.publishUsage(75);
        server.setFailing(true);
        monitor.publishUsage(90);
        monitor.removeObserver(log);
        monitor.publishUsage(100);


    }
}
