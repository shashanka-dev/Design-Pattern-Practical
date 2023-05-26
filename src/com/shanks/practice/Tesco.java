package com.shanks.practice;

import java.util.Stack;

public class Tesco {
    //Given 2 integer arrays
    //push array & pop array
    //push = {1,2,3,4,5}
    //pop = {4,5,3,2,1}
    //if size of both arrays are not same return FALSE

    public static boolean validate (int [] pushArray, int [] popArray) {

        if(pushArray == null || popArray == null || pushArray.length != popArray.length)
            return false;

        int n = pushArray.length;
        int popIndex = 0;

        Stack<Integer> pushStack = new Stack<>();

        int i = 0;

        while(popIndex < n) {
            int numTobePop = popArray[popIndex];

            if(i < pushArray.length) {
                pushStack.push(pushArray[i]);
            }

            if(pushStack.peek() == numTobePop) {
                pushStack.pop();
                popIndex++;
            } else if (i >= pushArray.length) {
                break;
            }

            i++;
        }

        return pushStack.isEmpty();
    }

    public static void main(String[] args) {
        int [] pushArray = new int[] {1,2,3,4,5};
        int [] popArray = new int[] {4,3,1,2,5}; //false

        System.out.println(validate(pushArray,popArray));
    }
}
