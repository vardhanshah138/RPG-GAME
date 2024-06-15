package org.example.models.Item;

import org.example.models.Item.Weapon;

public class Bow extends Weapon {
    private int noOfArrows;
    public Bow(String name, int damage, int noOfArrows) {
        super(name, damage);
        this.noOfArrows = noOfArrows;
    }

    public int getNoOfArrows() {
        return noOfArrows;
    }

    public void setNoOfArrows(int noOfArrows) {
        this.noOfArrows = noOfArrows;
    }

    public void shoot() {
        if(noOfArrows < 0){
            noOfArrows = noOfArrows - 1;
            System.out.println("The ammo has been reduced " + (noOfArrows - 1));
        }else {
            System.out.println("The weapon is out of ammo");
        }
    }

}
