package com.proftelran.org.homework_12.searchengine;

import java.util.Map;
import java.util.function.Predicate;

public class IntegerPredicate implements Predicate<Product> {

    private int referenceValue;
    private IntegerOperator operator;
    private String propertyName;

    public IntegerPredicate(int referenceValue, IntegerOperator operator, String propertyName) {
        this.referenceValue = referenceValue;
        this.operator = operator;
        this.propertyName = propertyName;
    }

    @Override
    public boolean test(Product product) {
        return product.getIntegerProperties().getOrDefault(propertyName, 0)
                .compareTo(referenceValue) * operator.getMultiplier() > 0;
    }

    public enum IntegerOperator {
        LESS_THAN(-1), //  означает, что свойство < значения, переданного в IntegerPredicate.
        EQUAL(0),     //    означает, свойство == значению, переданному в IntegerPredicate.
        NOT_EQUAL(0),  // означает, что свойство != значению, переданному в IntegerPredicate.
        GREATER_THAN(1), // означает, что свойство > значения, переданного в IntegerPredicate.
        LESS_OR_EQUAL_THAN(-1),  // означает, что свойство <= значению, переданному в IntegerPredicate.
        GREATER_OR_EQUAL_THAN(1);  // означает, что свойство в объекте Product >= значению, переданному в IntegerPredicate.

        private final int multiplier;

        IntegerOperator(int multiplier) {
            this.multiplier = multiplier;
        }

        public int getMultiplier() {
            return multiplier;
        }
    }
}