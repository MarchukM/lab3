package com.labthree.algorythm;

import com.labthree.model.Memory;
import com.labthree.model.Process;

public abstract class AbstractAlgorithm {

    protected int[] memoryReference;

    public void init(Memory memory){
        memoryReference = memory.getMemoryArray();
    }

    public abstract boolean findPlace(Process process);

    protected void putProcessInMemory(int startPosition, int endPosition, Process process) {
        int processId = process.getProcessId();

        for (int i = startPosition; i <= endPosition; i++) {
            memoryReference[i] = processId;
        }
    }
}
