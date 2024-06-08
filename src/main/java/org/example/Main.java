package org.example;

import org.example.models.*;
import org.example.models.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        Scanner sc = new Scanner(System.in);

        Enemy zombie = new Enemy("Zombie", 50);
        Enemy whiteWalker = new Enemy("White walker", 50);
        Enemy alien = new Enemy("Alien", 50);
        Enemy akatsuki = new Enemy("Akatsuki", 50);

        Room room = new Room("City");
        room.addEnemy(zombie);
        Player vardhan = new Player("Vardhan",100);

        while(vardhan.isAlive() && zombie.isAlive()){
            System.out.println("Press 1 to attack.");
            if(sc.nextInt() == 1){
                vardhan.attack(zombie);
            }
            zombie.attack(vardhan);
        }

        //Item in the room test.
        Key key = new Key("Key");
        Poison poison = new Poison("Sulphur acid",5);
        Potion potion = new Potion("Medicine", 10);
        room.addItem(key);
        room.addItem(poison);
        room.addItem(potion);
        room.printRoomElements();
    }
}