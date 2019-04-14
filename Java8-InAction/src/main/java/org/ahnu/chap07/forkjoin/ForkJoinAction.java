package org.ahnu.chap07.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinAction {

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 1_000_000L).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        System.out.println(new ForkJoinPool().invoke(task));
    }
}
