package org.ahnu.chap03;

import org.ahnu.model.Apple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class ChapThreePrintApple {

    public static void main(String[] args) {

        Map<String, BigDecimal> map = new HashMap<>(16);
        map.put("green", new BigDecimal(200));
        map.put("black", new BigDecimal(100));
        map.put("red", new BigDecimal(300));
        map.put("blue", new BigDecimal(300));

        List<Apple> apples = map(map, Apple::new);
        System.out.println("1-----------" + apples);
//        apples.sort((a1, a2) -> a2.getHeavy().compareTo(a1.getHeavy()));
        apples.sort(Comparator.comparing(Apple::getHeavy).reversed().thenComparing(Apple::getColor));
        System.out.println("2---------" + apples);

    }

    /**
     * 适用于两个参数的构造器
     *
     * @param map
     * @param f
     * @param <T>
     * @param <U>
     * @param <R>
     * @return
     */
    private static <T, U, R> List<R> map(Map<T, U> map, BiFunction<T, U, R> f) {
        List<R> result = new ArrayList<>();
        for (Map.Entry<T, U> entry : map.entrySet()) {
            T t = entry.getKey();
            U u = entry.getValue();
            result.add(f.apply(t, u));
        }

        return result;
    }
}
