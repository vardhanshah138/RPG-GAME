package org.example.models.Item;

import org.example.models.Item.Item;

public class Treasure extends Item {
    int points;
    public Treasure(String name, int points) {
        super(name, ItemType.OTHER);
        this.points = points;
    }
    public int getPoints() {
        return points;
    }
}
