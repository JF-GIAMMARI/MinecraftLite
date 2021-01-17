import java.util.ArrayList;
import java.util.Objects;

/**
 * Class name : Item
 * Description : Classe implémentant les objets présent dans un inventaire
 *
 * @author Jean-François Giammari
 */

public class Item {
    public static int nb_item = 0;
    private final int ID;
    private final String name;
    private final ItemType type;
    private final Colors color;


    /**
     * Constructor for Item with all parmeters
     *
     * @param type  : Type of item
     * @param name  : Name
     * @param color : Optional Color
     */
    public Item(ItemType type, String name, Colors color) {
        this.type = type;
        this.name = name;
        this.color = Objects.requireNonNullElse(color, Colors.NONE);
        nb_item++;
        ID = nb_item;
    }

    /**
     * Constructor without color
     */
    public Item(ItemType type, String name) {
        this(type, name, null);
    }

    /**
     * Getter for nb_item
     *
     * @return nb_item
     */
    public static int getNb_item() {
        return nb_item;
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
     * Getter for type
     *
     * @return type
     */
    public ItemType getType() {
        return type;
    }

    /**
     * Getter for color
     *
     * @return color
     */
    public Colors getColor() {
        return color;
    }

    /**
     * Equals if same name & type
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && type == item.type && color == item.color;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\nID : ").append(ID);
        sb.append("\nName : ").append(name);
        sb.append("\nType : ").append(type);
        if (color != Colors.NONE) {
            sb.append("\n Color : ").append(color);
        }
        return sb.toString();
    }
}
