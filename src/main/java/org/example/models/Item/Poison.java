package org.example.models.Item;

import org.example.models.Character.Character;

public class Poison extends Drink{
    public Poison(String name, int power) {
        super(name, power);
    }

    @Override
    public void affectHealth(Character character) {
        System.out.println("The " + character.getName() + " is drinking poison");
        character.reduceHealth(power);
    }
}
