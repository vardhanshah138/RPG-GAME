package org.example.models;

public class Potion extends Drink{

    public Potion(int power) {
        super(power);
    }

    @Override
    public void affectHealth(Character character) {
        System.out.println("The " + character.getName() + " is drinking potion");
        character.increaseHealth(power);
    }
}
