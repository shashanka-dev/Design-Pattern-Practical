package com.shanks.practice;

public class Altimetric3 {
    public static void main(String[] args) {
        //a[] = {1,4,5,6,32,50,60,70,80,90}
        //int k = 31;
        // {30,27,26,25,1,19}
        //o/p: 32

        int input [] = new int [] {1,4,5,6,32,50,60,70,80,90};
        int k = 31;

        int start = 0; //0 //3
        int end = input.length;//10 //4
        while(start < end) {
            int midPoint = (start + end) / 2; //5 //2
            int mid = input[midPoint]; //50 //5

            if(mid < k) {
                start = midPoint + 1;
            } else {
                end = midPoint - 1;
            }
        }

    }

}
