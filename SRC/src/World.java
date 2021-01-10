import java.util.ArrayList;

/**
 * Class name : World
 * Description : Classe implémentant le monde
 * @author Jean-François Giammari
 */
public class World {
    public static int nb_world;
    private String name;
    final private  int ID;
    final private int DEFAULTSIZE = 100;
    final private int MAXSIZE = 1000;
    final private int MINSIZE = 1;
    private MapStyle mapStyle;
    private ArrayList<Block> map;
    private Position spawn_point;
    private ArrayList<Integer> world_size = new ArrayList<Integer>();

    /**
     * Constructor for World with all parameter
     * @param name : Name of the world
     * @param x_Max : X axis max value
     * @param y_Max : Y axis max value
     * @param z_Max : Z axis max value
     * @param x_Min : X axis min value
     * @param y_Min : Y axis min value
     * @param z_Min : Z axis min value
     */
    public World(String name, MapStyle map_style, int x_Max, int y_Max, int z_Max, int x_Min, int y_Min, int z_Min, Position in_spawn_point) {
        this.name = name;
        world_size.add(x_Max);
        world_size.add(y_Max);
        world_size.add(z_Max);
        world_size.add(x_Min);
        world_size.add(y_Min);
        world_size.add(z_Min);

        for (int i = 0; i < world_size.size(); i++) {
            if(world_size.get(i) == 0){
                world_size.set(i, DEFAULTSIZE);
            }else if (world_size.get(i) < MINSIZE){
                throw new IllegalArgumentException(world_size.get(i) + " is to low (MIN : "+ MINSIZE+" )");
            }else if (world_size.get(i) > MAXSIZE){
                throw new IllegalArgumentException(world_size.get(i) + " is to high (MAX : "+ MAXSIZE+" )");
            }
        }
        spawn_point = in_spawn_point;
        mapStyle = map_style;
        nb_world++;
        ID = nb_world;
        genMap();

    }

    /**
     * Constructor for World with the name and the map style
     **/
    public World(String name, MapStyle map_style, int x_Max, int y_Max, int z_Max, int x_Min, int y_Min, int z_Min) {
        this(name, map_style,x_Max,y_Max,z_Max,x_Min,y_Min,z_Min, new Position(0,0,0));
    }

    /**
     * Constructor for World with the name and the map style
     **/
    public World(String name, MapStyle map_style) {
        this(name, map_style,0,0,0,0,0,0, new Position(0,0,0));
    }

    /**
     * Constructor for World with only the name
     **/
    public World(String name) {
        this(name, MapStyle.STANDARD,0,0,0,0,0,0, new Position(0,0,0));
    }


    /**
     * Constructor for World without parameter
     **/
    public World() {
        this("Untilted "+(nb_world+1),MapStyle.STANDARD, 0,0,0,0,0,0,new Position(0,0,0));
    }

    /**
     * Generation of the map
     */
    private void genMap(){
        switch(mapStyle) {
            case STANDARD:
                System.out.println("Standard gen");
                break;
            case FLAT:
                System.out.println("Flat gen");
                break;
            case VOID:
                System.out.println("Void gen");
                break;
        }
        System.out.println("Map as been generate");

    }

    /**
     * Get the block object of a position on the map
     * @param position
     * @return block
     */
    public Block getBlock(Position position){
        return new Block();
    }

    /**
     * Delete the block from a position
     * @param position
     */
    public void deleteBlock(Position position){

    }

    /**
     * Getter for world_size
     * @return world_size
     */
    public ArrayList<Integer> getWorldSize() {
        return this.world_size;
    }

    /**
     * Getter for ID
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Getter for spawn_point
     * @return spawn_point
     */
    public Position getSpawn_point() {
        return spawn_point;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @return name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for map
     * @return map
     */
    public ArrayList<Block> getMap() {
        return this.map;
    }

    /**
     * Display the map
     */
    public String viewMap(){
        final StringBuilder gm = new StringBuilder("");
        gm.append("TEst");
        return gm.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("World : ");
        sb.append(name);
        sb.append(" [").append(ID).append("]\n");
        sb.append("Size  : ").append(world_size).append("\n");
        sb.append("Spawn Position : ").append(spawn_point.toString()).append("\n");
        sb.append(viewMap());
        return sb.toString();
    }
}
