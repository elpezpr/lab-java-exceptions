package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person; // Declare person as an instance variable

    @BeforeEach
    public void setUp() {
        person = new Person(1, "John Doe", 30, "Engineer"); // Initialize person before each test
    }

    @Test
    void setAge_validAge() {
        // Test setting a valid age
        person.setAge(35);
        assertEquals(35, person.getAge());
        System.out.println(person.getAge());
    }

    @Test
    void setAge_invalidAge() {
        // Test setting an invalid age
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
        System.out.println("Exception Handled");
    }
}
