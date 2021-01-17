import java.util.ArrayList;

/**
 * Class name : World
 * Description : Classe implémentant le monde
 *
 * @author Jean-François Giammari
 */

public class World {
    public static int nb_world;
    private String name;
    final private int ID;
    final private int DEFAULTSIZE = 10;
    final private int MAXSIZE = 100;
    final private int MINSIZE = 1;
    private Generator gen;
    private MapStyle mapStyle;
    private ArrayList<ArrayList<ArrayList<Block>>> map;
    private ArrayList<Integer> world_size = new ArrayList<>();
    private ArrayList<Structure> structures = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();

    /**
     * Constructor for World with all parameter
     *
     * @param name  : Name of the world
     * @param x_Max : X axis max value
     * @param y_Max : Y axis max value
     * @param z_Max : Z axis max value
     */
    public World(String name, MapStyle map_style, int x_Max, int y_Max, int z_Max) {
        if (name == null || name.length() == 0) {
            this.name = "Untilted";
        } else {
            this.name = name;
        }

        world_size.add(x_Max);
        world_size.add(y_Max);
        world_size.add(z_Max);

        for (int i = 0; i < world_size.size(); i++) {
            if (world_size.get(i) == 0) {
                world_size.set(i, DEFAULTSIZE);
            } else if (world_size.get(i) < MINSIZE) {
                throw new IllegalArgumentException(world_size.get(i) + " is to low (MIN : " + MINSIZE + " )");
            } else if (world_size.get(i) > MAXSIZE) {
                throw new IllegalArgumentException(world_size.get(i) + " is to high (MAX : " + MAXSIZE + " )");
            }
        }
        mapStyle = map_style;
        nb_world++;
        ID = nb_world;
        gen = new Generator(world_size, this);
        genMap();
    }

    /**
     * Constructor for World with all but not the name
     **/
    public World(MapStyle map_style, int x_Max, int y_Max, int z_Max) {
        this("", map_style, x_Max, y_Max, z_Max);
    }

    /**
     * Constructor for World with the name and the map style
     **/
    public World(String name, MapStyle map_style) {
        this(name, map_style, 0, 0, 0);
    }

    /**
     * Constructor for World with only the name
     **/
    public World(String name) {
        this(name, MapStyle.STANDARD, 0, 0, 0);
    }

    /**
     * Constructor for World without parameter
     **/
    public World() {
        this("", MapStyle.STANDARD, 0, 0, 0);
    }

    /**
     * Generation of the map
     */
    private void genMap() {
        switch (mapStyle) {
            case STANDARD -> this.map = gen.Standard();
            case FLAT -> this.map = gen.Flat(Colors.GREEN);
            case VOID -> this.map = gen.Void();
        }
        System.out.println("Map as been generate");
    }

    /**
     * Generation of a structure
     */
    public void genStructure(Structure structure) {
        structures.add(structure);
        // Not implemented
        // Read blueprint structure
        // Replace colors from the blueprint to block in the map with relative position
        // WARN :  If NONE Colors is present in a location, there is no replacement in the world.
    }

    /**
     * Get the structure of the structure list by an index value
     *
     * @param index : structures Arrayist index
     * @return Structure
     */
    public Structure getStructureByIndex(int index) {
        if (index > structures.size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        return structures.get(index);
    }

    /**
     * Get the structure of the structure list by an index value
     *
     * @param ID : Structure ID
     * @return Structure
     */
    public Structure getStructureByID(int ID) {
        int result = -1;
        for (int i = 0; i < structures.size(); i++) {
            if (structures.get(i).getID() == ID) {
                result = i;
            }
        }
        if (result == -1) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return structures.get(result);
    }

    /**
     * Get the structure list
     *
     * @return structures
     */
    public ArrayList<Structure> getAllStructure() {
        return structures;
    }

    /**
     * Add Entity to the world
     */
    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    /**
     * Remove Entity from the world
     */
    public void delEntity(Entity entity) {
        entities.remove(entity);
    }

    /**
     * Get the entity of the entities list by an index value
     *
     * @param index : entity ArrayList index
     * @return Entity
     */
    public Entity getEntityByIndex(int index) {
        if (index > entities.size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        return entities.get(index);
    }

    /**
     * Get the entity of the entities list by an index value
     *
     * @param ID : entity ID
     * @return Entity
     */
    public Entity getEntityByID(int ID) {
        int result = -1;
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getID() == ID) {
                result = i;
            }
        }
        if (result == -1) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return entities.get(result);
    }

    /**
     * Get the structure list
     *
     * @return structures
     */
    public ArrayList<Entity> getAllEntity() {
        return entities;
    }


    /**
     * Get the block object of a position on the map
     *
     * @param position : Position of the block
     * @return block
     */
    public Block getBlock(Position position) {
        return map.get(position.getX()).get(position.getY()).get(position.getZ());
    }

    /**
     * Delete the block from a position
     *
     * @param position : Position of the block
     */
    public void deleteBlock(Position position) {
        // Delete a block is replace it by a void block
        Block block = new Block(Colors.VOID, this, position);
        map.get(position.getX()).get(position.getY()).add(position.getZ(), block);
    }

    /**
     * Getter for world_size
     *
     * @return world_size
     */
    public ArrayList<Integer> getWorldSize() {
        return this.world_size;
    }

    /**
     * Getter for ID
     *
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Getter for nb_world
     *
     * @return nb_world
     */
    public static int getNb_world() {
        return nb_world;
    }

    /**
     * Getter for name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     */
    public void setName(String name) {
        if (name == null || name.length() == 0) {
            System.err.println("The name is not valid, no change was make");
        } else {
            this.name = name;
        }
    }

    /**
     * Getter for map
     *
     * @return map
     */
    public ArrayList<ArrayList<ArrayList<Block>>> getMap() {
        return this.map;
    }

    /**
     * Display the map
     */
    public String viewMap() {
        final StringBuilder gm = new StringBuilder();
        gm.append("Map Visualisation (Top View) :  \n");
        for (ArrayList<ArrayList<Block>> arrayLists : map) {
            for (ArrayList<Block> arrayList : arrayLists) {
                gm.append(" [").append(arrayList.size()).append("]");
            }
            gm.append("\n");
        }
        return gm.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Name: " + name);
        sb.append(" [").append(ID).append("]\n");
        sb.append("Size  : ").append(world_size).append("\n");
        if (structures.size() != 0) {
            sb.append("\n--Structures (").append(structures.size()).append(") : \n");
            for (Structure structure : structures) {
                sb.append(structure);
                sb.append("\n");
            }
        }
        if (entities.size() != 0) {
            sb.append("\n\n--Entities (").append(entities.size()).append(") : \n");
            for (Entity entity : entities) {
                sb.append(entity);
                sb.append("\n\n");
            }
        }
        return sb.toString();
    }
}
