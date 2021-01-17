/**
 * Class name : Main
 * Description : Classe de chargement du jeu
 * @author Jean-François Giammari
 */

public class Main {
    public static void main(String[] args) throws IllegalPositionException {
        System.out.println("\n-> Generation du monde");
        World w1 = new World(MapStyle.FLAT, 10, 10, 10);
        System.out.println(w1); // Affichage du monde
        System.out.println(w1.viewMap());
        // w1.setName(""); // Renommage du monde invalide
        w1.setName("MonMonde"); // Renommage du monde
        System.out.println( "\nNouveau nom : " + w1.getName() + "\n "); // Affichage du nouveau

        // Ajout d'une structure manuellement
        Tower t1 = new Tower(new Position(1,1,1), 3,3,10,Colors.getRandomColor());
        Tower t2 = new Tower(new Position(4,2,6), 2,2,5,Colors.getRandomColor());
        System.out.println(t1); //Affichage de la structure
        System.out.println(t1.viewBlueprint());
        w1.genStructure(t1); // Ajout au monde de t1
        w1.genStructure(t2); // Ajout au monde de t2
        System.out.println("\nToute les structure :\n"+w1.getAllStructure());
        //System.out.println(w1.getStructureByIndex(2)); // Index invalide
        System.out.println("\nLa structure ID 1 : \n"+w1.getStructureByID(1));
        System.out.println(w1);

        System.out.println("\n\n\n-> Le joueur et le monde");
        Player p1 = new Player(w1,new Position(0,4,7),10,3);
        System.out.println(p1+"\n");

        // Déplacement exemple
        p1.goBottom(5); // Ne peut descendre que de 3 maximum avant de toucher un bloc (Donc arret a 6)
        System.out.println("Position : "+ p1.getPosition()+"\n");
        p1.goTop(2);
        System.out.println("Position (Top+2) : "+ p1.getPosition()+"\n");
        p1.goLeft(3);
        System.out.println("Position (Left+3) : "+ p1.getPosition()+"\n");
        p1.goRight(1);
        System.out.println("Position (Right+1) : "+ p1.getPosition()+"\n");
        p1.goForward(5);
        System.out.println("Position (Front+5) : "+ p1.getPosition()+"\n");
        p1.goBackward(3);
        System.out.println("Position (Back+3) : "+ p1.getPosition()+"\n");


        // Joueur get position
        // joueur avancer & droite, et gauche (2)
        // Joueur get position
        // Joueur views inventaire
        // WOrld . getBlock(Position)
        // Joueur. mineBlock(Position)
        // Joueur views inventaire
        // Joueur. placeBlock(Position)
        // Joueur vies inventaire
        // new Item (Sword)
        // Joueur. addItem

        System.out.println("\n\n\n-> Le joueur et les mobs");
        // new Mob
        // Joueur get Position
        // Vie, damamges etc.. die ..
        // World AddEntity (Position, Mob)
        // World. getEntities(id, position, etc...)
        // mob.getstats
        // Joueur.attack(position) // Succes
        // mob.get stat
        // Joueur.getStat
        //mob ; attack (position)
        //Joueur.getSTat






    }
}
