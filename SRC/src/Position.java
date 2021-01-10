/**
 * Class name : Position
 * Description : Classe outils pour le format des positions
 * @author Jean-François Giammari
 */


public class Position {
    private int x,y,z;

    /**
     * Constructor for position
     * @param x
     * @param y
     * @param z
     */
    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /** GETTER **/
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "X = " + x + ", Y = " + y + ", Z = " + z ;
    }
}
