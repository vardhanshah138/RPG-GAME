package org.example.models.Item;

import org.example.models.Character.Character;
import org.example.models.Item.Item;

public abstract class Drink extends Item {
    int power;

    public Drink(String name, int power) {
        super(name, ItemType.DRINK);
        this.power = power;
    }

    public abstract void affectHealth(Character character);
}
