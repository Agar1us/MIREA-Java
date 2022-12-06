package Formatting;

import java.util.ArrayList;
import java.util.Scanner;

public class Report {
    ArrayList<Employee> people;

    Report(){
        people = new ArrayList<Employee>();
        people.add(new Employee("Vasya", 1232.852));
        people.add(new Employee("Petya", 2000.215313));
        people.add(new Employee("Alex", 100000.123));
        people.add(new Employee("Ivan", 4500.45));
    }

    public ArrayList<Employee> getPeople() {
        return people;
    }
}
