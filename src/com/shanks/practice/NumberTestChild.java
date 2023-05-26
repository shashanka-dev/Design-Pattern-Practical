package com.shanks.practice;

public class NumberTestChild extends NumberTest {

    public Integer add(Integer a, Integer b) {
        System.out.println("In Child");
        return a + b;
    }

    public static void main(String[] args) {
        int result = new NumberTest().add(3,4);
        System.out.println(result);
        int result1 = new NumberTestChild().add(3,4);
        System.out.println(result1);
        NumberTest numberTest = new NumberTestChild();
        int result2 = numberTest.add(3,4);
        System.out.println(result2);
        int result3 = numberTest.add(Integer.valueOf("3"),Integer.valueOf("4"));
        System.out.println(result3);

        String s  = " ";
        System.out.println(s.isBlank());
        System.out.println(s.isEmpty());

    }
}
