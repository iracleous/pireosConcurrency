package gr.codehub.lambda;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayExample {
    public static void main(String[] args) {


        Employee[] employees = new Employee[4];
        employees[0] = new Employee("dimitris", 1000, 21, LocalDate.now());
        employees[1] = new Employee("john", 999, 23, LocalDate.now());
        employees[2] = new Employee("lambros", 1001, 25, LocalDate.now());
        employees[3] = new Employee("george", 800, 25, LocalDate.now());

        List<Employee> employeeList = Arrays.asList(employees);

        System.out.println(employeeList);

        List<Employee> sortedEmployeesBySalary =
                employeeList.stream()
                        .sorted(Comparator.comparing(anEmployee -> anEmployee.getSalary()))
                        .collect(Collectors.toList());

        System.out.println(sortedEmployeesBySalary);

// another way tho write the comparator
        List<Employee> sortedEmployeesBySalary1 =
                employeeList.stream()
                        .sorted(Comparator
                                .comparing(Employee::getSalary)
                                .thenComparing(Comparator.comparing(Employee::getAge)))
                        .collect(Collectors.toList());


        List<Employee> sortedEmployeesByAgeReversed =
                employeeList.stream()
                        .sorted(Comparator.comparing(Employee::getAge).reversed())
                        .collect(Collectors.toList());

        System.out.println(sortedEmployeesByAgeReversed);


    }

}
