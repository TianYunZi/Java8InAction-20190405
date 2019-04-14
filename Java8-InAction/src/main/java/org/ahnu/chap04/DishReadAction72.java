package org.ahnu.chap04;

import org.ahnu.model.Dish;
import org.ahnu.utils.ConstantsUtil;

import java.util.List;
import java.util.stream.Collectors;

public class DishReadAction72 {

    public static void main(String[] args) {
        List<Dish> menu = ConstantsUtil.getDishes();
        List<String> threeHighCaloricDishName =
                menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println(threeHighCaloricDishName);

    }
}
