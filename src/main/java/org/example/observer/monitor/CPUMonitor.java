package org.example.observer.monitor;

import java.util.ArrayList;

public class CPUMonitor {

    private final ArrayList<CPUUsageObserver> observers = new ArrayList<>();

    public void addObserver(CPUUsageObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CPUUsageObserver observer) {
        observers.remove(observer);
    }
}
