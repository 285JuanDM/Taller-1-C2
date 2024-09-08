package edu.unisabana.dyas.tdd.registry;

import java.util.ArrayList;

public class Registry {

    private ArrayList<Integer> registeredVoters = new ArrayList<>();

    public RegisterResult registerVoter(Person person) {
        if (!person.isAlive()) {
            return RegisterResult.DEAD;
        }
        if (person.getAge() < 0 || person.getAge() > 120) {
            return RegisterResult.INVALID_AGE;
        }
        if (person.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }
        if (registeredVoters.contains(person.getId())) {
            return RegisterResult.DUPLICATED;
        }

        registeredVoters.add(person.getId());
        return RegisterResult.VALID;
    }
}