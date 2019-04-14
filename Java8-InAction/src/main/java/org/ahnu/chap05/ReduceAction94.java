package org.ahnu.chap05;

import org.ahnu.model.Dish;
import org.ahnu.utils.ConstantsUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceAction94 {

    public static void main(String[] args) throws IOException {
        List<Integer> numbers = Arrays.asList(1, 3, 2, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("1----------" + sum);

        Integer multi = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("2-----------" + multi);

        Integer sum2 = numbers.stream().reduce(Integer::sum).orElse(0);
        System.out.println("3-----------" + sum2);

        List<Dish> dishes = ConstantsUtil.getDishes();
        Integer sum3 = dishes.stream().map(Dish::getCalories).reduce(Integer::sum).orElse(0);
        System.out.println("4-------------" + sum3);

        Integer max = dishes.stream().map(Dish::getCalories).reduce(Integer::max).orElse(0);
        System.out.println("5------------" + max);

        Integer min = dishes.stream().map(Dish::getCalories).reduce(Integer::min).orElse(0);
        System.out.println("6------------" + min);

        String str =
                dishes.stream().map(Dish::getName).distinct().sorted().reduce((n1, n2) -> n1 + n2).orElse(String.valueOf(0));
        System.out.println("7------------" + str);

        int sum1 = dishes.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("8------------" + sum1);

        long count = IntStream.rangeClosed(1, 100).filter(a -> a % 2 == 0).count();
        System.out.println("9-----------" + count);

        System.out.println("10------------------------------------------------------------");

        IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a +
                b * b) % 1 == 0).mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}))
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
        System.out.println("11------------------------------------------------------------");

        IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[]{a
                , b, Math.sqrt(a * a + b * b)}).filter(t -> t[2] % 1 == 0)).forEach(t -> System.out.println(t[0] + "," +
                " " + t[1] + ", " + t[2]));

        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\zxyse\\Documents\\Java\\Practise\\Java8InAction" +
                "-20190405\\Java8-InAction\\src\\main\\resources\\data.txt"))) {
            long count1 = lines.flatMap(line -> Arrays.stream(line.split(""))).distinct().count();
            System.out.println("12----------" + count1);
        }
    }
}
