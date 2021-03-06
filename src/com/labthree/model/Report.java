package com.labthree.model;

import com.labthree.algorythm.AbstractAlgorithm;
import com.labthree.algorythm.FirstFreeAlgorithm;
import com.labthree.algorythm.MaxSizeAlgorithm;
import com.labthree.algorythm.SuitableSizeAlgorithm;

public class Report {
    private String algorithmName;
    private long refuseNumber = 0;

    public void displayReport() {
        System.out.println("Алгоритм: " + algorithmName + ".");
        System.out.println("Кол-во отказов: " + refuseNumber);
    }

    public void setAlgorithm(AbstractAlgorithm algorithm) {
        if (algorithm instanceof FirstFreeAlgorithm) {
            algorithmName = "алгоритм поиска первого свободного блока памяти";
            return;
        }
        if (algorithm instanceof MaxSizeAlgorithm) {
            algorithmName = "алгоритм поска максимального по размеру блока памяти";
            return;
        }
        if (algorithm instanceof SuitableSizeAlgorithm) {
            algorithmName = "алгоритм поиска наиболее подходящего по размеру блока памяти";
            return;
        }
        algorithmName = "не установлен";
    }

    public long getRefuseNumber() {
        return refuseNumber;
    }

    public void setRefuseNumber(long refuseNumber) {
        this.refuseNumber = refuseNumber;
    }
}
