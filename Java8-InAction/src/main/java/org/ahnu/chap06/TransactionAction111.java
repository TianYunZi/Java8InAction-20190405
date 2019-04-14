package org.ahnu.chap06;

import org.ahnu.model.Dish;
import org.ahnu.model.Transaction;
import org.ahnu.utils.ConstantsUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionAction111 {

    public static void main(String[] args) {
        List<Transaction> transactions = ConstantsUtil.getTransactions();
        Map<Transaction.Currency, List<Transaction>> transactionByCurrencies =
                transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
        System.out.println("1--------------" + transactionByCurrencies);

        List<Dish> dishes = ConstantsUtil.getDishes();
        Double totalCalories = dishes.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("2-------------" + totalCalories);

        String shortMenu = dishes.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println("3------------" + shortMenu);

        int totalCalories2 = dishes.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println("4-----------------" + totalCalories2);
    }
}
