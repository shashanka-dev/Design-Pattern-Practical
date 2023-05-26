package com.shanks.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Xebia {

    public static void main(String[] args) {

//Employee {id, name, salary, departmentName}
//dept wise we will receive input Map{departmentName, List<Employee>}
//write method input is map, sort the list of employee and return the list (on the salary descending order)
// return type is map
        Map<String, List<Employee>> employeeMap = new HashMap<>();

        //input is a number
        //return the square root of that number


    }

    /*
    private static Map<String, List<Employee>> getEmployees () {
        Employee e1 = new Employee(1, "ABC1", )
    }
*/
    private static Map<String, List<Employee>> sortEmployeesOnSalary (Map<String, List<Employee>> employeesMap) {
        Map<String, List<Employee>> outputMap = new HashMap<>();

        employeesMap.keySet().forEach(department -> {

            List<Employee> sortedEmps = employeesMap.get(department).stream().sorted((emp1, emp2) -> {
                if(emp1.getSalary() < emp2.getSalary())
                    return 1;
                else if(emp1.getSalary() > emp2.getSalary())
                    return -1;
                else
                    return 0;
            }).collect(Collectors.toList());

            outputMap.put(department, sortedEmps);
        });

        return outputMap;
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
