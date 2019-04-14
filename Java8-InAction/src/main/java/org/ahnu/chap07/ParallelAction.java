package org.ahnu.chap07;

import java.util.function.Function;

public class ParallelAction {

    public static void main(String[] args) {
        System.out.println("Ranged sum done in:" + meansureSumPerf(ParallelStreams::rangedSum, 10_000_000L));

        System.out.println("Parallel range sum done in:" + meansureSumPerf(ParallelStreams::parallelRangedSum,
                10_000_000L));
    }

    private static <T> long meansureSumPerf(Function<T, T> adder, T n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            T sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }
}
