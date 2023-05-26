package com.shanks.practice;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Sony {
    /*
    Find the number of occurrences of a character in a string ,
    Input is a string like "AAAAABBCCAA" and it should print "5A2B2C2A".
    5 being the continuous number of occurrence for character 'A'.
    Same is with other characters also. Solve using Java 8 API only
    * **/

    public static void main(String[] args) {
        String input = "AAAAABBCCAA";

        StringBuilder result = new StringBuilder();
        AtomicReference<Character> prev = new AtomicReference<>(' ');
        AtomicInteger count = new AtomicInteger();
        input.chars().mapToObj(value -> (char)value)
                .forEach(character -> {
            if(prev.get() != character) {
                if(prev.get() != ' ') {
                    result.append(count.get()).append(prev.get());
                }

                count.set(1);
                prev.set(character);
            } else {
                count.incrementAndGet();
            }
        });
        result.append(count.get()).append(prev.get());

        System.out.println(result);

        int [] result1 = getUpdatedArray(new int[] {0, 4, 0, 3});
        for(int num : result1) {
            System.out.print(num+" ");
        }
    }

    /*
    * Return a version of the given array where each zero value in the array is replaced by the largest odd value to the right of the zero in the array.
    * If there is no odd value to the right of the zero, leave the zero as a zero.
        newVersion([0, 5, 0, 3]) → [5, 5, 3, 3]
        newVersion([0, 4, 0, 3]) → [3, 4, 3, 3]
        newVersion([0, 1, 0]) → [1, 1, 0]
        *
        * {(1,5), (3,3)} --- O(n)
        * {5,}
    * */
    public static int[] getUpdatedArray (int [] inputArray) {
        int [] resultArray = new int [inputArray.length];

        for(int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] != 0) {
                resultArray[i] = inputArray[i];
            } else {
                int replacement = 0;
                for(int j = i + 1; j < inputArray.length; j++) {
                    if(inputArray[j] % 2 != 0) {
                        replacement = inputArray[j];
                        break;
                    }
                }
                resultArray[i] = replacement;
            }
        }

        return resultArray;
    }
}
