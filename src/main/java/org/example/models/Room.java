package org.example.models;

import java.util.List;

public class Room {

    private String name;
    private List<Character> roomMembers;

    public Room(String name, List<Character> roomMembers) {
        this.name = name;
        this.roomMembers = roomMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Character> getRoomMembers() {
        return roomMembers;
    }

    public void setRoomMembers(List<Character> roomMembers) {
        this.roomMembers = roomMembers;
    }
}
