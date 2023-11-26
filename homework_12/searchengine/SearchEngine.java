package com.proftelran.org.homework_12.searchengine;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class SearchEngine {

    public static List<Product> filterProducts(List<Product> products, Predicate<Product> predicate) {
        return products.stream()
                .filter(predicate)
                .toList();
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1, "Product1", Map.of("color", "red"), Map.of("price", 120)),
                new Product(2, "Product2", Map.of("color", "blue"), Map.of("price", 90)),
                new Product(3, "Product3", Map.of("color", "white"), Map.of("price", 40)),
                new Product(4, "Product4", Map.of("color", "black"), Map.of("price", 70)),
                new Product(5, "Product5", Map.of("color", "blue"), Map.of("price", 100)),
                new Product(6, "Product6", Map.of("color", "white"), Map.of("price", 30)),
                new Product(7, "Product7", Map.of("color", "red"), Map.of("price", 85)),
                new Product(8, "Product8", Map.of("color", "black"), Map.of("price", 35))
        );

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите критерий для фильтрации (1 - по цвету, 2 - по цене):");
        int filterChoice = scanner.nextInt();

        Predicate<Product> predicate;

        switch (filterChoice) {
            case 1:
                System.out.println("Введите значение цвета для фильтрации:");
                String colorValue = scanner.next();
                predicate = product -> colorValue.equals(product.getStringProperties().get("color"));
                break;
            case 2:
                System.out.println("Введите значение для фильтрации по цене:");
                int referenceValue = scanner.nextInt();

                System.out.println("Выберите критерий сравнения (1 - меньше, 2 - равно, 3 - не равно, 4 - больше, 5 - меньше или равно, 6 - больше или равно):");
                int operatorChoice = scanner.nextInt();

                IntegerPredicate.IntegerOperator operator;

                switch (operatorChoice) {
                    case 1:
                        operator = IntegerPredicate.IntegerOperator.LESS_THAN;
                        break;
                    case 2:
                        operator = IntegerPredicate.IntegerOperator.EQUAL;
                        break;
                    case 3:
                        operator = IntegerPredicate.IntegerOperator.NOT_EQUAL;
                        break;
                    case 4:
                        operator = IntegerPredicate.IntegerOperator.GREATER_THAN;
                        break;
                    case 5:
                        operator = IntegerPredicate.IntegerOperator.LESS_OR_EQUAL_THAN;
                        break;
                    case 6:
                        operator = IntegerPredicate.IntegerOperator.GREATER_OR_EQUAL_THAN;
                        break;
                    default:
                        throw new IllegalArgumentException("Неверный выбор оператора.");
                }

                predicate = new IntegerPredicate(referenceValue, operator, "price");
                break;
            default:
                throw new IllegalArgumentException("Неверный выбор критерия фильтрации.");
        }

        List<Product> filteredProducts = filterProducts(products, predicate);

        System.out.println("Фильтрованные продукты:");

        for (Product product : filteredProducts) {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Color: " + product.getStringProperties().get("color"));
            System.out.println("Price: " + product.getIntegerProperties().get("price"));
            System.out.println("---");
        }
    }
}