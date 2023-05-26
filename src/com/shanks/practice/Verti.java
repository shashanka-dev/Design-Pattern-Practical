package com.shanks.practice;

import java.util.ArrayList;
import java.util.List;

public class Verti {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
    Input: s = "()[]{}"
    Output: true

    Input: s = "(]"
    Output: false

    Input: s = "{([]){}}"
    Output: true
    */

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("{([]){}}"));
    }

    public static boolean isValid (String input) {
        boolean flag = true;
        List<Character> openBr = new ArrayList<>();
        for(char ch : input.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                openBr.add(ch);
            } else {
                char lastCh = openBr.get(openBr.size() - 1);
                if( (ch == ')' && lastCh != '(') || (ch == '}' && lastCh != '{') || (ch == ']' && lastCh != '[') ){
                    flag = false;
                } else {
                    openBr.remove(openBr.size() - 1);
                }
            }
        }
        return flag;
    }
}
