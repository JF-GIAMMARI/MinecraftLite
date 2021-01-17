import java.util.ArrayList;

/**
 * Class name : Tower
 * Description : Classe implémentant les structure "Tour"
 *
 * @author Jean-François Giammari
 */

public class Tower extends Structure {
    public static int nb_tower;
    private final int z_length;
    private final Colors color;
    final protected int MAXHEIHGT = 100;
    final protected int MINHEIHGT = 1;
    final protected int DEFAULTHEIHGT = 5;
    private ArrayList<ArrayList<ArrayList<Colors>>> blueprint = new ArrayList<>();

    /**
     * Constructor for Tower with all parameter
     *
     * @param pos      : Start position for the structure
     * @param x_lenght : X axis value
     * @param y_lenght : Y axis value
     * @param z_lenght : Z axis value
     */
    public Tower(Position pos, int x_lenght, int y_lenght, int z_lenght, Colors colors) {
        super(pos, x_lenght, y_lenght);
        if (z_lenght > MAXHEIHGT || x_lenght < MINHEIHGT) {
            this.z_length = DEFAULTHEIHGT;
        } else {
            this.z_length = z_lenght;
        }
        this.color = colors;
        nb_tower++;
        genBlueprint();
    }

    /**
     * Constructor for Tower with only the position & color
     **/
    public Tower(Position pos, Colors colors) {
        this(pos, 0, 0, 0, colors);
    }

    /**
     * Getter for Color
     *
     * @return color
     */
    public Colors getColor() {
        return this.color;
    }

    /**
     * Getter for Z Length
     *
     * @return z_length
     */
    public int getZLength() {
        return this.z_length;
    }

    /**
     * Getter for blue print
     *
     * @return blueprint
     */
    public ArrayList<ArrayList<ArrayList<Colors>>> getBluePrint() {
        return this.blueprint;
    }

    private void genBlueprint() {
        for (int i = 0; i < x_length; i++) {
            blueprint.add(new ArrayList<>(x_length));
            for (int j = 0; j < y_length; j++) {
                blueprint.get(i).add(new ArrayList<>(y_length));
                for (int k = 0; k < z_length; k++) {
                    blueprint.get(i).get(j).add(k, color);
                }
            }
        }
    }

    public String viewBlueprint() {
        final StringBuilder gb = new StringBuilder();
        gb.append("Blue print (Top view) :\n\n");
        for (ArrayList<ArrayList<Colors>> arrayLists : blueprint) {
            for (int j = 0; j < arrayLists.size(); j++) {
                gb.append(" [" + arrayLists.get(j).size() + "]");
            }
            gb.append("\n");
        }
        gb.append("\nBlue print (Front view) :\n");
        for (int i = 0; i < blueprint.get(0).get(0).size(); i++) {
            gb.append("\n    ");
            gb.append(("[" + blueprint.get(0).size() + "]").repeat(blueprint.size()));
        }
        gb.append("\n");
        return gb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type : Tower \n");
        sb.append(super.toString());
        sb.append(" * " + z_length + "\n");
        sb.append("Color : " + color + "\n");
        return sb.toString();
    }


}
