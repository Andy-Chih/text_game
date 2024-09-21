/**
 * The Storyline class provides the narrative structure for the RPG game, 
 * printing out different parts of the story and guiding the player through 
 * the tutorial and main acts of the game.
 * 
 * @author Ayush Samuel
 * @date September 2, 2024
 * @updated: September 16, 2024
 * @version V0.1
 */
public class Storyline {

    public static String introScene(){
        StringBuilder story = new StringBuilder();
        story.append("In the ancient kingdom of Aetheria, a mystical relic known as the 'Heart of Eternity' was\n");
        story.append("guarded by a secret order of knights. This relic held immense power, said to keep the\n");
        story.append("balance between the realms of light and darkness.\n\n");
        story.append("However, one fateful night, the relic was stolen by a powerful sorcerer who sought to plunge\n");
        story.append("Aetheria into eternal darkness and bend its power to his will.\n\n");
        story.append("You are a young adventurer, chosen by the last remaining knight of the secret order, who\n");
        story.append("entrusts you with a perilous quest: to navigate through the treacherous dungeons of Aetheria,\n");
        story.append("defeat the dark sorcerer, and reclaim the Heart of Eternity.\n\n");
        story.append("Along the way, you will encounter fearsome monsters, cunning traps, and lost souls who can\n");
        story.append("aid or hinder your journey.\n\n");
        story.append("The fate of Aetheria lies in your hands. Will you succeed in restoring peace to the kingdom,\n");
        story.append("or will the darkness consume all?\n");
       return story.toString();
    }

    public static String ActOne(){
        
        StringBuilder actOneStory = new StringBuilder();
        actOneStory.append("You wake up in a dimly lit room, the cold stone floor beneath you sending shivers up your spine.\n");
        actOneStory.append("As your eyes adjust to the darkness of the room, you notice a figure in the shadows, standing at the edge of the room.\n");
        actOneStory.append("watching you silently...\n\n");

        actOneStory.append("The figure steps forward and speaks in a low and hollow voice:\n");
        actOneStory.append("\"Welcome, young adventurer. You have been chosen to reclaim the Heart of Eternity.\"\n");
        actOneStory.append("\"But first, you must prove your worth by surviving the trials ahead.\"\n\n");

        actOneStory.append("The figure hands you a worn, leather-bound book. \"This is your guide,\" they say.\n");
        actOneStory.append("\"It will teach you the basics of survival in these dungeons.\"\n\n");

        actOneStory.append("As you open the book, you notice the first chapter is titled 'Movement'.\n");
        actOneStory.append("You realize this will be your first lesson.\n");
        return actOneStory.toString();

    }

    public static String MovementTutorial(){
        StringBuilder tutorial = new StringBuilder();
        tutorial.append("MOVEMENT\n");
        tutorial.append("-".repeat(30)).append("\n");
        tutorial.append("USE W to move UP, A to move LEFT, D to move RIGHT and S to move DOWN\n");
        return tutorial.toString();
    }

    public static void OtherTutorial(){
        // Space if any other tutorial is needed
    }

    public static String ActTwo(){
    
        StringBuilder actTwoStory = new StringBuilder();
        actTwoStory.append("With the basics of movement completed, you begin your ascent higher into the dungeon.\n");
        actTwoStory.append("The air around you grows colder, and you hear the sound of distant footsteps approaching\n");
        actTwoStory.append("Suddenly, out of the shadows a monster approaches blocking your path forward\n\n");

        actTwoStory.append("You remember the lessons from the guidebook: fight or flee, the choice is yours.\n");
        return actTwoStory.toString();
    }

    public static String FinalAct(){
    
        StringBuilder finalActStory = new StringBuilder();
        finalActStory.append("You climb the last set of stone stairs, each step heavier than the last.\n");
        finalActStory.append("At the top, the doors to the sorcerer's lair stand before you.\n\n");
        finalActStory.append("With a deep breath, you push the doors open and step inside. The room is vast and dark,\n");
        finalActStory.append("lit only by the faint glow of the stolen Heart of Eternity. The sorcerer stands before it, \n");
        finalActStory.append("A fierce battle ensues...\n\n");
        return finalActStory.toString();
    }

    public static String VictoryScreen(){
    
        StringBuilder victoryStory = new StringBuilder();

        victoryStory.append("As the final attack lands, the sorcerer is defeated, and the Heart of Eternity returns to its rightful state.\n");
        victoryStory.append("The balance is restored, and Aetheria is saved...\n\n");
        return victoryStory.toString();
    }

    public static String DefeatScreen(){

        StringBuilder defeatStory = new StringBuilder();

        defeatStory.append("Press R to restart the level!\n");
        return defeatStory.toString();
    }
}

