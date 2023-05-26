package com.shanks.practice;

public class Volkswagen {
    public static void main(String[] args) {
        System.out.println(printOccurance("APACCCLK"));
    }

    public static String printOccurance (String input) {
        StringBuilder output = new StringBuilder();
        int [] charCount = new int[26];
        for(int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            int index = curr - 'A';
            charCount[index]++;
            output.append(charCount[index]).append(curr);
        }

        return output.toString();
    }
}
