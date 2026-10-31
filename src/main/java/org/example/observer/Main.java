package org.example.observer;

import org.example.observer.monitor.CPUMonitor;
import org.example.observer.source.CPUUsage;
import org.example.observer.subscriber.UsageLog;
import org.example.observer.subscriber.UsageNotification;
import org.example.observer.subscriber.UsageScaler;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        CPUUsage cpu = new CPUUsage(2, 120);
        CPUMonitor monitor = new CPUMonitor(cpu);
        UsageLog log = new UsageLog();
        UsageNotification server = new UsageNotification();

        monitor.addObserver(log);
        monitor.addObserver(server);
        monitor.addObserver(new UsageScaler(cpu));

        monitor.start();
        Thread.sleep(5000);
        monitor.removeObserver(log);
        Thread.sleep(3000);
        server.setFailing(true);
        Thread.sleep(3000);
        monitor.stop();
    }
}
