package org.ahnu.chap05;

import org.ahnu.model.Dish;
import org.ahnu.utils.ConstantsUtil;

import java.util.Arrays;
import java.util.List;

public class DishReadAction91 {

    public static void main(String[] args) {
        List<Dish> menu = ConstantsUtil.getDishes();
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));

    }
}
