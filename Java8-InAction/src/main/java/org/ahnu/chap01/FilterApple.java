package org.ahnu.chap01;

import org.ahnu.model.Apple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.groupingBy;

public class FilterApple {

    public static void main(String[] args) {

        Apple apple1 = new Apple("red", new BigDecimal(70));
        Apple apple2 = new Apple("red", new BigDecimal(150));
        Apple apple3 = new Apple("green", new BigDecimal(150));
        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);

        //old
        List<Apple> apples1 = filterApples(inventory, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return Apple.isGreenApple(apple);
            }
        });
        System.out.println("1---------------" + apples1);

        //new
        List<Apple> apples2 = filterApples(inventory, Apple::isGreenApple);
        System.out.println("2-----------------" + apples2);

        List<Apple> apples3 = filterApples(inventory, a -> "green".equals(a.getColor()) &&
                a.getHeavy().compareTo(new BigDecimal(140)) >= 0);
        System.out.println("3-------------------" + apples3);

        Map<String, List<Apple>> collect = inventory.stream().filter(apple -> apple.getHeavy().compareTo(new BigDecimal(140)) >= 0).
                collect(groupingBy(Apple::getColor));
        System.out.println("5-------------------" + collect);

        Map<String, List<Apple>> collect2 = inventory.parallelStream().filter(apple -> apple.getHeavy().compareTo(new BigDecimal(140)) >= 0).
                collect(groupingBy(Apple::getColor));
        System.out.println("6-------------------" + collect2);

    }

    private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
