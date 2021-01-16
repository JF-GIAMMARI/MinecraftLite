/**
 * Class name : Entity
 * Description : Classe implémentant les entitées présent dans un monde
 * @author Jean-François Giammari
 */


public class Entity implements Positionable, Statisticable {
    private Position pos;
    public void setPosition(Position pos){
        this.pos = pos;
    };
    public Position getPosition(){
        return this.pos;
    };
}
