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

        Enemy zombie = new Enemy("Zombie", 50,3, "I am a brain dead Zombie I will eat you alive and make you zombie");
        Enemy whiteWalker = new Enemy("White walker", 50, 5, "I stayed in Ice and king in the north afraids of me");
        Enemy alien = new Enemy("Alien", 50, 12, "I came from outer space and i have super weapons");
        Enemy akatsuki = new Enemy("Akatsuki", 50,15, "I am a rogue ninja and abaonded the village after killing the whole clan.");

        Room room = new Room("City");
        room.addEnemy(zombie);
        Player vardhan = new Player("Vardhan",100, 5, "I am Vardhan Shah from Surat great fighter and coder.");

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