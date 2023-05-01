/**
 * The class player creates player objects and stores its attributes
 * which, in this case are the name, the position and the dice value obtained.
 * Each player has his own attributes.
 *
 * @author Sarah Daccache 40246708
 *
 */
public class Player {

    String name;
    int position, dice;


    public Player(){

    }

    /**
     *
     * @param name  name of the player
     * @param position position of the player on the board
     * @param dice value of dice obtained by the player after flipping it
     */
    public Player(String name, int position, int dice) {
        this.name = name;
        this.position = position;
        this.dice = dice;

    }

    /**
     *
     * @param player creating copies of players
     */
    public Player(Player player) {
        this.name = player.name;
        this.position = player.position;
        this.dice = player.dice;
    }


    /**
     *
     * @return Name of player
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Sets name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return position of player
     */
    public int getPosition() {
        return position;
    }

    /**
     *
     * @param position Sets position of player on the board after each round
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     *
     * @param dice value of dice obtained after flipping it
     * @return value of dice
     */
    public int getDice(int dice) {
        return dice;
    }

    /**
     *
     * @param dice sets value of dice obtained after flipping it
     */
    public void setDice(int dice) {
        this.dice = dice;
    }

}
