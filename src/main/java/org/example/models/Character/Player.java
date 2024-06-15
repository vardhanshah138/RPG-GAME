package org.example.models.Character;

import org.example.models.Character.Character;
import org.example.models.Item.Drink;
import org.example.models.Item.Item;
import org.example.models.Item.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
    private int experiencePoints;
    private List<Item> bag;
    private final int bagCapacity = 5;
    private int currRoom;
    public Player(String name, int health, int fistPower, String message) {
        super(name, health, fistPower, message);
        this.experiencePoints = 0;
        this.bag = new ArrayList<>();
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getCurrRoom() {
        return currRoom;
    }

    public void setCurrRoom(int currRoom) {
        this.currRoom = currRoom;
    }

    public void consumeDrink(Drink drink){
        drink.affectHealth(this);
    }

    public void addItemInBag(Item item){
        if(bag.size() <= bagCapacity){
            System.out.println("The item has been added in the bag.");
            bag.add(item);
        }else {
            System.out.println("The bag capacity exceeds");
        }
    }

    public void removeItemFromBag(int index){
        if(bag.size() < index){
            System.out.println("No Item is present at this index.");
        }else {
            bag.remove(index);
            System.out.println("The item has been removed");
        }
    }

    public void removeItemFromBag(Item item){
        if(bag.contains(item)){
            bag.remove(item);
            System.out.println("The item from bag has been removed");
        }else {
            System.out.println("The item is not present in the bag.");
        }
    }

    public void printCurrStats(){
        System.out.println("--------------------------------");
        System.out.println("Name : " + getName());
        System.out.println("Health : " + getHealth());
        System.out.println("is Alive : " + isAlive());
        System.out.println("xp points : " + experiencePoints);
        System.out.println("--------------------------------");
    }

    public List<Item> getBag() {
        return bag;
    }

    @Override
    public void attack(Character character, Weapon weapon) {
        if(this.bag.contains(weapon)){
            System.out.println("The " + this.getName() + " attack on " + character.getName() + " with weapon " + weapon.getName());
            character.reduceHealth(weapon.getDamage());
        }else {
            System.out.println("The weapon is not present in the bag.");
        }
    }

}
