package org.ahnu.utils;

import org.ahnu.model.Dish;
import org.ahnu.model.Transaction;

import java.util.Arrays;
import java.util.List;

public final class ConstantsUtil {

    public static List<Dish> getDishes() {
        return Arrays.asList(new Dish(" pork", false, 800, Dish.Type.MEAT), new Dish(" beef", false, 700,
                Dish.Type.MEAT), new Dish(" chicken", false, 400, Dish.Type.MEAT), new Dish(" french fries", true,
                530, Dish.Type.OTHER), new Dish(" rice", true, 350, Dish.Type.OTHER), new Dish(" season fruit", true,
                120, Dish.Type.OTHER), new Dish(" pizza", true, 550, Dish.Type.OTHER), new Dish(" prawns", false, 300
                , Dish.Type.FISH), new Dish(" salmon", false, 450, Dish.Type.FISH));
    }

    public static List<Transaction> getTransactions() {
        return Arrays.asList(new Transaction(Transaction.Currency.EUR, 1500.0),
                new Transaction(Transaction.Currency.USD, 2300.0),
                new Transaction(Transaction.Currency.GBP, 9900.0),
                new Transaction(Transaction.Currency.EUR, 1100.0),
                new Transaction(Transaction.Currency.JPY, 7800.0),
                new Transaction(Transaction.Currency.CHF, 6700.0),
                new Transaction(Transaction.Currency.EUR, 5600.0),
                new Transaction(Transaction.Currency.USD, 4500.0),
                new Transaction(Transaction.Currency.CHF, 3400.0),
                new Transaction(Transaction.Currency.GBP, 3200.0),
                new Transaction(Transaction.Currency.USD, 4600.0),
                new Transaction(Transaction.Currency.JPY, 5700.0),
                new Transaction(Transaction.Currency.EUR, 6800.0));
    }
}