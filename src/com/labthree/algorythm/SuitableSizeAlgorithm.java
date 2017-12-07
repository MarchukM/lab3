package com.labthree.algorythm;

import com.labthree.model.Process;

import java.util.ArrayList;
import java.util.List;

public class SuitableSizeAlgorithm extends AbstractAlgorithm {
    protected List<MemoryBlock> memoryBlocks;

    public SuitableSizeAlgorithm() {
        memoryBlocks = new ArrayList<>();
    }

    @Override
    public boolean findPlace(Process process) {
        for (int i = 0; i < memoryReference.length; i++) {
            if (memoryReference[i] == 0) {
                MemoryBlock block = new MemoryBlock();
                block.setStartPosition(i);

                if (memoryReference.length == i + 1) {
                    block.setEndPosition(i);
                    memoryBlocks.add(block);
                    continue;
                }

                for (int j = i + 1; j < memoryReference.length; j++) {
                    if (memoryReference[j] == 0) {

                        if (memoryReference.length == j + 1) {
                            block.setEndPosition(j);
                            i = j;
                            memoryBlocks.add(block);
                        }

                    } else {
                        block.setEndPosition(j - 1);
                        i = j;
                        memoryBlocks.add(block);
                        break;
                    }
                }
            }
        }
        MemoryBlock mostSuitableBlock = findBestBlock(process);

        if (mostSuitableBlock != null) {
            process.setStartPosition(mostSuitableBlock.startPosition);
            process.setEndPosition(mostSuitableBlock.startPosition + process.getNeededSpace() - 1);
            putProcessInMemory(process.getStartPosition(), process.getEndPosition(), process);
            memoryBlocks.clear();
            return true;
        }

        return false;
    }

    protected MemoryBlock findBestBlock(Process process) {
        MemoryBlock bestBlock = null;
        if (memoryBlocks.size() > 1) {
            int dif = 100000;
            for (MemoryBlock block : memoryBlocks) {

                if (process.getNeededSpace() > block.getSize()) {
                    continue;
                }

                if (dif > Math.abs(process.getNeededSpace() - block.getSize())) {
                    dif = process.getNeededSpace() - block.getSize();
                    bestBlock = block;
                }
            }
        }

        if (memoryBlocks.size() == 1) {
            if (process.getNeededSpace() > memoryBlocks.get(0).getSize()) {
                return null;
            }
            bestBlock = memoryBlocks.get(0);
        }

        return bestBlock;
    }

    protected class MemoryBlock {
        int startPosition;
        int endPosition;
        int size;

        int getSize() {
            return size;
        }

        public int getStartPosition() {
            return startPosition;
        }

        public int getEndPosition() {
            return endPosition;
        }

        void setStartPosition(int startPosition) {
            this.startPosition = startPosition;
        }

        void setEndPosition(int endPosition) {
            this.endPosition = endPosition;
            this.size = calculateSize();
        }

        private int calculateSize() {
            return endPosition + 1 - startPosition;
        }
    }
}
