import java.util.Objects;

/**
 * Class name : Entity
 * Description : Classe implémentant les entitées présent dans un monde
 * @author Jean-François Giammari
 */


public abstract class Entity implements Positionable, Statisticable {
    public static int nb_entity = 0;
    private final World world;
    private final int ID;
    private int life;
    private int damages;
    private Position pos;

    /**
     * Constructor for entity with all parameters
     * @param world : The world link with
     * @param pos : Position on the world
     * @param life : Life points
     * @param damages : Damages points
     * @throws IllegalPositionException
     */
    public Entity(World world, Position pos, int life, int damages) throws IllegalPositionException {
        this.world = world;
        world.addEntity(this);
        setPosition(pos);
        setLife(life);
        setDamages(damages);
        nb_entity++;
        this.ID = nb_entity;
    }

    /**
     * Constructor without life & damages
     */
    public Entity(World world, Position pos) throws IllegalPositionException {
        this(world,pos,0,-1);
    }

    /**
     * Getter for Nb_Entity
     * @return nb_entity
     */
    public static int getNb_entity() {
        return nb_entity;
    }

    /**
     * Getter for ID
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Setter for life
     * @param life : New life value
     */
    public void setLife(int life){
        if(life > MAXLIFE || life < MINLIFE){
            this.life = DEFAULTLIFE;
            System.err.println("Invalid value, set to default.");
        }else{
            this.life = life;
        }
    }

    /**
     * Getter for life
     * @return life
     */
    public int getLife() {
        return life;
    }

    /**
     * Add life point to entity
     * @param value : value
     */
    public void addLife(int value) {
        this.life += value;
        if(this.life> MAXLIFE){
            this.life = MAXLIFE;
        }
    }

    /**
     * Take life point to entity
     * @param value : value
     */
    public void lostLife(int value) {
        this.life -= value;
        if(this.life < MINLIFE){
            isDie();
            this.life = 0;
        }
    }

    public void isDie(){
        System.out.println("Entity "+ID+" is die");
    }

    /**
     * Setter for damages
     * @param damages : New damages
     */
    public void setDamages(int damages) {
        if(damages > MAXDAMAGE || damages < MINDAMAGE){
            this.damages = DEFAULTDAMAGE;
            System.err.println("Invalid value, set to default.");
        }else{
            this.damages = damages;
        }
    }

    /**
     * Getter for Damages
     * @return damages
     */
    public int getDamages() {
        return damages;
    }

    /**
     * Add Damages point to entity
     * @param value : Value to use
     */
    public void addDamages(int value) {
        this.damages += value;
        if(this.damages> MAXDAMAGE){
            this.damages = MAXDAMAGE;
        }
    }

    /**
     * Take damages point to entity
     * @param value : Value to use
     */
    public void lostDamages(int value) {
        this.damages -= value;
        if(this.damages < MINDAMAGE){
            this.damages = MINDAMAGE;
        }
    }

    /**
     * Attack another entity
     * @param entity : Entity attacked
     */
    public void Attack(Entity entity) {
        entity.lostLife(this.damages);
    }


    /**
     * Setter for position with check if the target position is a VOID Block
     * @param pos : Position
     * @throws IllegalPositionException
     */
    public void setPosition(Position pos) throws IllegalPositionException {
        if(this.world.getBlock(pos).getColor() != Colors.VOID ){
            throw new IllegalPositionException("The target position is already a "+world.getBlock(pos).getColor() +" block");
        }else{
            this.pos = pos;
        }
    }

    /**
     * Getter for Position
     * @return pos
     */
    public Position getPosition(){
        return this.pos;
    }

    /**
     * Check if a position is VOID Block
     * @param pos : Position
     * @return true if is void
     */
    public boolean isVoid(Position pos){
        boolean result = false;
        //TODO Check if world size is good
        if(world.getBlock(pos).getColor()== Colors.VOID){
            result = true;
        }
        return result;
    }

    /**
     * Add value to x Axis
     */
    public void goForward(int val) throws IllegalPositionException {
        for (int i = 0; i < val; i++) {
            Position testPosition = new Position(this.pos.getX()+1, this.pos.getY(), this.pos.getZ());
            if(isVoid(testPosition)){
                this.setPosition(testPosition);
            }else{
                System.out.println("Can't go more forward");
                break;
            }
        }
    }

    /**
     * Reduce value to x Axis
     */
    public void goBackward(int val) throws IllegalPositionException {
        for (int i = 0; i < val; i++) {
            Position testPosition = new Position(this.pos.getX()-1, this.pos.getY(), this.pos.getZ());
            if(isVoid(testPosition)){
                this.setPosition(testPosition);
            }else{
                System.out.println("Can't go more backward");
                break;
            }
        }
    }

    /**
     * Add value to y Axis
     */
    public void goLeft(int val) throws IllegalPositionException {
        for (int i = 0; i < val; i++) {
            Position testPosition = new Position(this.pos.getX(), this.pos.getY()-1, this.pos.getZ());
            if(isVoid(testPosition)){
                this.setPosition(testPosition);
            }else{
                System.out.println("Can't go more left");
                break;
            }
        }
    }

    /**
     * Reduce value to y Axis
     */
    public void goRight(int val) throws IllegalPositionException {
        for (int i = 0; i < val; i++) {
            Position testPosition = new Position(this.pos.getX(), this.pos.getY()+1, this.pos.getZ());
            if(isVoid(testPosition)){
                this.setPosition(testPosition);
            }else{
                System.out.println("Can't go more right");
                break;
            }
        }
    }

    /**
     * Add value to z Axis
     */
    public void goTop(int val) throws IllegalPositionException {
        for (int i = 0; i < val; i++) {
            Position testPosition = new Position(this.pos.getX(), this.pos.getY(), this.pos.getZ()+1);
            if(isVoid(testPosition)){
                this.setPosition(testPosition);
            }else{
                System.out.println("Can't go more top");
                break;
            }
        }
    }

    /**
     * Reduce value to z Axis
     */
    public void goBottom(int val) throws IllegalPositionException {
        for (int i = 0; i < val; i++) {
            Position testPosition = new Position(this.pos.getX(), this.pos.getY(), this.pos.getZ()-1);
            if(isVoid(testPosition)){
                this.setPosition(testPosition);
            }else{
                System.out.println("Can't go more bottom");
                break;
            }
        }
    }

    /**
     * Is equals if same life, damage and world
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return life == entity.life && damages == entity.damages && Objects.equals(world, entity.world);
    }

    @Override
    public String toString() {
        String sb = "World : " + world.getName() +
                "\nID : " + ID +
                "\nLife : " + life +
                "\nDamages : " + damages +
                "\nPosition : " + pos;
        return sb;
    }
}
