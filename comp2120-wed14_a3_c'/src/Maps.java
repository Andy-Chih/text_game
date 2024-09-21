/**
 * Represents the collection of maze levels in the game.
 * 
 * @author Andy Chih
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */
public class Maps {
    private char[][][] levels;

/**
 * 
 * @author Andy Chih
 * @date September 16, 2024
 * @version V0.1
 */
public Maps() {
    levels = new char[][][]{
        // level 1
        {
            {' ', '#', ' ', ' ', ' '},
            {' ', '#', ' ', '#', ' '},
            {' ', '#', ' ', '#', ' '},
            {' ', ' ', ' ', '#', ' '},
            {'#', '#', ' ', ' ', 'E'}
        },
        // level 2 
        {
            {' ', '#', '#', '#', ' ', ' ', '#', ' ', ' ', ' '},
            {' ', ' ', ' ', '#', ' ', '#', '#', '#', '#', ' '},
            {'#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' '},
            {'#', ' ', ' ', '#', ' ', ' ', ' ', '#', '#', ' '},
            {'#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' '},
            {' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', '#'},
            {' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
            {' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {' ', ' ', ' ', '#', '#', '#', '#', '#', ' ', 'E'}
        },
        //Final level
        {
            {'#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'E'}
        }
    };
}

/**
 * Retrieves a specific level from the game.
 * 
 * @param level The index of the level to retrieve.
 * @return A 2D char array representing the maze layout for the specified level.
 * 
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */
public char[][] getLevel(int level) {
    return levels[level];
}

/**
 * Gets the total number of levels in the game.
 * 
 * @return The number of levels available.
 * 
 * @author Ayush Samuel
 * @date September 16, 2024
 * @version V0.1
 */
public int getNumberOfLevels() {
    return levels.length;
}
}