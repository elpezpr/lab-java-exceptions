package org.example;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(1, "John Doe", 30, "Engineer");
        Person p2 = new Person(2, "John Doe", 30, "Engineer");
        Person p3 = new Person(3, "Jane Doe", 25, "Doctor");

        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false

        p1.setAge(35);
        System.out.println("p1 after setting new age: " + p1.toString());

        p1.setAge(-5);  // Will catch the exception and print the error message
        System.out.println("p1 after trying to set invalid age: " + p1.toString());  // Age remains unchanged

        PersonList personList = new PersonList();
        Person johnDoe = new Person(1, "John Doe", 30, "Engineer");
        personList.writePersonToFile(johnDoe, "john_doe.txt");

    }

}