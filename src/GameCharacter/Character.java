package GameCharacter;

public class Character {
    protected String name;
    protected int life;

    // Constructor
    public Character() {
        this.name = "you";
        this.life = 100;
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
}
