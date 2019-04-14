package org.ahnu.chap07;

import java.util.stream.LongStream;

public class ParallelStreams {

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).orElse(0L);
    }

    public static long parallelRangedSum(Long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).orElse(0L);
    }
}
