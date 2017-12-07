package com.labthree.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Memory {

    public static final int DEFAULT_SIZE = 100;

    private int[] memoryArray;
    private List<Process> processes;

    public Memory() {
        this.memoryArray = new int[DEFAULT_SIZE];
        this.processes = new ArrayList<>();
    }

    public Memory(int size) {
        this.memoryArray = new int[size];
        this.processes = new ArrayList<>();
    }

    public void displayMemory() {
        for (int i : memoryArray) {
            System.out.printf("[%2d]", i);
        }
        System.out.println();
    }

    public int[] getMemoryArray() {
        return memoryArray;
    }

    public void addProcess(Process process) {
        processes.add(process);
    }

    public void iterationPerformed(){
        processes.forEach(Process::decrementLifeTime);
        clearCompletedProcesses();
    }

    private void clearCompletedProcesses(){
        List<Process> processList = processes.stream().filter(p -> p.getLifeTime() == 0).collect(Collectors.toList());
        if(!processList.isEmpty()){
            processList.forEach(p -> releaseMemory(p.getStartPosition(), p.getEndPosition()));
            processList.forEach(Process::releaseId);
            processes.removeAll(processList);
        }
    }

    private void releaseMemory(int startPoint, int endPoint){
        for(int i = startPoint; i <= endPoint; i++){
            memoryArray[i] = 0;
        }
    }
}
