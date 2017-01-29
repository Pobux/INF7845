package farstar;

public class Farstar {

    public static void main(String[] args) {
        //Creation de différents vaisseau
        //La creation s'insère dans les managers
        //Lors de commande on appelle le manager
        FarStarAPI FA = new FarStarAPI();
        
        VaisseauArmeLeger vaisseauLeger1 = (VaisseauArmeLeger) FA.creer("VC-1", new Object[]{2, 2, 2});
        VaisseauArmeLourd vaisseauLourd1 = (VaisseauArmeLourd) FA.creer("VL-1", new Object[]{2, 2, 2});
        
        Phaser phaser1 = (Phaser) FA.creer("PH-1", new Object[]{1, 1});
        Phaser phaser2 = (Phaser) FA.creer("PH-2", new Object[]{2, 2});
        Phaser phaser3 = (Phaser) FA.creer("PH-3", new Object[]{3, 3});
        
        Blaster blaster1 = (Blaster) FA.creer("BL-1", new Object[]{2, 2, 100, 50});
        Blaster blaster2 = (Blaster) FA.creer("BL-2", new Object[]{2, 2, 50, 50});
        
        Transport transport1 = (Transport) FA.creer("VT-1", new Object[]{100, 100, 300, 300});
        Transport transport2 = (Transport) FA.creer("VT-2", new Object[]{100, 100, 300, 300});
        
        Container container = (Container) FA.creer("CT-1", new Object[]{2,2});
        
        System.out.println("Vaisseau leger 1 : " + vaisseauLeger1.getNom());
        System.out.println("Vaisseau lourd 1 : " + vaisseauLourd1.getNom());
        System.out.println("Transport 1 : " + transport1.getNom());
        System.out.println("Phaser 1 : " + phaser1.getNom());
        System.out.println("Blaster 1 : " + blaster1.getNom());
        System.out.println("Container : " + container.getNom());
    }
    
}
