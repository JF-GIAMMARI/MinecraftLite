import java.util.*;

/**
 * Class name : Generator
 * Description : Classe implémentant la génération du monde
 * @author Jean-François Giammari
 */
public class Generator {
    private final int x_length;
    private final int y_length;
    private final int z_length;
    private final World world;

    public Generator(ArrayList<Integer> in_world_size, World world) {
        x_length = in_world_size.get(0);
        y_length = in_world_size.get(1);
        z_length = in_world_size.get(2);
        this.world = world;
    }

    public  ArrayList<ArrayList<ArrayList<Block>>> Standard(){
        ArrayList<ArrayList<ArrayList<Block>>> map = new ArrayList<>();
        for (int i = 0; i < x_length; i++) {
            map.add(new ArrayList<>(x_length));
            for (int j = 0; j < y_length; j++) {
                map.get(i).add(new ArrayList<>(y_length));
                for (int k = 0; k < z_length; k++) {
                    // Not implemented : Random Height for topography & Auto structure addition (Air is Void Block)
                    map.get(i).get(j).add(k,new Block(Colors.getRandomColor(), world, new Position(i,j,k)));
                }
            }
        }
        return map;
    }

    public ArrayList<ArrayList<ArrayList<Block>>> Flat(Colors colors){
        ArrayList<ArrayList<ArrayList<Block>>> map = new ArrayList<>();
        for (int i = 0; i < x_length; i++) {
            map.add(new ArrayList<>(x_length));
            for (int j = 0; j < y_length; j++) {
                map.get(i).add(new ArrayList<>(y_length));
                for (int k = 0; k < z_length; k++) {
                    if(k > z_length/2){ // 50/50 Void and Block
                        map.get(i).get(j).add(k,new Block(Colors.VOID, world, new Position(i,j,k)));
                    }else{
                        map.get(i).get(j).add(k,new Block(colors, world, new Position(i,j,k)));
                    }


                }
            }
        }
        return map;
    }

    public ArrayList<ArrayList<ArrayList<Block>>> Void(){
        ArrayList<ArrayList<ArrayList<Block>>> map = new ArrayList<>();
        for (int i = 0; i < x_length; i++) {
            map.add(new ArrayList<>(x_length));
            for (int j = 0; j < y_length; j++) {
                map.get(i).add(new ArrayList<>(y_length));
                for (int k = 0; k < z_length; k++) {
                    // Full void map
                    map.get(i).get(j).add(k,new Block(Colors.VOID, world, new Position(i,j,k)));
                }
            }
        }
        return map;
    }


}
