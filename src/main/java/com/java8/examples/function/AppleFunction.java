package com.java8.examples.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AppleFunction
{


    public static List<String> getColorsOfApple (List<Apple> apple,
        Function<Apple, String> function)
    {
        List<String> names = new ArrayList<String>();
        apple.stream()
            .forEach(a -> names.add(function.apply(a)));
        return names;
    }


    public static List<Apple> applyIdentityToApples (List<Apple> apples,
        Function<Apple, Apple> identity)
    {
        List<Apple> appleList = new ArrayList<Apple>();
        apples.stream()
            .forEach(a -> appleList.add(identity.apply(a)));

        return appleList;
    }

}
