/**
 * Class name : Main
 * Description : Classe de chargement du jeu
 * @author Jean-François Giammari
 */

public class Main {
    public static void main(String[] args) {

        // Initialisation des

        // Joueur 1
        System.out.println("\n-> Generation du monde");
        World w1 = new World(MapStyle.FLAT, 10, 10, 10);
        System.out.println(w1); // Affichage du monde
        System.out.println(w1.viewMap());
        // w1.setName(""); // Renommage du monde invalide
        w1.setName("MonMonde"); // Renommage du monde
        System.out.println( "\nNouveau nom : " + w1.getName()); // Affichage du nouveau
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
        System.out.println("========================= \n");


        // Add joueur to w1
        // View World
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

        // new Mob
        // Joueur get Position
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
