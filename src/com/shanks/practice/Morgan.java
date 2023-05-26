package com.shanks.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Morgan {

    public static void main(String[] args) {
        int maxCapacity = 3;

        int [] numberOfProducts = new int [] {3,1,3};
        int [] sizeOfProduct = new int [] {5,4,1};

        List<Integer> containerIndex = new ArrayList<>();
        for(int i = 0; i < numberOfProducts.length; i++) {
            if(numberOfProducts[i] <= maxCapacity) {
                containerIndex.add(i);
            }
        }

        int max = containerIndex.stream().map(index -> numberOfProducts[index] * sizeOfProduct[index]).max(Comparator.naturalOrder()).orElse(0);
        System.out.println(max);
    }
}
