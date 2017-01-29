package farstar;

public class Farstar {

    public static void main(String[] args) {
        //Creation de différents vaisseaux
        //Lors de commande on appelle le manager
        FarStarAPI FA = new FarStarAPI();
        
        VaisseauArmeLeger vaisseauLeger1 = (VaisseauArmeLeger) FA.creer("VC-1", new Object[]{2, 2, 1});
        VaisseauArmeLourd vaisseauLourd1 = (VaisseauArmeLourd) FA.creer("VL-1", new Object[]{2, 2, 2});
        
        Phaser phaser1 = (Phaser) FA.creer("PH-1", new Object[]{1, 1});
        Phaser phaser2 = (Phaser) FA.creer("PH-2", new Object[]{2, 2});
        Arme phaser3 = (Phaser) FA.creer("PH-3", new Object[]{3, 3});
        
        Blaster blaster1 = (Blaster) FA.creer("BL-1", new Object[]{2, 2, 100, 50});
        Arme blaster2 = (Blaster) FA.creer("BL-2", new Object[]{2, 2, 50, 50});
        
        Transport transport1 = (Transport) FA.creer("VT-1", new Object[]{100, 100, 300, 300});
        Transport transport2 = (Transport) FA.creer("VT-2", new Object[]{100, 100, 200, 201});
        Transport transport3 = (Transport) FA.creer("VT-3", new Object[]{100, 101, 200, 200});
        
        Hybride hybride1 = (Hybride) FA.creer("MR-1", new Object[]{20, 20, 3, 100, 100});
        
        Conteneur container = (Conteneur) FA.creer("CT-1", new Object[]{2,200});
        
        System.out.println("Vaisseau leger 1 : " + vaisseauLeger1.getNom());
        System.out.println("Vaisseau lourd 1 : " + vaisseauLourd1.getNom());
        System.out.println("Transport 1 : " + transport1.getNom());
        System.out.println("Hybride 1 : " + hybride1.getNom());
        System.out.println("Phaser 1 : " + phaser1.getNom());
        System.out.println("Blaster 1 : " + blaster1.getNom());
        System.out.println("Container : " + container.getNom());
        
        //Demandes du TP
        vaisseauLeger1.equiper(phaser1);
        System.out.println(vaisseauLeger1.compterEquipement());
        vaisseauLeger1.equiper(phaser2); //Limite atteinte Erreur
        //vaisseauLeger1.equiper(phaser3); //Contravariance bloquée
        Arme phaser1Desequiper = vaisseauLeger1.desequiper(phaser1.getNom());
        System.out.println(phaser1Desequiper.getNom());
        
        transport1.charger(transport2); //erreur
        transport1.charger(transport3); //pas d'erreur la capacite masse est bonne
        System.out.println(transport1.getMasse()); //200
        Transport t3Decharger = (Transport) transport1.decharger(transport3.getNom());
        System.out.println(t3Decharger.getNom()); //VT-3
        System.out.println(transport1.getMasse()); //100
        
        t3Decharger.charger(container);
        System.out.println(t3Decharger.getMasse()); //301
        transport1.charger(t3Decharger); //Maintenant rempli, erreur masse
        
        
    }
    
}
