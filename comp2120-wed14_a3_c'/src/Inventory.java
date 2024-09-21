/**
 * The Inventory class defines the items in a Character's inventory.
 *
 * @author Cara Chen and Rhonda Luu
 * @date September 14th, 2024
 * @version V0.2
 */
public class Inventory {
    private boolean hasHealthPotion;
    private boolean hasHeartOfEternity;

    public Inventory(boolean isHardMode) {
        this.hasHealthPotion = isHardMode; // Health Potion only available in Hard Mode.
        this.hasHeartOfEternity = false; // Initially, the player does not have the Heart of Eternity.
    }

    /**
     * This method restores the full health of a Character when a health potion is used.
     *
     * @param character The Character's health to be restored.
     *
     * @author Cara Chen
     * @date September 8th, 2024
     * @version V0.2
     */
    public void useHealthPotion(Character character) {
        if (hasHealthPotion) {
            character.setHealth(10); // Restores player's health to full.
            hasHealthPotion = false; // Health potion can be used only once.
            System.out.println("Health Potion used. Health restored to 10.");
        } else {
            System.out.println("No Health Potions left!");
        }
    }

    /**
     * This method restores the full health of a Character when a health potion is used.
     *
     * @author Cara Chen
     * @date September 8th, 2024
     * @version V0.2
     */
    public void acquireHeartOfEternity() {
        hasHeartOfEternity = true;
        System.out.println("You have obtained the Heart of Eternity!");
    }

    /**
     * This method checks if a Character has the Heart of Eternity.
     *
     * @author Cara Chen
     * @date September 8th, 2024
     * @version V0.2
     */
    public boolean hasHeartOfEternity() {
        return hasHeartOfEternity;
    }

    /**
     * This method adds a health potion to a Character's inventory.
     *
     * @author Rhonda Luu
     * @date September 14th, 2024
     * @version V0.1
     */
    public void acquireHealthPotion() {
        hasHealthPotion = true;
        System.out.println("You have encountered a Lost Soul who has blessed you with 1 x health potion!");
    }

    /**
     * This method removes a health potion to a Character's inventory.
     *
     * @author Rhonda Luu
     * @date September 16th, 2024
     * @version V0.1
     */
    public void removeHealthPotion() {
        hasHealthPotion = false;
        System.out.println("You have used a Health Potion. Yor health has been fully restored to 10.");
    }

    /**
     * This method checks if a Character has a health potion.
     *
     * @author Rhonda Luu
     * @date September 14th, 2024
     * @version V0.1
     */
    public boolean hasHealthPotion() {
        return hasHealthPotion;
    }
}
