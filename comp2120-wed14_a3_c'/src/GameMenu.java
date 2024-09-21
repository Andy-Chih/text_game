/***
 * This class provides a terminal-based menu system for an RPG game set in the mystical kingdom of Aetheria.
 * It handles user inputs for starting the game, selecting the difficulty level, and exiting the program.
 * The game's progression, which is managed through this menu, involves battles and story progression based on the
 * chosen difficulty level.
 *
 * The menu interacts with the GameLogic class to initiate and manage game states, battles, and final outcomes.
 * It is designed to be easy to use and provides clear instructions and feedback to the player based on their inputs
 * and decisions throughout the game.
 *
 * Usage:
 * The user can start the game, select a difficulty, and proceed through the acts of the game directly from the terminal.
 * This class supports basic error handling to ensure that user inputs are validated before processing.
 *
 * @author: Cara Chen
 * @date: Sept 8th, 2024
 * @version: V2.0
 */


import java.util.Scanner;

public class GameMenu {
    private Scanner scanner;
    private boolean gameRunning;

    public GameMenu() {
        this.scanner = new Scanner(System.in);
        this.gameRunning = true;
    }

    public void displayMenu() {
        while (gameRunning) {
            System.out.println("\nWelcome to the Aetheria RPG Adventure!");
            System.out.println("1. Start New Game");
            System.out.println("2. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }

    private void startGame() {
        System.out.println("Choose Difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Hard");
        System.out.print("Select an option: ");

        int difficultyChoice = scanner.nextInt();
        boolean isHardMode = (difficultyChoice == 2);

        if (difficultyChoice == 1 || difficultyChoice == 2) {
            GameLogic gameLogic = new GameLogic(isHardMode);
            playGame(gameLogic);
        } else {
            System.out.println("Invalid choice. Please select a valid difficulty.");
        }
    }

    private void playGame(GameLogic gameLogic) {
        System.out.println("\nStarting your adventure in " + (gameLogic.isHardMode() ? "Hard" : "Easy") + " mode...");

        gameLogic.playActTwo();

        if (gameLogic.getPlayer().getHealth() > 0) {
            if (gameLogic.playFinalAct()) {
                System.out.println("\nCongratulations! You have retrieved the Heart of Eternity and saved Aetheria!");
            } else {
                System.out.println("\nYou have defeated the boss, but failed to retrieve the Heart of Eternity. Aetheria remains in peril...");
            }
        } else {
            System.out.println("\nYou have died in your quest. Aetheria remains in darkness.");
        }
    }

    public static void main(String[] args) {
        GameMenu menu = new GameMenu();
        menu.displayMenu();
    }
}
