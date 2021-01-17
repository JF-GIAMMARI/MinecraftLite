import java.util.Objects;

/**
 * Class name : Mob
 * Description : Classe implémentant les entitées enemis
 *
 * @author Jean-François Giammari
 */

public class Mob extends Entity {
    public static int nb_mobs = 0;
    private final MobType type;

    /**
     * Constructor for player with full parameter
     *
     * @param type : The type of mob
     */
    public Mob(World world, Position pos, int life, int damage, MobType type) throws IllegalPositionException {
        super(world, pos, life, damage);
        this.type = Objects.requireNonNullElse(type, MobType.ZOMBIE);
        nb_mobs++;
    }

    /**
     * Constructor for player without mobtype
     */
    public Mob(World world, Position pos, int life, int damage) throws IllegalPositionException {
        this(world, pos, life, damage, null);
    }

    /**
     * Getter for nb_mobs
     *
     * @return nb_mobs
     */
    public static int getNb_mobs() {
        return nb_mobs;
    }

    @Override
    public void isDie() {
        System.out.println("Mob is die, good job !");
    }

    @Override
    public String getStats() {
        return "\nStatistic for " + type + " mob : \n" + super.getStats();
    }

    @Override
    public String toString() {
        return "Type :  " + type + "\n" + super.toString();
    }
}
