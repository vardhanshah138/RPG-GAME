package org.example;

import org.example.models.Character;
import org.example.models.Enemy;
import org.example.models.Player;
import org.example.models.Room;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        Enemy zombie = new Enemy("Zombie", 50);
        Enemy whiteWalker = new Enemy("White walker", 50);
        Enemy alien = new Enemy("Alien", 50);
        Enemy akatsuki = new Enemy("Akatsuki", 50);

        List<Character> cityRoomEnemies = new ArrayList<>();
        cityRoomEnemies.add(zombie);
        cityRoomEnemies.add(alien);
        Room room = new Room("City", cityRoomEnemies);
        Player vardhan = new Player("Vardhan",100);

        System.out.println("The enemies in the room city. " + room.getRoomMembers());
        vardhan.attack(room.getRoomMembers().get(0));
        room.getRoomMembers().get(0).attack(vardhan);
        System.out.println(zombie.getHealth());

    }
}