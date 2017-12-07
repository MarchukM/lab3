package com.labthree.util;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessIdSequence {
    private static ProcessIdSequence processIdSequence;

    private LinkedList<Integer> ids;

    private ProcessIdSequence() {
        ids = new LinkedList<>(Stream.iterate(1, i -> i + 1).limit(99).collect(Collectors.toList()));
    }

    public static ProcessIdSequence getInstance() {
        if (processIdSequence == null) {
            processIdSequence = new ProcessIdSequence();
        }
        return processIdSequence;
    }

    public Integer getId() {
        return ids.poll();
    }

    public void putIdBack(Integer id) {
        ids.addLast(id);
    }
}
