import java.util.Scanner;
import GameCharacter.Character;
import GameCharacter.Monster;
import Exception.*;
import Utility.Utility;
import java.util.Random;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final Random rand = new Random();
        String difficulty;

        // Display GAME START
        Utility.displayStartMenu();
        System.out.println();

        // Display difficulty options
        Utility.displayDifficulty();
        System.out.println();

        // Read difficulty from input
        while (true) {
            try {
                System.out.print("DIFFICULTY : ");
                difficulty = sc.nextLine();

                // Throw SelectDifficultyException if an incorrect mode is entered
                if (!(difficulty.equals("easy") || difficulty.equals("normal") || difficulty.equals("hard"))) {
                    throw new SelectDifficultyException();
                }

                break;
            } catch (SelectDifficultyException e) {
                System.out.println("Enter a correct difficulty from the options above!");
            }
        }
        System.out.println();

        // Create 2 characters with the selected difficulty mode
        Character you = new Character();
        Monster monster = new Monster(difficulty);

        // Play
        for (int i = 1;; i++) {
            String yourAction;
            String monsterAction;
            int damage = 0;
            int index;

            // Display the turn
            Utility.displayTurn(i);
            System.out.println();

            System.out.println("** Your life      : " + you.getLife());
            System.out.println("** Monster's life : " + monster.getLife());
            System.out.println();

            // Your turn
            System.out.println("= Your turn =");
            while (true) {
                try {
                    Utility.displayAction();
                    System.out.print("ACTION : ");
                    yourAction = sc.nextLine();
                    System.out.println();

                    // Throw SelectDifficultyException if an incorrect mode is entered
                    if (!(yourAction.equals("attack") || yourAction.equals("item") || yourAction.equals("nothing"))) {
                        throw new CharacterActionException();
                    }

                    break;
                } catch (CharacterActionException e) {
                    System.out.println("Enter an action from the options above!");
                }
            }

            switch (yourAction) {
                case "attack":
                    damage = rand.nextInt(50);
                    you.attack(monster, damage);
                    System.out.println("You attacked Monster by " + damage);
                    break;
                case "item":
                    if (you.getItemsSize() == 0) {
                        System.out.println("You have already used up all of your potions!");
                    } else {
                        you.removeItem();
                        you.addLife();
                        System.out.println("You used one of your potions and restored your life by 50!");
                    }
                    break;
                case "nothing":
                    System.out.println("You did nothing at this turn");
                    break;
            }

            if (monster.getLife() <= 0) {
                break;
            }

            System.out.println();

            // Monster's turn
            System.out.println("= Monster's turn =");

            // Randomly pick a monster's action
            index = rand.nextInt(100);
            monsterAction = index > 50 ? "attack" : "nothing";

            if (monsterAction.equals("attack")) {
                damage = rand.nextInt(50);
                monster.attack(you, damage);
                System.out.println("Monster attacked you by " + damage);
            } else {
                System.out.println("Monster did nothing at this turn");
            }

            if (you.getLife() <= 0) {
                break;
            }

            System.out.println();
        }

        sc.close();

        System.out.println();
        System.out.println(you.getLife() > monster.getLife() ? "Yea! You WON!" : "Oops... You LOST!");
        System.out.println();
        Utility.displayThankyou();
    }
}
