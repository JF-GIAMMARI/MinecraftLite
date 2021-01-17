/**
 * Class name : Main
 * Description : Classe de chargement du jeu
 *
 * @author Jean-François Giammari
 */

public class Main {
    public static void main(String[] args) throws IllegalPositionException {
        System.out.println("\n-> Generation du monde\n");
        World w1 = new World(MapStyle.FLAT, 10, 10, 10);
        System.out.println(w1); // Affichage du monde
        System.out.println("\n\n1. Affichages de la carte & Methodes du mondes\n");
        System.out.println(w1.viewMap());
        // w1.setName(""); // Renommage du monde invalide
        w1.setName("MonMonde"); // Renommage du monde
        System.out.println("\nNouveau nom : " + w1.getName() + "\n "); // Affichage du nouveau

        System.out.println("\n\n2.Ajout de structure (Manuellement, normalement générer au départ)\n");
        Tower t1 = new Tower(new Position(1, 1, 1), 3, 3, 10, Colors.getRandomColor());
        Tower t2 = new Tower(new Position(4, 2, 6), 2, 2, 5, Colors.getRandomColor());
        System.out.println(t1); //Affichage de la structure
        System.out.println(t1.viewBlueprint());
        w1.genStructure(t1); // Ajout au monde de t1
        w1.genStructure(t2); // Ajout au monde de t2
        System.out.println("\nToute les structure :\n" + w1.getAllStructure());
        //System.out.println(w1.getStructureByIndex(2)); // Index invalide
        System.out.println("\nLa structure ID 1 : \n" + w1.getStructureByID(1));
        System.out.println(w1);

        System.out.println("\n\n\n-> Le joueur et le monde");
        //Player p0= new Player(w1,new Position(0,4,2),10,3); // IllegalPositionException
        Player p1 = new Player(w1, new Position(0, 4, 7), 10, 3, "Jeff");
        System.out.println(p1 + "\n");


        System.out.println("\n\n1.Déplacement du joueur \n");
        p1.goBottom(5); // Ne peut descendre que de 3 maximum avant de toucher un bloc (Donc arret a 6)
        System.out.println("Position : " + p1.getPosition() + "\n");
        p1.goTop(2);
        System.out.println("Position (Top+2) : " + p1.getPosition() + "\n");
        p1.goLeft(3);
        System.out.println("Position (Left+3) : " + p1.getPosition() + "\n");
        p1.goRight(1);
        System.out.println("Position (Right+1) : " + p1.getPosition() + "\n");
        p1.goForward(5);
        System.out.println("Position (Front+5) : " + p1.getPosition() + "\n");
        p1.goBackward(3);
        System.out.println("Position (Back+3) : " + p1.getPosition() + "\n");

        System.out.println("\n\n2.Inventaire & Intéraction\n");
        // Joueur views inventaire
        // WOrld . getBlock(Position)
        // Joueur. mineBlock(Position)
        // Joueur views inventaire
        // Joueur. placeBlock(Position)
        // Joueur vies inventaire
        // new Item (Sword)
        // Joueur. addItem

        System.out.println("\n\n\n-> Le joueur et les mobs");
        System.out.println("\n\n1.Affichages & manipulation des statistique\n");
        System.out.println(p1.getStats());
        p1.addLife(4);
        p1.lostDamages(1);
        System.out.println(p1.getStats());
        //p1.setLife(2000); // Invalid value, set to default
        p1.setDamages(5);
        System.out.println(p1.getStats());

        System.out.println("\n\n2.Combats \n");
        Mob m1 = new Mob(w1, new Position(1, 3, 8), 1, 1); // Par défaut ZOMBIE
        System.out.println(m1);
        System.out.println(m1.getStats());
        System.out.println(p1.getStats());
        System.out.println("*Attaque de m1 sur p1*");
        m1.attack(p1);
        System.out.println(p1.getStats());
        System.out.println("*Attaque de p1 sur m1*");
        p1.attack(m1);
        System.out.println(m1.getStats());

        System.out.println("\nNouveau Mob ultra puissant (Type COVID) \n");
        Mob boss = new Mob(w1, new Position(1, 5, 8), 100, 100, MobType.COVID);
        System.out.println(boss + "\n");
        System.out.println(p1);
        System.out.println("\nBoss position :" + boss.getPosition());
        System.out.println("\nDeplacement du Boss de 1 vers la gauche (Rapprochement vers le joueur)");
        boss.goLeft(1);
        System.out.println("\nBoss position : " + boss.getPosition() + "\n");
        boss.attack(p1);

        System.out.println("\nTentative de déplacement du joueur (Voir SERR fin de programme) ");
        p1.goLeft(2);

        System.out.println("\n\n ->Informations sur la partie : \n");
        System.out.println(w1);
        System.out.println("\nNombre de block : " + Block.getNb_block());
        System.out.println("Nombre d'entité : " + Entity.getNb_entity());
        System.out.println("Nombre de joueur : " + Player.getNb_player());
        System.out.println("Nombre de mob : " + Mob.getNb_mobs());

    }
}
