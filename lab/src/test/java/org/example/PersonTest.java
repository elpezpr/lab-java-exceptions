package org.example;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @org.junit.jupiter.api.Test
    void setAge_validAge() {
        Person person = new Person(1, "John Doe", 30, "Engineer");

        // Test setting a valid age
        person.setAge(35);
        assertEquals(35, person.getAge());
        System.out.println(person);
    }
    @org.junit.jupiter.api.Test
    void setAge_invalidAge() {
        Person person = new Person(1, "John Doe", 30, "Engineer");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
        assertEquals("Age can't be 0", exception.getMessage());

    }

    }
