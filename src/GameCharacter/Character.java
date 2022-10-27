package GameCharacter;

import java.util.ArrayList;

public class Character {
    protected String name;
    protected int life;
    public ArrayList<String> items = new ArrayList<String>();

    // Constructor
    public Character() {
        this.name = "you";
        this.life = 100;

        for (int i = 0; i < 3; i++) {
            items.add("portion");
        }
    }

    public void attack(Character character, int damage) {
        character.life -= damage;
    }

    public String getName() {
        return this.name;
    }

    public int getLife() {
        return this.life;
    }

    public int getItemsSize() {
        return this.items.size();
    }

    public void addLife() {
        this.life += 50;
    }

    public void removeItem() {
        this.items.remove(0);
    }
}
