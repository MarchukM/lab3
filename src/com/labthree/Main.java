package com.labthree;

import com.labthree.algorythm.FirstFreeAlgorithm;
import com.labthree.algorythm.MaxSizeAlgorithm;
import com.labthree.algorythm.SuitableSizeAlgorithm;
import com.labthree.model.Memory;
import com.labthree.model.Report;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Callable<Report> task1 = () -> {
            Report r = new Manager().run(new FirstFreeAlgorithm(), new Memory());
            System.out.println("first completed");
            countDownLatch.countDown();
            return r;
        };

        Callable<Report> task2 = () -> {
            Report r = new Manager().run(new MaxSizeAlgorithm(), new Memory());
            System.out.println("first completed");
            countDownLatch.countDown();
            return r;
        };

        Callable<Report> task3 = () -> {
            Report r = new Manager().run(new SuitableSizeAlgorithm(), new Memory());
            countDownLatch.countDown();
            System.out.println("first completed");
            return r;
        };


        Future<Report> result1 = executor.submit(task1);
        Future<Report> result2 = executor.submit(task2);
        Future<Report> result3 = executor.submit(task3);


        try {
            countDownLatch.await();
            result2.get().displayReport();
            result1.get().displayReport();
            result3.get().displayReport();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
