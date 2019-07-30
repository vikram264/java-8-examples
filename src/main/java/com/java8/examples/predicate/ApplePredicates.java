package com.java8.examples.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ApplePredicates
{

    public static Predicate<Apple> isPriceAbove100 ()
    {
        return apple -> apple.getPrice() > 100;

    }

    public static Predicate<Apple> isGreen ()
    {
        return apple -> apple.getColor()
            .equals("Green");

    }

    public static Predicate<Apple> andPredicate ()
    {
        return ApplePredicates.isGreen()
            .and(isPriceAbove100());
    }
    
    public static Predicate<Apple> negatePredicate ()
    {
        return ApplePredicates.isGreen()
            .negate();
    }

    public static List<Apple> filterApples (List<Apple> apples,
        Predicate<Apple> predicate)
    {
        return apples.stream()
            .filter(predicate)
            .collect(Collectors.toList());
    }

}
