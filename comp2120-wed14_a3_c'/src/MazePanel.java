import javax.swing.*;
import java.awt.*;

/**
 * Represents the visual component for displaying the maze and player.
 * 
 * @author Andy Chih
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */
public class MazePanel extends JPanel {
    private char[][] maze;
    private int cellSize = 40; // Size of grid of maze
    private int playerX, playerY; // Player's position


/**
 * Constructs a MazePanel with the given maze layout and player position.
 * 
 * @author Andy Chih
 * @date September 16, 2024
 * @version V0.1
 */
public MazePanel(char[][] maze, int playerX, int playerY) {
    this.maze = maze;
    this.playerX = playerX;
    this.playerY = playerY;

}

/**
 * Paints the component, rendering the maze and player.
 * 
 * @param g The Graphics object to paint on.
 * 
 * @author Andy Chih
 * @date September 16, 2024
 * @version V0.1
 */
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[i].length; j++) {
            if (maze[i][j] == '#') {
                g.setColor(Color.BLACK);  // WALL
            } else if (maze[i][j] == 'E') {
                g.setColor(Color.GREEN);  // DESTINATION
            } else {
                g.setColor(Color.WHITE);  // SPACE
            }
            g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
            g.setColor(Color.GRAY);
            g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
        }
    }

    // A red Oval for Player
    g.setColor(Color.RED);
    g.fillOval(playerY * cellSize, playerX * cellSize, cellSize, cellSize);
}



/**
 * Sets a new maze layout and repaints the panel.
 * 
 * @param newMaze The new 2D char array representing the maze layout.
 * 
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */
public void setMaze(char[][] newMaze) {
    this.maze = newMaze;
    repaint();
}

/**
 * Updates the player's position and repaints the panel.
 * 
 * 
 * @author Andy Chih
 * @date September 16, 2024
 * @version V0.1
 */
public void setPlayerPosition(int x, int y) {
    this.playerX = x;
    this.playerY = y;
    repaint();
}

/**
 * Returns the preferred size of this component.
 * 
 * @author Andy Chih
 * @date September 16, 2024
 * @version V0.1
 */
@Override
public Dimension getPreferredSize() {
    return new Dimension(400, 400);
}

/**
 * Checks if the given position is an exit in the maze.
 * 
 * 
 * @author Andy Chih
 * @date September 16, 2024
 * @version V0.1
 */
public boolean isExit(int x, int y) {
    return maze[x][y] == 'E';
}

/**
 * Checks if a move to the given position is valid.
 * 
 * 
 * @author Andy Chih
 * @date September 16, 2024
 * @version V0.1
 */
public boolean isValidMove(int x, int y) {
    return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != '#';
}
}