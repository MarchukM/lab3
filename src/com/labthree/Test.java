package com.labthree;

import com.labthree.algorythm.AbstractAlgorithm;
import com.labthree.algorythm.MaxSizeAlgorithm;
import com.labthree.model.Memory;
import com.labthree.model.Process;

public class Test {
    public static void main(String[] args) {
        AbstractAlgorithm algorithm = new MaxSizeAlgorithm();
        Memory memory = new Memory();
//        memory.getMemoryArray()[0] = 6;
//        memory.getMemoryArray()[1] = 1;
//        memory.getMemoryArray()[2] = 1;
//        memory.getMemoryArray()[3] = 1;
//        memory.getMemoryArray()[4] = 2;
        memory.getMemoryArray()[5] = 2;
//        memory.getMemoryArray()[6] = 2;
//        memory.getMemoryArray()[7] = 3;
//        memory.getMemoryArray()[8] = 3;
        System.out.println("INIT MEMORY STATE:\n");
        memory.displayMemory();

        algorithm.init(memory);
        algorithm.findPlace(new Process(3));
        memory.displayMemory();
//        algorithm.findPlace(new Process(3));
//        memory.displayMemory();

//        List<SuitableSizeAlgorithm.MemoryBlock> list = algorithm.getMemoryBlocks();
//
//        for(SuitableSizeAlgorithm.MemoryBlock b : list){
//            System.out.println("Start point: " + b.getStartPosition());
//            System.out.println("End point: " + b.getEndPosition());
//        }
    }
}
