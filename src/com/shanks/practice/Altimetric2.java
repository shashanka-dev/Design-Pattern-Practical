package com.shanks.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Altimetric2 {
    public static void main(String[] args) {
        Map<String, Integer> numMap = new HashMap<>();
        numMap.put("One",1);
        numMap.put("Six",6);
        numMap.put("Two",2);
        numMap.put("Ten",10);
        numMap.put("Three",3);

        Map<String, Integer> numMap1 = numMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(integer, integer2) -> integer, LinkedHashMap::new));
        System.out.println(numMap1);
    }
}
