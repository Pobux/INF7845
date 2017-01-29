package farstar;
import java.util.HashMap;

public class UsineDeLespace {
    public static Transportable creerProduit(String nom, Object[] args) 
            throws nonConstructionException {
        String type = UsineDeLespace.getType(nom);
        switch(type) {
            case "VT": //0
                return new Transport(args);
//            case HYBRIDE: //1
//                return new Hybride(args);
            case "VC": //2
                return new VaisseauArmeLeger(nom, args);
            case "VL": //3
                return new VaisseauArmeLourd(nom, args);
            case "PH": //4
                return new Phaser(nom, args);
            case "BL": //5
                return new Blaster(nom, args);
            case "CT": //6
                return new Container(nom, args);
            default:
                System.out.println("Erreur : Ce type de produit n'existe pas.");
                return null;
                
        }
    }
    
    private static String getType(String nom) {
        return nom.substring(0, 2);
    }
}