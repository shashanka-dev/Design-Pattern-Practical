package com.shanks.practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Employee(id, name, salary)
public class Persistent {
    public static void main(String[] args) {
        List<PEmployee> employees = List.of(new PEmployee(1,"XYZ", 2340), new PEmployee(2,"ABC", 3340));

        Map<Integer, String> empMap = employees.stream().collect(Collectors.toMap(pEmployee -> pEmployee.id, pEmployee -> pEmployee.name));
        System.out.println(empMap);

        //String
        //first non repeatative char
        String s = "aasbbdsesfe";
        List<Character> chars = new ArrayList<>();
        Map<Character, Integer>
        for(char c : s.toCharArray()) {
            chars.add(c);
        }

    }
}

class PEmployee {
    int id;
    String name;
    double salary;

    public PEmployee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
