package org.ahnu.chap02;

import org.ahnu.interfaces.AppleFormatter;
import org.ahnu.model.Apple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PrintApple {

    public static void main(String[] args) {
        Apple apple1 = generateAppleList("red", 210);
        Apple apple2 = generateAppleList("red", 70);
        Apple apple3 = generateAppleList("green", 150);
        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);

        prettyPrintApple(inventory, apple -> "the color of apple is " + apple.getColor());

        prettyPrintApple(inventory, apple -> "the weight of apple is " + apple.getHeavy());

        inventory.sort(Comparator.comparing(Apple::getHeavy));
        System.out.println("print after sort: " + inventory.toString());
    }

    private static Apple generateAppleList(String green, int i) {
        return new Apple(green, new BigDecimal(i));
    }

    private static <T> void prettyPrintApple(List<T> list, AppleFormatter<T> formatter) {
        for (T t : list) {
            System.out.println(formatter.accept(t));
        }
    }
}
