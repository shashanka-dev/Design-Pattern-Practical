package com.shanks.practice;

import java.util.Date;

public class MorganStanley {
    //Find out common longest prefix from a set of string
    // Input: {"flower", "fly", "flow"}
    // Output: "fl"
    //else return empty string
    public static void main(String[] args) {
        String [] inputs = {"flower", "", "flow"};
        String [] inputs2 = {""};
        System.out.println(getCommonPrefix(inputs));
        System.out.println(getCommonPrefix(inputs2));


        int maxLimit = 158654;
        int start = 1;
        int end = maxLimit;
        int mid = (start + end) / 2;

        while (start < end) {
            if(isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        System.out.println("Start version: "+mid);
    }

    private static boolean isBadVersion (int versionNo) {
        return false;
    }

    private static String getCommonPrefix(String [] inputs) {
        //Same element at the same index in each string
        // String having minimum length
        int minLength = Integer.MAX_VALUE;
        for(String input : inputs) {
            minLength = Math.min(minLength, input.length());
        }
        //Min(n1, n2) * m
        int j = 0;
        StringBuilder output = new StringBuilder();
        while( j < minLength) {
            char c = inputs[0].charAt(j);
            boolean flag = true;

            for(int i = 1; i < inputs.length; i++) {
                if(inputs[i].charAt(j) != c) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                j++;
                output.append(c);
            } else {
                break;
            }
        }

        return output.toString();
    }
}


