package com.labthree.algorythm;

import com.labthree.model.Process;

public class MaxSizeAlgorithm extends SuitableSizeAlgorithm {

    @Override
    protected MemoryBlock findBestBlock(Process process) {
        MemoryBlock maxSizeBlock = null;
        if (memoryBlocks.size() > 1) {
            int maxSize = 0;
            for (MemoryBlock block : memoryBlocks) {

                if (process.getNeededSpace() > block.getSize()) {
                    continue;
                }

                if (maxSize < block.getSize()) {
                    maxSize = block.getSize();
                    maxSizeBlock = block;
                }
            }
        }

        if (memoryBlocks.size() == 1) {
            if (process.getNeededSpace() > memoryBlocks.get(0).getSize()) {
                return null;
            }
            maxSizeBlock = memoryBlocks.get(0);
        }

        return maxSizeBlock;
    }
}
