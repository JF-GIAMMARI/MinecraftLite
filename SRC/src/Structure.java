/**
 * Class name : Structure
 * Description : Classe implémentant les structures présent dans les biomes
 * @author Jean-François Giammari
 */
public abstract class Structure implements Positionable {
    private Position pos;
    public static int nb_struct;
    final private  int ID;
    final protected int x_length;
    final protected int y_length;
    final protected int DEFAULTSIZE = 10;
    final protected int MAXSIZE = 100;
    final protected int MINSIZE = 1;

    /**
     * Constructor for Structure with all parameter
     * @param pos : Start position for the structure
     * @param x_length : X axis value
     * @param y_length : Y axis value
     */
    public Structure(Position pos, int x_length, int y_length) {
        this.pos = pos;
        if(x_length > MAXSIZE || x_length < MINSIZE){
            this.x_length = DEFAULTSIZE;
        }else{
            this.x_length = x_length;
        }
        if(y_length > MAXSIZE || y_length < MINSIZE){
            this.y_length = DEFAULTSIZE;
        }else{
            this.y_length = y_length;
        }
        nb_struct++;
        ID = nb_struct;
    }

    /**
     * Constructor for Structure with only the position
     **/
    public Structure(Position pos) {
        this(pos, 0, 0);
    }

    /**
     * Getter for ID
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Getter for nb_struct
     * @return nb_struct
     */
    public static int getNb_struct() {
        return nb_struct;
    }

    /**
     * Setter for Position
     */
    public void setPosition(Position pos){
        this.pos = pos;
    }

    /**
     * Getter for Position
     * @return pos
     */
    public Position getPosition(){
        return this.pos;
    }

    /**
     * Getter for X Length
     * @return x_length
     */
    public int getXLength(){
        return this.x_length;
    }

    /**
     * Getter for Y Length
     * @return y_length
     */
    public int getYLength(){
        return this.y_length;
    }

    @Override
    public String toString() {
        String result = "ID : " + ID + "\n" +
                "Position : " + this.getPosition() + "\n" +
                "Size  : " + x_length + " * " + y_length;
        return result;
    }
}
