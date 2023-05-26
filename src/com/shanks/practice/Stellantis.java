package com.shanks.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stellantis {

    public static void main(String[] args) {
        /*List<Integer> inputList = List.of(-3,-1,0,2,4,5);

        if(inputList.get(0) < 0) {
            inputList = inputList.stream().map(Math::abs).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        }

        System.out.println(getSquareOfNumbers(inputList));*/

        //alpha numeric string
        // ab12cd34xy0005
        String input = "ab12cd34xy0005";

        int max = Integer.MIN_VALUE;
        int num = 0;
        for(char c : input.toCharArray()) {
            if(c >= '0' && c <= '9') {
                int i = Integer.parseInt(c+"");
                num = (num * 10) + i;
            } else {
                max = Math.max(max, num);
                num = 0;
            }
        }
        System.out.println(max);
    }

    public static List<Integer> getSquareOfNumbers (List<Integer> numbers) {
        return numbers.stream().map(number -> (number * number)).collect(Collectors.toList());
    }
}


