package com.shanks.practice;

import java.util.HashMap;

public class IvyComptech {
    public static void main(String...a){

        HashMap<IvyEmployee, String> hm= new HashMap<>();
        hm.put(new IvyEmployee("a"), "emp1");
        hm.put(new IvyEmployee("b"), "emp2");
        hm.put(new IvyEmployee("a"), "emp1 OVERRIDDEN");

        System.out.println("HashMap's data> "+hm);
        System.out.println("HashMap's size> "+hm.size());
        System.out.println(hm.get(new IvyEmployee("a")));

    }
}

class IvyEmployee {

    private final String name;

    public IvyEmployee(String name) { // constructor
        this.name = name;
    }

    @Override
    public int hashCode(){
        return 1;
    }

    @Override
    public boolean equals(Object obj){
        return true;
    }

    @Override
    public String toString() {
        return "Employee[ name=" + name + "] ";
    }

}

