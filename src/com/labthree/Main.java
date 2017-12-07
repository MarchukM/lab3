package com.labthree;

import com.labthree.algorythm.FirstFreeAlgorithm;
import com.labthree.algorythm.MaxSizeAlgorithm;
import com.labthree.algorythm.SuitableSizeAlgorithm;
import com.labthree.model.Memory;
import com.labthree.model.Process;
import com.labthree.model.Report;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Размер памяти: " + Memory.DEFAULT_SIZE);
        System.out.println("Кол-во итераций выделения памяти: " + Manager.NUMBER_OF_ALLOCATIONS);
        System.out.println("Кол-во прогонов для усреднения: " + Manager.NUMBER_OF_ATTEMPTS);
        System.out.println("Максимальный срок жизни процесса: " + Process.DEFAULT_MAX_LIFETIME);
        System.out.println("Максимальный блок памяти запрашиваемый процессом: " + Process.DEFAULT_MAX_NEEDED_SPACE);
        System.out.println();

        Report report1 = new Manager(new FirstFreeAlgorithm(), new Memory()).run();
        Report report2 = new Manager(new SuitableSizeAlgorithm(), new Memory()).run();
        Report report3 = new Manager(new MaxSizeAlgorithm(), new Memory()).run();

        report1.displayReport();
        System.out.println();
        report2.displayReport();
        System.out.println();
        report3.displayReport();
    }
}
