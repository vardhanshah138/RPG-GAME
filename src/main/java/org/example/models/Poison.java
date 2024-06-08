package org.example.models;

public class Poison extends Drink{
    public Poison(int power) {
        super(power);
    }

    @Override
    void affectHealth(Character character) {
        System.out.println("The " + character.getName() + " is drinking poison");
        character.reduceHealth(power);
    }
}
