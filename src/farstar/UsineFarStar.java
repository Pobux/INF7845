package farstar;
import java.util.HashMap;

public class UsineFarStar {
    public static Transportable creerProduit(String nom, Object[] args) 
            throws nonConstructionException {
        String type = UsineFarStar.getType(nom);
        switch(type) {
            case "VT": //0
                return new Transport(nom, args);
            case "MR": //1
                return new Hybride(nom, args);
            case "VC": //2
                return new VaisseauArmeLeger(nom, args);
            case "VL": //3
                return new VaisseauArmeLourd(nom, args);
            case "PH": //4
                return new Phaser(nom, args);
            case "BL": //5
                return new Blaster(nom, args);
            case "CT": //6
                return new Conteneur(nom, args);
            default:
                throw new nonConstructionException("Ce type de produit n'existe pas");                
        }
    }
    
    private static String getType(String nom) {
        return nom.substring(0, 2);
    }
}