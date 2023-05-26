package com.shanks.practice;

public class Altimetric {
    public static void main(String[] args) {
        String input = "AAACBAABCABBBBCCCC";
        System.out.println(check(input));
    }

    public static String check (String input) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch == 'C') {
                continue;
            } else if(ch == 'A' && i + 1 < input.length() && input.charAt(i+1) == 'B') {
                i++;
                continue;
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
