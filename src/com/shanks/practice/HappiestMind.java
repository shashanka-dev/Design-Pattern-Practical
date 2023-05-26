package com.shanks.practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HappiestMind {
    public static void main(String[] args) {
        //array of size 10
        //input number value 10
        //find the pair of numbers
        int [] numbers = new int [] {0,1,2,3,5,6,7,8,9,10};
        int target = 10;

        HashMap<Integer, Boolean> numsMap = new HashMap<>();
        for(int num : numbers) {
            int req = target - num;
            if(numsMap.containsKey(req)) {
                System.out.println(num+" - "+req);
            } else {
                numsMap.put(num, true);
            }
        }

        //Sort the map by value
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("qwertyu",10);
        inputMap.put("lkjhg",19);
        inputMap.put("cvbnpoiuy",7);
        inputMap.put("qdfghjmnbg",26);
        inputMap.put("lkjhg",8);
        System.out.println(sortMapByValue(inputMap));

        String input = "ASDFGHJKWERTYUASDFGH";
        Stack<Character> inputStack = new Stack<>();
        Stream<Character> characterStream = input.chars().mapToObj(value -> (char)value);
        characterStream.forEach(inputStack::push);
        System.out.println("inputStack"+inputStack);
       // inputStack.
    }

    //Map<String, Integer>
    //sort this map by value
    public static Map<String, Integer> sortMapByValue (Map<String, Integer> inputMap) {
        Set<Map.Entry> entrySet =  inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Map<String, Integer> result = new LinkedHashMap<>();

        for(Map.Entry entry : entrySet) {
            result.put((String)entry.getKey(), (Integer)entry.getValue());
        }

        return result;
    }
}
