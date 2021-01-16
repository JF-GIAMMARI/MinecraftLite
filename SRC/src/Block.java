import java.util.Objects;

/**
 * Class name : Block
 * Description : Classe implémentant les blocs présent dans un monde
 * @author Jean-François Giammari
 */

public class Block implements Positionable {
    private final String name;
    private final Colors color;
    private final World world;
    private Position pos;
    public static int nb_block = 0;

    /**
     * Constructor for World with all parameter
     * @param color : Colors of the block
     * @param w : World of the block
     * @param pos : Position of the bloc
     */
    public Block(Colors color, World w, Position pos) {
        this.color = color;
        this.world = w;
        this.pos = pos;
        nb_block++;
        this.name = "Block_N"+nb_block;

    }

    /**
     * Constructor for Block with only World an Position
     **/
    public Block(World w, Position pos){
        this(Colors.RED, w, pos);
    }


    /**
     * Setter for Position
     */
    public void setPosition(Position pos){
        this.pos = pos;
    };

    /**
     * Getter for Position
     * @return pos
     */
    public Position getPosition(){
        return this.pos;
    };

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the color
     * @return Color
     */
    public Colors getColor() {
        return color;
    }

    /**
     * Getter for World
     * @return world
     */
    public World getWorld() {
        return world;
    }

    /**
     * Getter for nb_block
     * @return nb_block
     */
    public static int getNb_block() {
        return nb_block;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Name: ");
        sb.append(name).append("\n");
        sb.append("Color : ").append(color).append("\n");
        sb.append("World : ").append(world.getName()).append("\n");
        sb.append("Position : ").append(this.getPosition()).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return color == block.color && Objects.equals(world, block.world);
    }

}
