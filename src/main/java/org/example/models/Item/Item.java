package org.example.models.Item;

public abstract class Item {

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public Item(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }

    private String name;
    private ItemType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
