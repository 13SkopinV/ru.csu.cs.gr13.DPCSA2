package org.example.observer.source;

import java.util.Random;

public class CPUUsage {
    private volatile int coreCount;
    private double workload;
    Random random = new Random();

    public CPUUsage(int coreCount, double workload) {
        if (coreCount < 1) {
            throw new IllegalArgumentException("Ядер должно быть минимум одно");
        }
        this.coreCount = coreCount;
        this.workload = workload;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public void addCore() {
        coreCount++;
    }

    public void removeCore() {
        if (coreCount > 1) {
            coreCount--;
        }
    }

    public double getUsage() {
        workload += (random.nextDouble() - 0.5) * 60;
        workload = Math.max(0, workload);
        return Math.min(100, workload / coreCount);
    }
}
