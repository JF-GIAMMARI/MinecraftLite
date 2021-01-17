/**
 * Interface name : Statisticable
 * Description : Interface definissant les statistiques des entitées
 * @author Jean-François Giammari
 */

public interface Statisticable {
    int MINLIFE = 1;
    int MAXLIFE = 100;
    int MINDAMAGE = 0;
    int MAXDAMAGE = 100;
    int DEFAULTLIFE = 10;
    int DEFAULTDAMAGE = 2;

    void setLife(int life);
    int getLife();
    void setDamages(int damages);
    int getDamages();
    void lostLife(int value);
    void addLife(int value);
    void lostDamages(int value);
    void addDamages(int value);
    void Attack(Entity entity);

}
