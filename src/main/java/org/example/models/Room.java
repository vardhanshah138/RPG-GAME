package org.example.models;

import org.example.models.Character.Character;
import org.example.models.Character.Enemy;
import org.example.models.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private List<Enemy> enemies;
    private Character Guardian;
    private List <Item> items;

    public Room(String name) {
        this.name = name;
        this.enemies = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }
    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        if(items.contains(item)){
            items.remove(item);
        }else {
            System.out.println("The item " + item.getName()  + " is not present");
        }
    }

    public void printRoomElements(){
        printCharacter();
        printItem();
    }

    public void printCharacter() {
        enemies.forEach((character) -> System.out.println("The character " + character.getName() + " in the room " + name));
    }

    public void printItem() {
        items.forEach((item) -> System.out.println("The item " + item.getName() + " in the room " + name));
    }

    public boolean isRoomEnemyDead(){
        return !enemies.stream().anyMatch(character -> character.isAlive());
    }

    public Character getGuardian() {
        return Guardian;
    }

    public void setGuardian(Character guardian) {
        Guardian = guardian;
    }
}
