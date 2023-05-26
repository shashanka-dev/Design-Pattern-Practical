package com.shanks.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {
    static {
        System.out.println("HELLO");
    }
    public static boolean checkAnagram (String input1, String input2) {
        Map<Character, Integer> input1Map = getCharCountMap(input1);
        Map<Character, Integer> input2Map = getCharCountMap(input2);
        return compareMap(input1Map,input2Map);
    }

    public static boolean compareMap (Map<Character, Integer> input1Map, Map<Character, Integer> input2Map) {
        if(input1Map.size() != input2Map.size())
            return false;

        boolean flag = true;
        for(char ch : input1Map.keySet()) {
            if(!input2Map.containsKey(ch)) {
                flag = false;
                break;
            }

            if(input2Map.containsKey(ch) || input2Map.get(ch) != input1Map.get(ch)) {
                flag = false;
                break;
            }

        }

        return flag;
    }

    public static Map<Character, Integer> getCharCountMap (String input) {
        Map<Character, Integer> inputMap = new HashMap<>();
        for(char ch : input.toCharArray()) {
            int count = 1;
            if(inputMap.containsKey(ch)) {
                count += inputMap.get(ch);
            }
            inputMap.put(ch,count);
        }

        return inputMap;
    }

    public static void main(String[] args) {
        String [] input = new String [] {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> anagrams = new ArrayList<>();

        Anagram obj = new Anagram();
        List<Customer> customers = obj.getCustomers();

        Map<String,List<String>> custPhoneNumMap = customers.stream()
                .collect(Collectors.toMap(Customer::getName, Customer::getPhoneNumbers));
        System.out.println(custPhoneNumMap);

       List<String> allPhoneNumbers = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());
       System.out.println(allPhoneNumbers);
    }

    public List<Customer> getCustomers () {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(1, "qwerty", List.of("12345","34567")));
        customers.add(new Customer(2, "kjhgsdf", List.of("084026","194639")));
        customers.add(new Customer(3, "xcvbn", List.of("74302","248490")));
        customers.add(new Customer(4, "poiuy", List.of("654859","027373")));
        return customers;
    }

}

class Customer {
    int id;
    String name;
    List<String> phoneNumbers;

    public Customer(int id, String name, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    static {
        System.out.println("HELLO CUSTOMER");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
