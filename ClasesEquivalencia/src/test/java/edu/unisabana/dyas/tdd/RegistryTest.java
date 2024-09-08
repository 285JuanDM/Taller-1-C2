package edu.unisabana.dyas.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.unisabana.dyas.tdd.registry.Gender;
import edu.unisabana.dyas.tdd.registry.Person;
import edu.unisabana.dyas.tdd.registry.RegisterResult;
import edu.unisabana.dyas.tdd.registry.Registry;

public class RegistryTest {
    Registry registry = new Registry();
    RegisterResult result;

    @Test
    public void validateRegistryResult() {
        Person validPerson = new Person("Laura", 4, 30, Gender.FEMALE, true);
        result = registry.registerVoter(validPerson);
        assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateInvalidAge() {
        Person invalidateAgePerson = new Person("Maria", 3, -1, Gender.FEMALE, true);
        result = registry.registerVoter(invalidateAgePerson);
        assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateUnderage() {
        Person underagePerson = new Person("Juan", 3, 10, Gender.MALE, true);
        result = registry.registerVoter(underagePerson);
        assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateDeadPerson() {
        Person deadPerson = new Person("Juan", 1, 25, Gender.MALE, false);
        result = registry.registerVoter(deadPerson);
        assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validateDuplicatedPerson() {
        Person firstPerson = new Person("Carlos", 5, 40, Gender.MALE, true);
        registry.registerVoter(firstPerson);
        result = registry.registerVoter(firstPerson);
        assertEquals(RegisterResult.DUPLICATED, result);
    }
}
