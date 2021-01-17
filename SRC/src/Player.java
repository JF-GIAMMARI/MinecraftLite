/**
 * Class name : Player
 * Description : Classe implémentant les entitées Joueur
 *
 * @author Jean-François Giammari
 */

public class Player extends Entity implements Positionable {
    public final String pseudo;
    public static int nb_player = 0;
    private final Inventory inventory;

    /**
     * Constructor for player with full parameter
     *
     * @param pseudo : Pseudo of the player
     */
    public Player(World world, Position pos, int life, int damage, String pseudo) throws IllegalPositionException {
        super(world, pos, life, damage);
        if (pseudo == null || pseudo.length() == 0) {
            this.pseudo = "Untilted_Player_" + nb_player + 1;
        } else {
            this.pseudo = pseudo;
        }
        this.inventory = new Inventory();
        nb_player++;

    }

    /**
     * Constructor for player without Pseudo
     */
    public Player(World w1, Position pos, int life, int damage) throws IllegalPositionException {
        this(w1, pos, life, damage, "");
    }

    /**
     * Getter for Inventory
     *
     * @return inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Player mine a block in the world and is added to inventory
     *
     * @param pos : Position of the block
     */
    public void mineBlock(Position pos) {

    }

    /**
     * Player place a block in the world and is removed  from the inventory
     *
     * @param index : Index of the block in the inventory
     */
    public void placeBlock(int index) {

    }

    /**
     * Getter for nb_player
     *
     * @return nb_player
     */
    public static int getNb_player() {
        return nb_player;
    }

    @Override
    public void isDie() {
        System.out.println(pseudo + " is die, game over..");
    }

    @Override
    public String getStats() {
        return "\nStatistic for " + pseudo + " : \n" + super.getStats();
    }

    @Override
    public String toString() {
        String sb =
                "Type : Player " +
                        "\nPseudo : " + pseudo +
                        "\n" + super.toString();
        return sb;
    }


}
