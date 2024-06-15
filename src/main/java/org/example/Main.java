package org.example;
//retreive enemys from character list was an issue

import org.example.models.*;
import org.example.models.Character.Enemy;
import org.example.models.Character.Player;
import org.example.models.Item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        Player vardhan = new Player("Vardhan",100, 5, "I am Vardhan Shah from Surat great fighter and coder.");
        //Room initalization
        List<Room> rooms = prepareRooms();

        while (vardhan.isAlive()){
            System.out.println("Select room to enter.");
            Room currRoom = printAndSelectRoom(rooms);
            currRoom.printRoomElements();

            int attackResponse = runOrFight();

            if(attackResponse == 1){//run
                //continue
            } else if (attackResponse == 2) {
                //battle.
                Enemy enemy = currRoom.getEnemies().get(0);

            }else {
                //quit
            }

        }
    }

    public static Weapon selectWeaponFromBag(Player player) {
        List<Item> bag = player.getBag();
        for(Item item : bag){
            if(item.getType().equals(ItemType.WEAPON)){
                return (Weapon) item;
            }
        }
        return null;
    }
    public static BattleResult battle(Player player, Enemy enemy){
        Scanner sc = new Scanner(System.in);
        while (player.isAlive() && enemy.isAlive()){
            player.printCurrStats();
            System.out.println("1. Attack");
            System.out.println("2. Attack with weapon");
            System.out.println("3. Run");
            System.out.println("4. Drink Potion");
            int response = sc.nextInt();

            if(response == 3){
                return BattleResult.RUN;
            } else if (response == 2) {
                player.attack(enemy);
            }else if(response == 1) {
                Weapon weapon = selectWeaponFromBag(player);
                player.attack(enemy, );
            } else if (response == 4) {

            }
        }
    }

    public static int runOrFight(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select option :-");
        System.out.println("1. Fight with the enemy.");
        System.out.println("2. Run.");
        System.out.println("3. Quit");
        int attackResponse = sc.nextInt();
        return attackResponse;
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

    public static List<Room> prepareRooms(){
        List<Room> rooms = new ArrayList<>();
        //Weapon
        Bow bow = new Bow("bow", 10, 50);
        Sword sword = new Sword("Knife", 5);
        Bow enemyBow = new Bow("Enemy bow", 10, 50);
        Sword enemySword = new Sword("Enemy Knife", 5);

        //Drinks
        Potion medicine = new Potion("Medicine", 5);//city
        Potion antibiotics = new Potion("Antibiotics", 10);//north islsn
        Poison poison = new Poison("Medicine", 15);//dessert
        Poison trap = new Poison("Trap", 15);//village
        //Treasure
        Treasure gold = new Treasure("Gold coins", 50);//dessert
        Treasure silver = new Treasure("Silver coins", 20);//north island
        //Key
        Key key = new Key("Key to win the game");//village

        //Enemys
        Enemy zombie = new Enemy("Zombie", 50,3, "I am a brain dead Zombie I will eat you alive and make you zombie");
        Enemy whiteWalker = new Enemy("White walker", 50, 5, "I stayed in Ice and king in the north afraid of me");
        Enemy alien = new Enemy("Alien", 50, 12, "I came from outer space and i have super weapons", enemyBow);
        Enemy akatsuki = new Enemy("Akatsuki", 50,15, "I am a rogue ninja and abaonded the village after killing the whole clan.",enemySword);


        Room city = new Room("City");
        city.addItem(bow);
        city.addItem(medicine);
        city.addItem(gold);
        city.addEnemy(zombie);

        Room desert = new Room("Dessert");
        desert.addItem(poison);
        desert.addEnemy(alien);

        Room northIsland = new Room("Snow Island");
        northIsland.addItem(antibiotics);
        northIsland.addItem(sword);
        northIsland.addItem(silver);
        northIsland.addEnemy(whiteWalker);

        Room village = new Room("Village");
        village.addItem(key);
        village.addItem(trap);
        village.addEnemy(akatsuki);

        rooms.addAll(List.of(city, desert, northIsland, village));
        return rooms;
    }
}