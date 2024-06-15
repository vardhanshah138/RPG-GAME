package org.example.models.Item;

import org.example.models.Item.Item;

public class Weapon extends Item {
    private int damage;
    public Weapon(String name, int damage) {
        super(name, ItemType.WEAPON);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
