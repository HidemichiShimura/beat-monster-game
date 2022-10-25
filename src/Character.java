public class Character {
    private int life;

    // Constructor
    Character() {
        this.life = 100;
    }

    Character(String mode) {
        switch (mode) {
            case "easy":
                this.life = 50;
                break;
            case "normal":
                this.life = 100;
                break;
            case "hard":
                this.life = 300;
                break;
        }
    }

    public void attack(Character character, int damage) {
        character.life -= damage;
    }

    public int getLife() {
        return this.life;
    }
}
