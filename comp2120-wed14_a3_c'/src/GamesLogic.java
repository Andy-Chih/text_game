import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Manages the game logic, GUI setup, and game flow for Aetheria: Quest for the Heart of Eternity.
 *
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */

public class GamesLogic {
    private JFrame frame;
    private MazePanel mazePanel;
    private JTextArea storyArea;
    private PlayerMovement playerMovement;
    private Maps maps;
    private int currentAct = 0;
    private int currentLevel = 0;
    private char[][] currentMap;



public GamesLogic() {
        maps = new Maps();
        setupGUI();
}


/**
 * Sets up the graphical user interface for the game.
 *
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */
private void setupGUI() {
    frame = new JFrame("Aetheria: Quest for the Heart of Eternity");
    currentMap = maps.getLevel(currentLevel); 


    mazePanel = new MazePanel(currentMap, 0, 0);
    playerMovement = new PlayerMovement(0, 0, mazePanel);

    storyArea = new JTextArea(5, 40);
    storyArea.setEditable(false);
    storyArea.setLineWrap(true);
    storyArea.setWrapStyleWord(true);

    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(new JScrollPane(mazePanel), BorderLayout.CENTER);  // Wrap mazePanel in JScrollPane
    mainPanel.add(new JScrollPane(storyArea), BorderLayout.SOUTH);

    frame.add(mainPanel);
    frame.setSize(800, 600); 
    frame.add(mainPanel);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        frame.setFocusable(true);
    }

public void startGame() {
    displayStory(Storyline.introScene());
    waitForInput();
}

private void displayStory(String story) {
    storyArea.setText(story);
}

private void waitForInput() {
    storyArea.append("\nPress Enter to continue...");
}

/**
 * Handles key presses for game progression and player movement.
 *
 * @param key The character representing the key pressed.
 *
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */
private void handleKeyPress(char key) {
    switch (currentAct) {
        case 0: // Intro Scene
            if (key == '\n') {
                currentAct++;
                displayStory(Storyline.ActOne());
                waitForInput();
            }
            break;
        case 1: // Act One
            if (key == '\n') {
                currentAct++;
                displayStory(Storyline.MovementTutorial());
                waitForInput();
            }
            break;
        case 2: // Level 1
        case 3: // Level 2
        case 4: // Level 3
            handleMazeMovement(key);
            break;
        case 5: // Victory Screen
            if (key == '\n') {
                // Game end or menu logic after merge with GameMenu
            }
            break;
    }
}


/**
 * Handles player movement within the maze.
 *
 * @param key The character representing the movement direction.
 *
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */
private void handleMazeMovement(char key) {
    if (key == '\n') {
        frame.requestFocusInWindow();
    } else if (key == 'w' || key == 'a' || key == 's' || key == 'd') {
        playerMovement.move(key);
        if (mazePanel.isExit(playerMovement.getPlayerX(), playerMovement.getPlayerY())) {
            moveToNextLevel();
        }
    }
}

/**
 * Moves the player to the next level or progresses the story if all levels are completed.
 *
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */
private void moveToNextLevel() {
    currentLevel++;
    if (currentLevel < maps.getNumberOfLevels()) {
        currentMap = maps.getLevel(currentLevel);
        mazePanel.setMaze(currentMap);
        playerMovement.resetPosition(0, 0);
        
        if (currentLevel == 1) {
            currentAct++;
            displayStory(Storyline.ActTwo());
        } else if (currentLevel == 2) {
            currentAct++;
            displayStory(Storyline.FinalAct());
        }
        
        displayStory("Level " + (currentLevel + 1) + " - Good job! Move to the next level.");
        waitForInput();
    } else {
        currentAct++;
        displayStory(Storyline.VictoryScreen());
        waitForInput();
    }
  }
}