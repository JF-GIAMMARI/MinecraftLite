/**
 * Class name : Mob
 * Description : Classe implémentant les entitées enemis
 * @author Jean-François Giammari
 */

public class Mob extends Entity{
    public Mob(World world, Position pos, int life, int damage) throws IllegalPositionException {
        super(world, pos, life, damage);
    }
}
