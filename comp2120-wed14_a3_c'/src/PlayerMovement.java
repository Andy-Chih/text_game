import java.util.Scanner;

/**
 * Handles the movement of the player within the maze.
 * 
 * @author Andy Chih
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */
public class PlayerMovement {
    private MazePanel maze;
    private int playerX;
    private int playerY;

    private Scanner scanner;

/**
 * 
 * @author Andy Chih
 * @date September 16, 2024
 * @version V0.1
 */
public PlayerMovement(int startX, int startY, MazePanel maze) {
    this.playerX = startX;
    this.playerY = startY;
    this.scanner = new Scanner(System.in);
    this.maze = maze;
}

/**
 * Resets the player's position to the given coordinates.
 * 
 * @param x The new X-coordinate of the player.
 * @param y The new Y-coordinate of the player.
 * 
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */

public void resetPosition(int x, int y) {
    this.playerX = x;
    this.playerY = y;
    maze.setPlayerPosition(x, y);
}

/**
 * 
 * @author Andy Chih
 * @date September 16, 2024
 * @version V0.1
 */
public void getPlayerInputAndMove() {
    System.out.println("Use ‘W’ ‘A’ ‘S’ ‘D’ to control the player's movement.");

    while (true) {
        maze.setPlayerPosition(playerX, playerY);
        maze.repaint();
        System.out.println("Current player position: " + getPosition());
        System.out.print("Please enter the direction of movement: ");
        String input = scanner.nextLine().toLowerCase();

        if (input.length() == 1) {
            move(input.charAt(0));
        } else {
            System.out.println("Invalid input, please enter W/A/S/D:");
        }
        if (maze.isExit(playerX, playerY)) {
            System.out.println("Congratulations! You've reached the exit!");
            break;
        }
    }
}


/**
 * Moves the player in the specified direction if the move is valid.
 * 
 * @author Andy Chih
 * @date September 16, 2024
 * @version V0.1
 */
public void move(char direction) {
    int newX = playerX;
    int newY = playerY;

    switch (direction) {
        case 'w':
            newX--;
            break;
        case 'a':
            newY--;
            break;
        case 's':
            newX++;
            break;
        case 'd':
            newY++;
            break;
        default:
            System.out.println("Invalid input, please enter W/A/S/D: ");
            break;
    }

    if (maze.isValidMove(newX, newY)) {
        playerX = newX;
        playerY = newY;
        maze.setPlayerPosition(playerX, playerY);
        maze.repaint();
    } else {
        System.out.println("Cannot move there, it's a wall!");
    }


}


/**
 * 
 * @author Andy Chih
 * @date September 16, 2024
 * @version V0.1
 */
public String getPosition() {
    return "(" + playerX + ", " + playerY + ")";
}
    
public int getPlayerX() { return playerX; }
public int getPlayerY() { return playerY; }
}