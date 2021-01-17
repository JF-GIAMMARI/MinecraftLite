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

        p1.openInventory();
        System.out.println("*Ajout d'une feuille de papier a l'inventaire*");
        Item paper = new Item(ItemType.OBJECTS, "Paper");
        Item stick = new Item(ItemType.OBJECTS, "Stick");
        p1.giveItem(paper);
        p1.giveItem(stick);
        p1.openInventory();
        System.out.println("*Suppression de l'item index 1*");
        p1.delItem(1);
        p1.openInventory();

        System.out.println("\nBlock (1,1,5) : " + w1.getBlock(new Position(1, 1, 5)).getColor()); // Affichage du block
        System.out.println("*Minage du block (1,1,5)*");
        p1.mineBlock(new Position(1, 1, 5)); // Minage du block
        System.out.println("Block (1,1,5) : " + w1.getBlock(new Position(1, 1, 5)).getColor()); // Affichage du block
        p1.openInventory();
        System.out.println("\nBlock (1,1,8) : " + w1.getBlock(new Position(1, 1, 8)).getColor()); // Affichage du block
        System.out.println("*Placement du slot 0 de l'inventaire a la position :  (1,1,8) (Voir SERR fin de programme)"); // Slot 0 est un type OBJECTS non placable
        p1.placeBlock(0, new Position(1, 1, 8));
        System.out.println("*Placement du slot 1 de l'inventaire a la position :  (1,1,8)"); // Slot 1 est un type BLOCK, placable
        p1.placeBlock(1, new Position(1, 1, 8));
        System.out.println("Block (1,1,8):  " + w1.getBlock(new Position(1, 1, 8)).getColor()); // Affichage du block
        p1.openInventory();

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

        System.out.println("\n\n->Informations sur la partie : \n");
        System.out.println("Nombre de block : " + Block.getNb_block());
        System.out.println("Nombre d'entité : " + Entity.getNb_entity());
        System.out.println("Nombre de joueur : " + Player.getNb_player());
        System.out.println("Nombre de mob : " + Mob.getNb_mobs());
        System.out.println("Nombre d'inventaire' : " + Inventory.getNb_inventory());
        System.out.println("Le monde : \n");
        System.out.println(w1);

    }
}
