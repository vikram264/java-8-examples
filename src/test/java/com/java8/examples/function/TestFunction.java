package com.java8.examples.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

import com.java8.examples.function.Apple;

public class TestFunction
{
    List <Apple> apples;
    @Before
    public void setUp() {
        apples = new ArrayList<>();
        apples.add(new Apple("Green", 120));
        apples.add(new Apple("Red", 90));
        apples.add(new Apple("White", 180));
        apples.add(new Apple("Yellow", 75));
    }
    
    @Test
    public void testApplyMethod() {
        Function<Apple,String> colorOfApple = apple -> {
            return apple.getColor();
        };
       List <String> colors = AppleFunction.getColorsOfApple(apples, colorOfApple);
       colors.forEach(System.out::println);
    }
    
    @Test
    public void testAndThenMethod() {
        Function<Apple,String> colorOfApple = apple -> {
            return apple.getColor();
        };
        
        Function<String,String> andThenFunc = apple -> {
            return "color = "+ apple;
        };
       List <String> colors = AppleFunction.getColorsOfApple(apples, colorOfApple.andThen(andThenFunc));
       colors.forEach(System.out::println);
    }

    @Test
    public void testIdentityMethod() {
       
        List<Apple> appleNames=AppleFunction.applyIdentityToApples(apples, Function.identity());
        appleNames.forEach(System.out::println);
       
    }

  
    }


