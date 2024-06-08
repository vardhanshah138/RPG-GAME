package org.example.models;

public abstract class Drink extends Item{
    int power;

    public Drink(String name, int power) {
        super(name);
        this.power = power;
    }

    abstract void affectHealth(Character character);
}
