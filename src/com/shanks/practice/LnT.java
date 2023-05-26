package com.shanks.practice;

public class LnT {

    //0,1,1,2,3,5,8,13,21,34

    public static void main(String[] args) {

        int n1 = 0;
        int n2 = 1;
        System.out.print(n1+","+n2);

        int limit = 10;
        while(limit > 0) {
            int n3 = n1 + n2;
            System.out.print(","+n3);
            n1 = n2;
            n2 = n3;
            limit--;
        }
    }
}
