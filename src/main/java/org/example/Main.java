package org.example;

import org.example.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Room initalization
        List<Room> rooms = new ArrayList<>();
        Room currRoom = null;

        Room city = new Room("City");
        Room desert = new Room("Dessert");
        Room northIsland = new Room("Snow Island");
        Room village = new Room("Village");

        rooms.addAll(List.of(city, desert, northIsland, village));

        System.out.println("Select room to enter.");
        currRoom = printAndSelectRoom(rooms);

        Enemy zombie = new Enemy("Zombie", 50,3, "I am a brain dead Zombie I will eat you alive and make you zombie");
        Enemy whiteWalker = new Enemy("White walker", 50, 5, "I stayed in Ice and king in the north afraids of me");
        Enemy alien = new Enemy("Alien", 50, 12, "I came from outer space and i have super weapons");
        Enemy akatsuki = new Enemy("Akatsuki", 50,15, "I am a rogue ninja and abaonded the village after killing the whole clan.");

        Player vardhan = new Player("Vardhan",100, 5, "I am Vardhan Shah from Surat great fighter and coder.");


    }

    public static Room printAndSelectRoom(List<Room> rooms){
        Scanner sc = new Scanner(System.in);
        System.out.println("Here are the room details please select room in 0 based indexing.");
        rooms.forEach(room -> System.out.println(room.getName()));
        int roomIndex = sc.nextInt();
        while (!(roomIndex >= 0 && roomIndex < rooms.size())) {
            System.out.println("Please Enter correct room index");
            roomIndex = sc.nextInt();
        }
        Room currRoom = rooms.get(roomIndex);
        System.out.println("Please enter in room "+ currRoom.getName());
        return currRoom;
    }
}