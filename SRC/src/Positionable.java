/**
 * Interface name : Positionable
 * Description : Interface definissant les positions
 *
 * @author Jean-François Giammari
 */
public interface Positionable {
    void setPosition(Position pos) throws IllegalPositionException;

    Position getPosition();
}
