package com.shanks.practice;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Marlabs {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(100, 101, 102, 103, 104, 102);

        numbers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);

        //to print duplicate
        List<Integer> duplicates = numbers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(duplicates);
    }
}

