package org.example.models;

public class Player extends Character{
    private int experiencePoints;
    public Player(String name, int health) {
        super(name, health);
        this.experiencePoints = 0;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }
}
