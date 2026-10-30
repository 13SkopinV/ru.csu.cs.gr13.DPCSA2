package org.example.observer.source;

import java.util.Random;

public class CPUUsage {
    private int coreCount;
    private double workload;
    Random randomHelpCPU = new Random();

    public CPUUsage(int coreCount) {
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
        workload += (randomHelpCPU.nextDouble() - 0.5) * 30;
        workload = Math.max(0, workload);
        return workload;
    }
}
