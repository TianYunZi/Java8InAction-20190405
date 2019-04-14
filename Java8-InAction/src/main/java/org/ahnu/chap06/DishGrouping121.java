package org.ahnu.chap06;

import org.ahnu.enums.CaloricLevel;
import org.ahnu.model.Dish;
import org.ahnu.utils.ConstantsUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DishGrouping121 {
    public static void main(String[] args) {
        List<Dish> menu = ConstantsUtil.getDishes();
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect =
                menu.stream().collect(Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        })));
        System.out.println("1---------" + collect);

        Map<Dish.Type, Dish> collect1 = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get)));
        System.out.println("2----------" + collect1);
    }
}
