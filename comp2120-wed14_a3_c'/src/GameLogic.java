/**
 * The GameLogic class is relevant to Ayush's GameLogic.java file,and might need to be moved to that file, need to merge or rebase.
 *
 * @author Cara Chen and Rhonda Luu
 * @date September 16th, 2024
 * @version V0.4
 */
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private Character player;
    private Character monster;
    private Character sorcerer;

    /**
     * The method initialises the character's attributes and handles the game logic for battling enemies.
     *
     * @param isHardMode A boolean representing if the Hard difficulty level has been selected
     *
     * @author Cara Chen and Rhonda Luu
     * @date September 16th, 2024
     * @version V0.4
     */
    public GameLogic(boolean isHardMode) {
        System.out.println("Choose a playing character: Press 1 for Adventurer or 2 for Archer");
        Scanner scanner = new Scanner(System.in); //Create scanner object for user's input
        int characterSelected = scanner.nextInt(); //Read the user's input
        /* Initialise the Player's health and attack power based on difficulty level and character selected:
         * If easy and adventurer is selected, then the player's health is 10 and attack power is 1.
         * If hard and adventurer is selected, then the player's health is 10 and attack power is 2.
         * If easy and archer is selected, then the player's health is 10 and attack power is 2 (Two times the attack
         * power of the adventurer (1) since the archer can attack from a distance.)
         * If hard and archer is selected, then the player's health is 10 and attack power is 4 (Two times the attack
         * power of the adventurer (2) since the archer can attack from a distance.)
         */
        int initialHealth = 10;
        int initialAttackPower = isHardMode ? 2 : 1;
        if (characterSelected == 1) {
            this.player = new Character("adventurer",initialHealth, initialAttackPower, "player", isHardMode);
        } else {
            this.player = new Character("archer", initialHealth, initialAttackPower*2, "player", isHardMode);
        }

        /* Initialise the Monster's health and attack power for Act Two based on difficulty level:
         * If easy, Monster's health is 2 and attack power is 2.
         * If hard, Monster's health is 4 and attack power is 4.
         */
        int monsterHealth = isHardMode ? 4 : 2;
        int monsterAttackPower = isHardMode ? 4 : 2;
        this.monster = new Character("monster", monsterHealth, monsterAttackPower,"enemy",isHardMode);

        /* Initialise the Sorcerer's health and attack power for Act Three based on difficulty level:
         * If easy, Sorcerer's health is 5 and attack power is 5.
         * If hard, Sorcerer's health is 10 and attack power is 6.
         */
        int sorcererHealth = isHardMode ? 10 : 5;
        int sorcererAttackPower = isHardMode ? 6 : 5;
        this.sorcerer = new Character("sorcerer", sorcererHealth, sorcererAttackPower, "enemy", isHardMode);
    }

    /**
     * This method manages the gameplay for Act Two of the game where the Player battles the Monster.
     * The Player is given a choice to either attack the Monster or flee the battle.
     *
     * If the Player chooses to attack the Monster, the method facilitates a turn-based battle between the Player and
     * Monster.
     * If the Player defeats the Monster, their attack power will increase by 2.
     * If the Player is playing the Hard Difficulty Level, the Player will also encounter a lost soul who will bless
     * them with a health potion to add to their inventory.
     *
     * If the Monster defeats the Player, the Player will die and must press R to restart.
     *
     * @param isHardMode A boolean representing if the Hard difficulty level has been selected
     *
     * @author Cara Chen and Rhonda Luu
     * @date September 16th, 2024
     * @version V0.2
     */
    public void playActTwo(boolean isHardMode) {
        System.out.println("Act 2 begins...");
        Scanner scanner = new Scanner(System.in); //Create scanner object for user's input
        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            System.out.println("PRESS 1 to Attack or 2 to Flee.");
            int input = scanner.nextInt(); //Read the user's input
            // Handle different inputs based on Player's choices when faced with the Monster
            switch (input) {
                case 1:
                    player.attack(player, monster);
                    break;
                case 2:
                    System.out.println("You have fled the battle. Press R to restart.");
                    return;
                default:
                    System.out.println("Invalid input. Please PRESS 1 to Attack or 2 to Flee");
                    continue;
            }

            /* Check if the Monster is still alive after attack from the Player:
             * If Monster is defeated:
             * Increase the Player's attack power by 2 as a reward
             * If the difficulty level is Hard, add a health potion to the Player's inventory
             */
            if (monster.getHealth() <= 0) {
                System.out.println("Monster defeated!");
                player.setAttackPower(player.getAttackPower()+2); // increase the Player's attack power by 2
                if (isHardMode) {
                    player.encounterLostSoul(player); //acquire a health potion only if difficulty level is hard
                }
                System.out.println("Monster defeated! Attack power increased to: " + player.getAttackPower());
                return;
            }

            // Monster attacks Player if the Player is still alive
            monster.attack(monster, player);

            // Checks to see if the Player is still alive after attack from the Monster
            if (player.getHealth() <= 0) {
                System.out.println("You have died in battle. Press R to restart.");
                return; // Exit the method if the Player has died
            }
        }
    }

    /**
     * This method manages the gameplay for Act Three of the game where the Player battles the Sorcerer.
     * The Player is given a choices to either attack the Monster, flee the battle or use a health potion to fully
     * restore their health (only if they have a health potion in their inventory).
     *
     * If the Player chooses to attack the Sorcerer, the method facilitates a turn-based battle between the Player and
     * Sorcerer.
     * If the Player defeats the Sorcerer, they will only win the game if the Sorcerer drops the Heart of Eternity.
     * The chance of the Sorcerer dropping the Heart of Eternity is based on the generation of a random number between 0
     * and 1.
     * If 0, the Sorcerer has not dropped the Heart of Eternity and the Player must press R to restart.
     * If 1, the Sorcerer has dropped the Heart of Eternity and the Player wins the game.
     *
     * If the Sorcerer defeats the Player, the Player will die and must press R to restart.
     *
     * @author Cara Chen and Rhonda Luu
     * @date September 16th, 2024
     * @version V0.2
     */
    public void playActThree() {
        System.out.println("Act 3 begins...");
        Scanner scanner = new Scanner(System.in); //Create scanner object for user's input
        while (player.getHealth() > 0 && sorcerer.getHealth() > 0) {
            // Only display option 3 to use health potion if the player has a health potion in their inventory
            System.out.println("PRESS 1 to Attack" + (player.getInventory().hasHealthPotion() ? " or 3 to use Health " +
                    "Potion." : "") + " or 2 to Flee.");
            int input = scanner.nextInt(); //Read the user's input
            // Handle different inputs based on Player's choices when faced with the Sorcerer
            switch (input) {
                case 1:
                    player.attack(player, sorcerer);
                    break;
                case 2:
                    System.out.println("You have fled the battle. Press R to restart.");
                    return;
                case 3:
                    if (player.getInventory().hasHealthPotion()) {
                        player.getInventory().useHealthPotion(player); // fully restores the Player's health to 10
                        player.getInventory().removeHealthPotion(); // remove the health potion from the Player's inventory when used
                    } else {
                        System.out.println("You have no health potions in your inventory.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please PRESS 1 to Attack " + (player.getInventory().hasHealthPotion()
                            ? " or 3 to use Health Potion." : "") + " or 2 to Flee.");
                    continue;
            }
            // Check is the Sorcerer is still alive after attack from the Player
            if (sorcerer.getHealth() <= 0) {
                System.out.println("Sorcerer defeated!");

            /* Generate a random integer between 0 and 1 to represent a random chance that the Sorcerer does not drop
            the Heart of Eternity. */
                Random random = new Random();
                int randomInt = random.nextInt(2);
                // If the integer = 1, then the Sorcerer has dropped the Heart of Eternity
                if (randomInt == 1) {
                    // If the integer = 0, then the Sorcerer has not dropped the Heart of Eternity
                    player.getInventory().acquireHeartOfEternity();
                    System.out.println("Congratulations! The Sorcerer has dropped the Heart of Eternity. The Heart of " +
                            "Eternity has been added to your inventory.");
                } else {
                    System.out.println("The Sorcerer has not dropped the Heart of Eternity! Press R to restart.");
                }
                return;
            }

            // Sorcerer attacks Player if the Player is still alive
            sorcerer.attack(sorcerer, player);

            // Checks to see if the Player is still alive after attack from the Sorcerer
            if (player.getHealth() <= 0) {
                System.out.println("You have died in battle. Press R to restart.");
                return; // Exit the method if the Player has died
            }
        }
    }
}