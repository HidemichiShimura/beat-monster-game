package GameCharacter;

public class Monster extends Character {
    public Monster(String mode) {
        name = "monster";

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
}
