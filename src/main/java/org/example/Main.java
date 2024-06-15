package org.example;
//retreive enemys from character list was an issue

import org.example.models.*;
import org.example.models.Character.Character;
import org.example.models.Character.Enemy;
import org.example.models.Character.Player;
import org.example.models.Item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc =new Scanner(System.in);

    public static void main(String[] args) {
        Player vardhan = new Player("Vardhan",100, 15, "I am Vardhan Shah from Surat great fighter and coder.");
        //Room initalization
        List<Room> rooms = prepareRooms();

        while (vardhan.isAlive() && vardhan.getBag().stream().noneMatch(item -> item instanceof Key)){
            System.out.println("Select room to enter.");
            Room currRoom = printAndSelectRoom(rooms);
            currRoom.printRoomElements();
            Boolean isCurrEnemyDead = currRoom.isRoomEnemyDead();
            int attackResponse = runOrFight(isCurrEnemyDead);
            BattleResult battleResult = null;
            if(attackResponse == 2){//run
                continue;
            } else if (attackResponse == 1) {
                //battle.
                if(!currRoom.isRoomEnemyDead()){
                    Enemy enemy = currRoom.getEnemies().get(0);
                    battleResult= battle(vardhan, enemy);
                }
            }else {
                break;
            }

            if(battleResult == BattleResult.LOSE){
                System.out.println("The player is dead now");
                break;
            } else if (battleResult == BattleResult.WIN) {
                currRoom.removeEnemy(currRoom.getEnemies().get(0));
                System.out.println("The enemy is dead now");
            }else if(battleResult == BattleResult.RUN) {
                continue;
            }
            collectItemFromRoom(currRoom, vardhan);
            if(currRoom.getGuardian() != null){
                interactWithGuardianIfPresent(currRoom);
            }

        }

        if(vardhan.getBag().stream().anyMatch(item -> item instanceof Key)){
            System.out.println("Congratulations you win the game");
        }else {
            System.out.println("GAME OVER");
        }
    }

    public static void interactWithGuardianIfPresent(Room room){
        System.out.println("Enter 1 to reveal hint for key");
        int g = sc.nextInt();
        if(g == 1){
            Character guardian = room.getGuardian();
            System.out.println(guardian.getIntroMessage());
        }
    }
    public static void collectItemFromRoom(Room room, Player player) {
        room.printRoomElements();
        System.out.println("Please Enter index to pick item or -1 to leave room");
        int i = sc.nextInt();

        while (i>=0 && i < room.getItems().size()){
            Item item = room.getItems().get(i);
            if(item.getClass().equals(Poison.class)){
                player.consumeDrink((Drink) item);
            }else if(item instanceof Treasure){
                player.setExperiencePoints(player.getExperiencePoints() + ((Treasure) item).getPoints());
            }else {
                player.addItemInBag(item);
            }
            room.removeItem(item);
            i = sc.nextInt();
        }
    }
    public static void consumePotionFromBag(Player player) {
        System.out.println("Select potion from bag.");
        List<Item> bag = player.getBag();
        for(Item item : bag){
            if(item.getType().equals(ItemType.DRINK)){
                System.out.println(bag.indexOf(item) + item.getName());
            }
        }
        System.out.println("Enter your response:-");
        int w = sc.nextInt();
        if(w == -1){
            return;
        }
        while (!(w >= 0 && w < bag.size())){
            System.out.println("Please enter correct index");
            w = sc.nextInt();
        }
        Item item = bag.get(w);
        player.consumeDrink((Drink) item);
        player.removeItemFromBag(item);
    }

    public static Weapon selectWeaponFromBag(Player player) {
        System.out.println("Select weapon from bag based on 0 index");
        boolean weaponPresent = false;
        List<Item> bag = player.getBag();
        for(Item item : bag){
            if(item.getType().equals(ItemType.WEAPON)){
                System.out.println(bag.indexOf(item) + item.getName());
                weaponPresent = true;
            }
        }
        if (!weaponPresent){
            return null;
        }
        System.out.println("Enter your response:-");
        int w = sc.nextInt();
        while (!(w >=0 && w < bag.size())){
            System.out.println("Please enter correct index");
            w = sc.nextInt();
        }
        return (Weapon) bag.get(w);
    }
    public static BattleResult battle(Player player, Enemy enemy){
        System.out.println(player.getIntroMessage());
        System.out.println(enemy.getIntroMessage());
        while (player.isAlive() && enemy.isAlive()){
            player.printCurrStats();
            System.out.println("1. Attack");
            System.out.println("2. Attack with weapon");
            System.out.println("3. Run");
            System.out.println("4. Drink Potion");
            int response = sc.nextInt();

            if(response == 3){
                return BattleResult.RUN;
            } else if (response == 1) {
                player.attack(enemy);
            }else if(response == 2) {
                Weapon weapon = selectWeaponFromBag(player);
                if(weapon == null){
                    player.attack(enemy);
                }else {
                    player.attack(enemy, weapon);
                }
            } else if (response == 4) {
                consumePotionFromBag(player);
            }

            if(response % 2 == 0){
                enemy.attack(player, enemy.getWeapon());
            }else{
                enemy.attack(player);
            }
        }
        if(player.isAlive()){
            return BattleResult.WIN;
        }else {
            return BattleResult.LOSE;
        }
    }

    public static int runOrFight(Boolean isRoomEnemyDead){
        System.out.println("Select option :-");
        System.out.println(!isRoomEnemyDead ? "1. Fight with the enemy." : "Collect Item or interact");
        System.out.println("2. Run.");
        System.out.println("3. Quit");
        return sc.nextInt();
    }

    public static Room printAndSelectRoom(List<Room> rooms){
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
        Character character = new Player("Advisor", 2,2,"The secerts are hidden at country end but beware of sand");


        Room city = new Room("City");
        city.addItem(bow);
        city.addItem(medicine);
        city.addItem(gold);
        city.addEnemy(zombie);
        city.setGuardian(character);

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

        return new ArrayList<>(List.of(city, desert, northIsland, village));
    }
}