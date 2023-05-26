package com.shanks.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Publicis {

    public static void main(String[] args) {

        //How the below code will behave
        try {
            throw new java.io.IOException();
        } catch (java.io.IOException exc) {
            System.out.println("IOException: "+exc.getClass());
            //commented to execute the code
            //throw new RuntimeException(); //Exception will be thrown from here and there is no catch. So finally will be executed then exception will be thrown
        } catch (Exception exc) {
            System.out.println("Exception: "+exc.getClass());
        } finally {
            System.out.println("In finally");
        }


        // Remove role2 and role3 for all the employees
        // check if any employee will have no roles after that then delete them
        Map<String, List<String>> empRolesMap = new HashMap<>();
        empRolesMap.put("emp1", Stream.of("role1","role2").collect(Collectors.toList()));
        empRolesMap.put("emp2", Stream.of("role3","role4").collect(Collectors.toList()));
        empRolesMap.put("emp3", Stream.of("role2").collect(Collectors.toList()));

        List<String> invalidEmps = new ArrayList<>();
        for(String emp : empRolesMap.keySet()) {
            List<String> roles = new ArrayList<> ();
            for(String role : empRolesMap.get(emp)) {
                if(role == "role2" || role == "role3") {
                    continue;
                } else {
                    roles.add(role);
                }
            }
            if(roles.isEmpty()) {
                invalidEmps.add(emp);
            } else {
                empRolesMap.put(emp,roles);
            }
        }
        for(String invalidEmp : invalidEmps) {
            empRolesMap.remove(invalidEmp);
        }
        System.out.println(empRolesMap);

        // Output: 3, 4, 9
        // Find out the numbers occurred more than once using java 8 without declaring extra collection
        int[] list = {5, 3, 4, 1, 3, 7, 2, 9, 9, 4 ,3};
        List<Integer> duplicateNums = Arrays.stream(list)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicateNums);

        //Take a list of students
        //display the stream wise student list
        List<Student> students = new Publicis().getStudents();
        Map<String, List<String>> streamWiseStudentList = students.stream()
                .collect(Collectors.groupingBy(student -> student.streamId,
                        Collectors.mapping(student -> student.name, Collectors.toList())));
        System.out.println(streamWiseStudentList);
    }

    private List<Student> getStudents () {
        Student s1 = new Student(1,"Abinash", "BSC");
        Student s2 = new Student(2,"Abdul", "BCOM");
        Student s3 = new Student(3,"Pratik", "MBA");
        Student s4 = new Student(4,"Rajen", "BA");
        Student s6 = new Student(5,"Sourabha", "BSC");
        Student s7 = new Student(6,"Amar", "BSC");
        Student s8 = new Student(7,"Sushanta", "BCOM");
        Student s9 = new Student(8,"Ananta", "MBA");
        Student s10 = new Student(9,"Akash", "BA");
        Student s11 = new Student(10,"Janmenjay", "BSC");

        return List.of(s1,s2,s3,s4,s6,s7,s8,s9,s10,s11);
    }

    class Student {
        int id;
        String name;
        String streamId;

        public Student(int id, String name, String streamId) {
            this.id = id;
            this.name = name;
            this.streamId = streamId;
        }
    }
}
