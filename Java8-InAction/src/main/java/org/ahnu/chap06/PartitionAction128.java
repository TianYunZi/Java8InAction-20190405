package org.ahnu.chap06;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitionAction128 {

    public static void main(String[] args) {
        Map<Boolean, List<Integer>> collect =
                IntStream.rangeClosed(2, 100).boxed().collect(Collectors.partitioningBy(PartitionAction128::isPrime));
        System.out.println("1-----------" + collect);
    }

    private static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }
}
