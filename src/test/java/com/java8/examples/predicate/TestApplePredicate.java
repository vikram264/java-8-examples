package com.java8.examples.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

public class TestApplePredicate
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
    public void getApplesAbove100 () {
        System.out.println("getApplesAbove100");
      List<Apple> filteredApple = ApplePredicates.filterApples(apples, ApplePredicates.isPriceAbove100()); 
      filteredApple.forEach(System.out::println);
    }
    
    @Test
    public void testAndPredicate () {
        System.out.println("testAndPredicate");
        List<Apple> filteredApple = ApplePredicates.filterApples(apples, ApplePredicates.andPredicate()); 
        filteredApple.forEach(System.out::println);
    }
    
    @Test
    public void testNegatePredicate () {
        System.out.println("testNegatePredicate");
        List<Apple> filteredApple = ApplePredicates.filterApples(apples, ApplePredicates.negatePredicate()); 
        filteredApple.forEach(System.out::println);
    }
    
    @Test
    public void testTestPredicate () {
        System.out.println("testTestPredicate");
        Apple apple = new Apple("Green", 90);
        System.out.println(ApplePredicates.isGreen().test(apple));
        System.out.println(ApplePredicates.isPriceAbove100().test(apple));
    }
    @Test
    public void testIsEqualPredicate () {
        System.out.println("testIsEqualPredicate");
        Apple apple = new Apple("Green", 90);
        Predicate<Apple> standardApple = Predicate.isEqual(apple);
        Apple testApple = new Apple("Red", 187);
        System.out.println(standardApple.test(testApple));
        
    }

}
