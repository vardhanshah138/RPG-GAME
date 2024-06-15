package org.example.models;

public abstract class Character {

    private String name;
    private int health;
    private boolean isAlive;
    private int fistPower;
    private String introMessage;
    public Character(String name, int health, int fistPower, String introMessage) {
        this.name = name;
        this.health = health;
        this.fistPower = fistPower;
        this.introMessage = introMessage;
        this.isAlive = true;
    }

    public void attack(Character character){
        System.out.println("The " + this.name + " attack on " + character.getName());
        if(this.isAlive){
            System.out.println("The " + this.name + " attacked on " + character.getName() + "with fist");
            character.reduceHealth(this.fistPower);
        }else{
            System.out.println(name + " is not alive to attack.");
        }
    }

    public void attack(Character character, Weapon weapon) {
        System.out.println("The " + this.name + " attack on " + character.getName() + " with weapon " + weapon.getName());
        character.reduceHealth(weapon.getDamage());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getIntroMessage() {
        return introMessage;
    }

    public void setIntroMessage(String introMessage) {
        this.introMessage = introMessage;
    }


    public void reduceHealth(int damage){//if we won't make it private then player can reduce health without attacking
        System.out.println("The " + name + " health has been reduced by " + damage);
        if(damage > 0){
            this.health = health - damage;
            if(health <= 0){
                System.out.println("The " + this.name + " is dead.");
                this.isAlive = false;
            }
        }
    }

    public void increaseHealth(int medicine){
        System.out.println("The " + this.name + " health has been increased by " + health);
        if(medicine > 0){
            setHealth(health + medicine);
        }
    }

    public int getFistPower() {
        return fistPower;
    }

    public void setFistPower(int fistPower) {
        this.fistPower = fistPower;
    }
    public boolean isAlive() {
        return isAlive;
    }
}
