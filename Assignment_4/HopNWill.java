package Assignment_4;

import java.util.Scanner;

public class HopNWill {

    private final static Scanner sc  = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        int lengthOfGame = 20;
        int trials = 5;
        System.out.print("\nHit enter to initialize the game");
        sc.nextLine();

        Game game = new Game(lengthOfGame, trials);
        game.playGame();
    }
}
