package org.example.models;

public class Enemy extends Character{
    private Weapon weapon;
    public Enemy(String name, int health, int fistPower, String message) {
        super(name, health, fistPower, message);
    }

    public Enemy(String name, int health, int fistPower, String message, Weapon weapon) {
        super(name, health, fistPower, message);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }


}
