/**
 * Class name : Player
 * Description : Classe implémentant les entitées Joueur
 * @author Jean-François Giammari
 */

public class Player extends Entity implements Positionable {
    public final String pseudo;
    public static int nb_player  = 0;
    private final Inventory inventory;

    public Player(World world, Position pos, int life, int damage, String pseudo) throws IllegalPositionException {
        super(world, pos, life, damage);
        if(pseudo == null || pseudo.length() == 0 ){
            this.pseudo = "Untilted_Player_"+nb_player+1;
        }else{
            this.pseudo = pseudo;
        }
        this.inventory = new Inventory();
        nb_player++;

    }

    public Player(World w1, Position pos, int life, int damage) throws IllegalPositionException {
        this(w1,pos,life,damage,"");
    }

    /**
     * Getter for Inventory
     * @return inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    //Mine
    //Place


}
