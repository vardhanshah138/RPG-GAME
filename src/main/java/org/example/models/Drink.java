package org.example.models;

public abstract class Drink extends Item{
    int power;

    public Drink(int power) {
        this.power = power;
    }

    abstract void affectHealth(Character character);
}
