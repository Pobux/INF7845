package farstarapi;

import farstar.Arme;
import farstar.Blaster;
import farstar.Conteneur;
import farstar.FarStarAPI;
import farstar.Hybride;
import farstar.Phaser;
import farstar.Transport;
import farstar.VaisseauArmeLeger;
import farstar.VaisseauArmeLourd;

public class Farstar {

    public static void main(String[] args) {
        FarStarAPI FA = new FarStarAPI();
        
        VaisseauArmeLeger vaisseauLeger1 = (VaisseauArmeLeger) FA.creer("VC-1", new Object[]{10, 50, 2});        
        Phaser phaser1 = (Phaser) FA.creer("PH-1", new Object[]{1, 1});
        Phaser phaser2 = (Phaser) FA.creer("PH-2", new Object[]{1, 1});
        Phaser phaser3 = (Phaser) FA.creer("PH-3", new Object[]{1, 1});
        Phaser phaser4 = (Phaser) FA.creer("PH-4", new Object[]{1, 1});
        
        Blaster blaster1 = (Blaster) FA.creer("BL-1", new Object[]{2, 2, 100, 50});
        Blaster blaster2 = (Blaster) FA.creer("BL-2", new Object[]{2, 2, 100, 50});
        
        Transport transport1 = (Transport) FA.creer("VT-2", new Object[]{100, 100, 90, 300});

        Hybride hybride1 = (Hybride) FA.creer("MR-1", new Object[]{200, 150, 5, 180, 600});
        
        Conteneur container1 = (Conteneur) FA.creer("CT-1", new Object[]{1,1});
        Conteneur container2 = (Conteneur) FA.creer("CT-2", new Object[]{1,1});
        Conteneur container3 = (Conteneur) FA.creer("CT-3", new Object[]{1,1});
        Conteneur container4 = (Conteneur) FA.creer("CT-4", new Object[]{1,1});
        Conteneur container5 = (Conteneur) FA.creer("CT-5", new Object[]{1,1});
        Conteneur container6 = (Conteneur) FA.creer("CT-6", new Object[]{10,100});
        Conteneur container7 = (Conteneur) FA.creer("CT-7", new Object[]{10,100});
        Conteneur container8 = (Conteneur) FA.creer("CT-8", new Object[]{10,100});
        Conteneur container9 = (Conteneur) FA.creer("CT-9", new Object[]{10,100});

        FA.equiperVaisseauLeger(vaisseauLeger1, phaser1);
        FA.equiperVaisseauLeger(vaisseauLeger1, phaser2);

        FA.charger(transport1, container1);
        FA.charger(transport1, container2);
        FA.charger(transport1, container3);
        FA.charger(transport1, container4);
        FA.charger(transport1, container5);
        
        FA.charger(transport1, vaisseauLeger1);
        FA.desequiperVaisseau(vaisseauLeger1, phaser2);
        FA.charger(transport1, phaser2);
        
        FA.equiperVaisseauLourd(hybride1, blaster1);
        FA.equiperVaisseauLourd(hybride1, blaster2);
        FA.equiperVaisseauLourd(hybride1, phaser3);
        FA.equiperVaisseauLourd(hybride1, phaser4);

        FA.charger(hybride1, container6);
        FA.charger(hybride1, container7);
        FA.charger(hybride1, container8);
        FA.charger(hybride1, container9);
        FA.charger(hybride1, transport1);
        System.out.println(transport1);
        System.out.println(hybride1);
        System.out.println(vaisseauLeger1);
        
        FA.localiser(phaser1);
        FA.localiser(phaser2);
        FA.localiser(phaser3);
        FA.localiser(phaser4);
        
        System.out.println(blaster1);
        FA.remplirBlaster("BL-1");
        System.out.println(blaster1);
    }
    
}
