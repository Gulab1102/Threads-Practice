package org.groupby;

import org.example.Main;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    String name;
    String department;
    int salary;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.department+" "+this.name+" "+this.salary;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 5000),
                new Employee("Bob", "HR", 5500),
                new Employee("Charlie", "IT", 6000),
                new Employee("David", "IT", 6200)
        );


        Map<String, Integer> sortedByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        System.out.println(sortedByDept);

        LinkedHashMap<String, Integer> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(collect);

        Map<String, List<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy((emp -> {
            if (emp.getSalary() < 5000) return "Low";
            else if (emp.getSalary() <= 10000) return "Medium";
            else return "High";
        })));

        //to handle null key

        Map<String, List<Employee>> unknown = employees.stream().collect(Collectors.groupingBy(employee ->
                Optional.ofNullable(employee.getDepartment()).orElse("Unknown")
        ));

        Map<Boolean, List<Employee>> collect2 = employees.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 400));

        System.out.println(collect2);

        System.out.println(collect1);


        // Group by department and calculate total salary

        Map<String, Integer> collect3 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));

        collect3.forEach((a,b)->{
                    System.out.println(a+" "+b);
                }
                );


    }
}
