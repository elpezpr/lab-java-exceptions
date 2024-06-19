package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> persons;

    public PersonList() {
        this.persons = new ArrayList<>();
    }

    // Method to add a Person to the list
    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        try {
            if (name == null) {
                throw new IllegalArgumentException("Name cannot be null");
            }

            if (!name.contains(" ")) {
                throw new IllegalArgumentException("Name must be formatted as 'firstName lastName'");
            }

            for (Person person : persons) {
                if (person.getName().equals(name)) {
                    return person;  // Return the matching person
                }
            }

            return null;

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Handle the exception (print or log)
            return null;  // Return null if there's an exception
        }
    }

    public Person clonePerson(Person originalPerson) {
        int newId = originalPerson.getId() + 1;
        return new Person(newId, originalPerson.getName(), originalPerson.getAge(), originalPerson.getOccupation());
    }

    public void writePersonToFile(Person person, String filename) {
        if (person == null) {
            throw new IllegalArgumentException("Person object cannot be null");
        }

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(person.toString());
            System.out.println("Person information written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}
