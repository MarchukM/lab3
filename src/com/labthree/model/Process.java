package com.labthree.model;

import com.labthree.util.ProcessIdSequence;

import java.util.concurrent.ThreadLocalRandom;

public class Process {
    public final static int DEFAULT_MAX_NEEDED_SPACE = 50;
    public final static int DEFAULT_MAX_LIFETIME = 10;

    private ProcessIdSequence sequence;

    private int processId;
    private int neededSpace;
    private int lifeTime;
    private int startPosition;
    private int endPosition;

    public Process(int neededSpace) {
        this.sequence = ProcessIdSequence.getInstance();
        this.processId = sequence.getId();
        this.neededSpace = neededSpace;
        this.lifeTime = 4;
    }

    public Process(int maxNeededSpace, int maxLifeTime) {
        this.sequence = ProcessIdSequence.getInstance();
        this.processId = sequence.getId();
        this.neededSpace = ThreadLocalRandom.current().nextInt(1, maxNeededSpace + 1);
        this.lifeTime = ThreadLocalRandom.current().nextInt(1, maxLifeTime + 1);
    }

    public Process() {
        this.sequence = ProcessIdSequence.getInstance();
        this.processId = sequence.getId();
        this.neededSpace = ThreadLocalRandom.current().nextInt(1, DEFAULT_MAX_NEEDED_SPACE + 1);
        this.lifeTime = ThreadLocalRandom.current().nextInt(1, DEFAULT_MAX_LIFETIME + 1);
    }

    public void releaseId(){
        sequence.putIdBack(processId);
    }

    public int decrementLifeTime(){
        return --lifeTime;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getNeededSpace() {
        return neededSpace;
    }

    public void setNeededSpace(int neededSpace) {
        this.neededSpace = neededSpace;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public void displayProcessInfo() {
        System.out.println("***PROCESS***");
        System.out.println("------------");
        System.out.println("Process Id:   " + processId);
        System.out.println("Needed space: " + neededSpace);
        System.out.println("lifeTime:     " + lifeTime);
    }

}
