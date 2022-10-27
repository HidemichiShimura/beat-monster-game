package Utility;

import java.util.Scanner;
import Exception.*;

public class Utility {
    public static void displayStartMenu() {
        System.out.println("╋━━━━━━━━━━╋");
        System.out.println("┃GAME START┃");
        System.out.println("╋━━━━━━━━━━╋");
    }

    public static void displayDifficulty() {
        System.out.println("┏━━━━━━━━━━┓");
        System.out.println("┃DIFFICULTY┃");
        System.out.println("┃━━━━━━━━━━┃");
        System.out.println("┃  easy    ┃");
        System.out.println("┃  normal  ┃");
        System.out.println("┃  hard    ┃");
        System.out.println("┗━━━━━━━━━━┛");
    }

    public static void displayTurn(int turnNum) {
        System.out.println("┏━━━━━━━━━━┓");
        System.out.println("TURN " + turnNum);
        System.out.println("┗━━━━━━━━━━┛");
    }

    public static void displayAction() {
        System.out.println("┏━━━━━━━━━━┓");
        System.out.println("┃  ACTION  ┃");
        System.out.println("┃━━━━━━━━━━┃");
        System.out.println("┃  attack  ┃");
        System.out.println("┃  item    ┃");
        System.out.println("┃  nothing ┃");
        System.out.println("┗━━━━━━━━━━┛");
    }

    public static void displayThankyou() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃THANK YOU FOR PLAYING !┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
}