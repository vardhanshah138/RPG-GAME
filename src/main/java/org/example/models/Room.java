package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private List<Character> roomMembers;
    private List <Item> items;

    public Room(String name) {
        this.name = name;
        this.roomMembers = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Character> getRoomMembers() {
        return roomMembers;
    }

    public void setRoomMembers(List<Character> roomMembers) {
        this.roomMembers = roomMembers;
    }

    public void addEnemy(Enemy enemy){
        roomMembers.add(enemy);
        System.out.println("Added enemy " + enemy.getName());
    }
    public void addItem(Item item){
        items.add(item);
        System.out.println("Added item " + item.getName());
    }

    public void removeItem(Item item){
        if(items.contains(item)){
            items.remove(item);
            System.out.println("Removed item " + item.getName());
        }else {
            System.out.println("The item " + item.getName()  + " is not present");
        }
    }

    public void printRoomElements(){
        printCharacter();
        printItem();
    }

    public void printCharacter() {
        roomMembers.forEach((character) -> System.out.println("The character " + character.getName() + " in the room " + name));
    }

    public void printItem() {
        items.forEach((item) -> System.out.println("The item " + item.getName() + " in the room " + name));
    }

    public boolean isRoomEnemyDead(){
        return !roomMembers.stream().anyMatch(character -> character.getClass().equals(Enemy.class) && character.isAlive());
    }
}
