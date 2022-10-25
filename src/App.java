import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final Random rand = new Random();
        String mode;

        // Display GAME START
        displayStartMenu();
        System.out.println();

        // Display difficulty options
        displayDifficulty();
        System.out.println();

        // Read difficulty from input
        while (true) {
            try {
                System.out.print("Difficulty : ");
                mode = sc.nextLine();

                // Throw SelectDifficultyException if an incorrect mode is entered
                if (!(mode.equals("easy") || mode.equals("normal") || mode.equals("hard"))) {
                    throw new SelectDifficultyException();
                }

                break;
            } catch (SelectDifficultyException e) {
                System.out.println("Enter a correct difficulty from the options above!");
            }
        }

        // Create 2 characters with the selected difficulty mode
        Character you = new Character();
        Character monster = new Character(mode);

        for (int i = 1;; i++) {
            String yourAction;
            String monsterAction;
            int damage = 0;
            int index;

            // Display the turn
            displayTurn(i);
            System.out.println();

            System.out.println("** Your life      : " + you.getLife());
            System.out.println("** Monster's life : " + monster.getLife());
            System.out.println();

            // Your turn
            System.out.println("= Your turn =");
            while (true) {
                try {
                    System.out.print("attack or nothing? : ");
                    yourAction = sc.nextLine();

                    // Throw SelectDifficultyException if an incorrect mode is entered
                    if (!(yourAction.equals("attack") || yourAction.equals("nothing"))) {
                        throw new CharacterActionException();
                    }

                    break;
                } catch (CharacterActionException e) {
                    System.out.println("Enter an action from the options above!");
                }
            }

            if (yourAction.equals("attack")) {
                damage = rand.nextInt(50);
                you.attack(monster, damage);
                System.out.println("You attacked Monster by " + damage);
            } else {
                System.out.println("You did nothing at this turn");
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

        System.out.println(you.getLife() > monster.getLife() ? "Yea! You WON!" : "Oops... You LOST!");
    }

    public static void displayStartMenu() {
        System.out.println("=====================");
        System.out.println("GAME START");
        System.out.println("=====================");
    }

    public static void displayDifficulty() {
        System.out.println("=====================");
        System.out.println("Select Difficulty");
        System.out.println();
        System.out.println("easy");
        System.out.println("normal");
        System.out.println("hard");
        System.out.println("=====================");
    }

    public static void displayTurn(int turnNum) {
        System.out.println("=====================");
        System.out.println("TURN " + turnNum);
        System.out.println("=====================");
    }
}
