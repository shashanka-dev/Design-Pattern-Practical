package com.shanks.practice;

public class Altimetric4 {
    public static void main(String[] args) {
        //i/p: a[] = {16,17,4,3,5,2}
        //o/p: b[] = {17,5,5,5,2,-1}
        //use one single loop
        //int a [] = new int [] {16,17,4,3,5,19};
        //19,19,19,19,19,-1

        int a [] = new int [] {16,17,4,3,5,19};
        int b [] = new int [a.length];

        b[a.length - 1] = -1;
        b[a.length - 2] = a[a.length - 1];

        int max = a[a.length - 1];
        int j = a.length - 2;
        for(int i = a.length - 3; i >= 0; i--) {
            b[i] = Math.max(a[j], max);
            max = b[i];
            j--;
        }

        for(int num : b) {
            System.out.println(num);
        }
    }

}
