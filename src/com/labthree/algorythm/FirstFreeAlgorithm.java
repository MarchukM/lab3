package com.labthree.algorythm;

import com.labthree.model.Process;


public class FirstFreeAlgorithm extends AbstractAlgorithm {


    @Override
    public boolean findPlace(Process process) {
        boolean isBlockFound = false;
        int startPosition = -1;
        int endPosition = -1;


        for (int i = 0; i < memoryReference.length; i++) {
            if (memoryReference[i] == 0) {
                int neededSpace = process.getNeededSpace();
                startPosition = i;

                if (startPosition + neededSpace > memoryReference.length) {
                    return false;
                }

                for (int j = startPosition; neededSpace > 0; j++, neededSpace--) {
                    if (memoryReference[j] != 0) {
                        i = j;
                        startPosition = -1;
                        break;
                    }

                    if (j == process.getNeededSpace() + startPosition - 1) {
                        endPosition = j;
                        isBlockFound = true;
                    }
                }

            }
            if (isBlockFound) {
                break;
            }
        }

        if (isBlockFound) {
            process.setStartPosition(startPosition);
            process.setEndPosition(endPosition);
            putProcessInMemory(startPosition, endPosition, process);
        }

        return isBlockFound;
    }


}
