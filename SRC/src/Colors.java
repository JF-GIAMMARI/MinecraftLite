import java.util.Random;

/**
 * Class name : Colors
 * Description : Classe implémentant les couleurs
 * @author Jean-François Giammari
 */

public enum Colors {
    RED,
    BLUE,
    GREEN,
    VOID,
    NONE;

    public static Colors getRandomColor() {
        Random rd = new Random();
        return values()[rd.nextInt(values().length-2)];
    }
}
