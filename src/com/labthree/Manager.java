package com.labthree;

import com.labthree.algorythm.AbstractAlgorithm;
import com.labthree.algorythm.FirstFreeAlgorithm;
import com.labthree.model.Memory;
import com.labthree.model.Process;
import com.labthree.model.Report;

public class Manager {
    private AbstractAlgorithm algorithm;
    private Memory memory;

    public Manager() {
        algorithm = new FirstFreeAlgorithm();
        memory = new Memory();
        algorithm.init(memory);
    }

    public Report run(AbstractAlgorithm algorithm, Memory memory) {
        this.algorithm = algorithm;
        this.memory = memory;
        algorithm.init(memory);
        return run();
    }

    public Report run() {
        Report report = new Report();
        report.setAlgorithm(algorithm);

        for (int i = 0; i < 1000; i++) {
            memory.iterationPerformed();
            Process process = new Process(4, 4);

            if (algorithm.findPlace(process)) {
                memory.addProcess(process);
            } else {
                process.releaseId();
                report.incremectRefuseCounter();
            }
        }

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
