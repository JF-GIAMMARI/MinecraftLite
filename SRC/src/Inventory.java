import java.util.ArrayList;

/**
 * Class name : Inventory
 * Description : Classe implémentant les inventaire des entités
 * @author Jean-François Giammari
 */


public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();
    public static int nb_inventory = 0;
    private final Player player;
    final private int ID;

    public Inventory(Player player) {
        this.player = player;
        nb_inventory++;
        this.ID = nb_inventory;
    }

    public void addItem(Object o){
        if(o instanceof Block){
            inventory.add(new Item(ItemType.BLOCK,"Block",((Block) o).getColor()));
        }else{
            inventory.add((Item) o);
        }
    }

    public void removeItem(int index){
        if(index > inventory.size()){
            throw new IllegalArgumentException("Index is invalid");
        }
        inventory.remove(index);
    }

    public Item getItem(int index){
        if(index > inventory.size()){
            throw new IllegalArgumentException("Index is invalid");
        }
        return inventory.get(index);
    }

    public ArrayList<Item> getItems(){
        return inventory;
    }

    public StringBuilder display(){
        StringBuilder inv = new StringBuilder();
        for (int i = 0; i < inventory.size(); i++) {
            inv.append("\n").append(i).append(".").append(inventory.get(i).getName()).append(" (").append(inventory.get(i).getType());
            if(inventory.get(i).getType() == ItemType.BLOCK){
                inv.append("/").append(inventory.get(i).getColor());
            }
            inv.append(")");
        }
        return inv;
    }

    public static int getNb_inventory() {
        return nb_inventory;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Inventory of "+player.getPseudo()+" ID : "+ID+ "\n Total items : "+inventory.size()+display();
    }
}
