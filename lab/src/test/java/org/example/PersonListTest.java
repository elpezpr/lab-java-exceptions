package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonListTest {
    private PersonList personList;

    @BeforeEach
    public void setUp() {
        personList = new PersonList();
        personList.addPerson(new Person(1, "John Doe", 30, "Engineer"));
        personList.addPerson(new Person(2, "Jane Smith", 25, "Doctor"));
    }

    @Test
    public void testFindByName() {
        // Expected person with name "John Doe"
        Person expectedPerson = new Person(1, "John Doe", 30, "Engineer");

        // Find person by name "John Doe"
        Person foundPerson = personList.findByName("John Doe");

        // Assert that foundPerson matches expectedPerson
        assertEquals(expectedPerson, foundPerson, "Person objects should be equal");
    }
    @Test
    public void testFindByName_invalid() {
        // Test with improperly formatted name (missing space)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            personList.findByName("JohnDoe");
        });

        assertEquals("Name must be formatted as 'firstName lastName'", exception.getMessage(),
                "Exception message should be specific to name formatting");

        // Test with null name
        IllegalArgumentException exceptionNull = assertThrows(IllegalArgumentException.class, () -> {
            personList.findByName(null);
        });

        assertEquals("Name cannot be null", exceptionNull.getMessage(),
                "Exception message should indicate that name cannot be null");
    }
    @Test
    public void testClonePerson() {
        // Create an original person with known properties
        Person originalPerson = new Person(1, "John Doe", 30, "Engineer");

        // Clone the person using the clonePerson method
        Person clonedPerson = personList.clonePerson(originalPerson);

        // Assert that the cloned person is equal to the original except for the ID
        assertEquals(originalPerson, clonedPerson, "Cloned person should have the same properties as original except ID");
    }


}