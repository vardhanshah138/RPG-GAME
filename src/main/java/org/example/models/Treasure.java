package org.example.models;

public class Treasure extends Item{
    int points;
    public Treasure(String name, int points) {
        super(name);
        this.points = points;
    }
    public int getPoints() {
        return points;
    }
}
