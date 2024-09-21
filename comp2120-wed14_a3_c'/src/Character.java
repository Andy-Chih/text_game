/**
 * The Character class defines the common attributes of a Character.
 *
 * @author Rhonda Luu
 * @date September 16th, 2024
 * @version V0.4
 */
public class Character {
    private String name; // "adventurer", "archer", "monster", "sorcerer"
    private int health;
    private int attackPower;
    private String type; // "player", "enemy"
    private Inventory inventory;

    /**
     * This constructor constructs a Character with a specified health.
     *
     * @param name The name of the Character
     * @param health The health of the Character.
     * @param attackPower The attack power of the Character.
     * @param type The type of Character.
     * @param isHardMode A boolean representing if the Hard difficulty level has been selected
     *
     * @author Cara Chen and Rhonda Luu
     * @date September 16th, 2024
     * @version V0.5
     */
    public Character(String name, int health, int attackPower, String type, boolean isHardMode) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.type = type;
        this.inventory = new Inventory(isHardMode);
    }

    /**
     * This method sets the name of the Character.
     *
     * @return The name of the Character.
     *
     * @author Rhonda Luu
     * @date September 16th, 2024
     * @version V0.1
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gets the name of the Character.
     *
     * @return The name of the Character.
     *
     * @author Rhonda Luu
     * @date September 16th, 2024
     * @version V0.1
     */
    public String getName() {
        return name;
    }

    /**
     * This method gets the health of the Character.
     *
     * @return The health of the Character.
     *
     * @author Cara Chen
     * @date September 8th, 2024
     * @version V0.1
     */
    public int getHealth() {
        return health;
    }

    /**
     * This method sets the health of the Character.
     *
     * @return The health of the Character.
     *
     * @author Cara Chen
     * @date September 8th, 2024
     * @version V0.1
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * This method gets the attack power of the Character.
     *
     * @return The attack power of the Character.
     *
     * @author Rhonda Luu
     * @date September 8th, 2024
     * @version V0.1
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * This method sets the attack power of the Character.
     *
     * @return The attack power of the Character.
     *
     * @author Rhonda Luu
     * @date September 8th, 2024
     * @version V0.1
     */
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    /**
     * This method sets the type of the Character.
     *
     * @return The type of the Character.
     *
     * @author Rhonda Luu
     * @date September 8th, 2024
     * @version V0.1
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method gets the type of the Character.
     *
     * @return The type of the Character.
     *
     * @author Rhonda Luu
     * @date September 8th, 2024
     * @version V0.1
     */
    public String getType() {
        return type;
    }

    /**
     * This method gets the inventory of the Player.
     *
     * @return The inventory of the Player.
     *
     * @author Cara Chen
     * @date September 8th, 2024
     * @version V2.0
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * This method allows a Character to attack another Character.
     *
     * @param character The Character who will be attacking the opponent.
     * @param opponent The opponent that the Character will attack.
     *
     * @author Rhonda Luu
     * @date September 16th, 2024
     * @version V0.3
     */
    public void attack(Character character, Character opponent) {
        opponent.setHealth(opponent.getHealth()- character.getAttackPower());
        if (character.getType().equals("player")) {
            System.out.println("You attacked the " + opponent.getName() + "! " +
                    "The " + opponent.getName() + "'s health is now: " + opponent.getHealth());
        } else {
            System.out.println("The " + opponent.getName() + " attacked you! " +
                    "Your health is now: " + character.getHealth());
        }
    }

    /**
     * This method represents the Player's encounter with the Lost Soul (npc) who blesses the Player with one health potion.
     *
     * @param character The Player character who will be affected by the Lost Soul upon interaction.
     * @return Health potion is added to the Player's inventory.
     *
     * @author Rhonda Luu
     * @date September 14th, 2024
     * @version V0.3
     */
    public void encounterLostSoul(Character character) {
        character.getInventory().acquireHealthPotion();
    }
}
