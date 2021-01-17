/**
 * Class name : Player
 * Description : Classe implémentant les entitées Joueur
 * @author Jean-François Giammari
 */

public class Player extends Entity implements Positionable {


    public Player(World world, Position pos, int life, int damage) throws IllegalPositionException {
        super(world, pos, life, damage);
    }
}
