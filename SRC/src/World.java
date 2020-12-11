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
    final private int X_Max;
    final private int Y_Max;
    final private int Z_Max;
    final private int X_Min;
    final private int Y_Min;
    final private int Z_Min;
    final private int DEFAULTSIZE = 100;
    final private int MAXSIZE = 1000;
    final private int MINSIZE = 1;
    private ArrayList<Block> map;
    private ArrayList<Integer> spawn_point;

    public World(String name, int x_Max, int y_Max, int z_Max, int x_Min, int y_Min, int z_Min) {
        this.name = name;
        X_Max = x_Max;
        Y_Max = y_Max;
        Z_Max = z_Max;
        X_Min = x_Min;
        Y_Min = y_Min;
        Z_Min = z_Min;
        spawn_point.add(0);
        spawn_point.add(0);
        spawn_point.add(0);
        genMap();
        nb_world++;
        ID = nb_world;

    }

    public World(String name) {
        this(name,0,0,0,0,0,0);
    }

    public World() {
        this("untilted",0,0,0,0,0,0);
    }

    private void genMap(){

    }

    public ArrayList<Integer> getWorldSize() {
        ArrayList<Integer> c = new ArrayList<Integer>();
        c.add(X_Max);
        c.add(Y_Max);
        c.add(Z_Max);
        c.add(X_Min);
        c.add(Y_Min);
        c.add(Z_Min);
        return c;
    }

    public int getID() {
        return ID;
    }

    public ArrayList<Integer> getSpawn_point() {
        return spawn_point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("World{");
        sb.append("name='").append(name).append('\'');
        sb.append(", ID=").append(ID);
        sb.append(", X_Max=").append(X_Max);
        sb.append(", Y_Max=").append(Y_Max);
        sb.append(", Z_Max=").append(Z_Max);
        sb.append(", X_Min=").append(X_Min);
        sb.append(", Y_Min=").append(Y_Min);
        sb.append(", Z_Min=").append(Z_Min);
        sb.append(", map=").append(map);
        sb.append(", spawn_point=").append(spawn_point);
        sb.append('}');
        return sb.toString();
    }
}
