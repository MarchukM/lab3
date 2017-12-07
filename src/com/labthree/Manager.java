package com.labthree;

import com.labthree.algorythm.AbstractAlgorithm;
import com.labthree.algorythm.FirstFreeAlgorithm;
import com.labthree.model.Memory;
import com.labthree.model.Process;
import com.labthree.model.Report;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class Manager {
    public static final int NUMBER_OF_ATTEMPTS = 100;
    public static final int NUMBER_OF_ALLOCATIONS = 1000;

    private AbstractAlgorithm algorithm;
    private Memory memory;

    public Manager(AbstractAlgorithm algorithm, Memory memory) {
        this.algorithm = algorithm;
        this.memory = memory;
        algorithm.init(memory);
    }


    public Report run() {
        Report report = new Report();
        report.setAlgorithm(algorithm);

        int amountOfFailures = 0;

        for (int j = 0; j < NUMBER_OF_ATTEMPTS; j++) {
            int refuseCounter = 0;

            for (int i = 0; i < NUMBER_OF_ALLOCATIONS; i++) {
                memory.iterationPerformed();
                Process process = new Process();

                if (algorithm.findPlace(process)) {
                    memory.addProcess(process);
                } else {
                    ++refuseCounter;
                    process.releaseId();
                }
            }

            amountOfFailures += refuseCounter;
        }

        report.setRefuseNumber(amountOfFailures);

        return report;
    }

    public AbstractAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(AbstractAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
}
