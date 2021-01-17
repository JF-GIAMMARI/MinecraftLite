/**
 * Class name : IllegalPositionException
 * Description : Une exception indiquant que la position demandé par une entité est deja occupé par un block
 * @author Jean-François Giammari & Alexandre Motbal
 */

public class IllegalPositionException extends Exception {
    public IllegalPositionException() {super();}
    public IllegalPositionException(String s) { super(s) ; }
}


