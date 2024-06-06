package org.example.models;

public class Enemy extends Character{
    public Enemy(String name, int health) {
        super(name, health);
    }


    public void attack(Character character){//A subclass method will called
        System.out.println("The enemies cant attack now.");
    }
}
