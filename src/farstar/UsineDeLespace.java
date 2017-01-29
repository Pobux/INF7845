package farstar;
import java.util.HashMap;

public class UsineDeLespace {
    public static Transportable creerProduit(String nom, Object[] args) 
            throws nonConstructionException {
        String type = UsineDeLespace.getType(nom);
        switch(type) {
//            case TRANSPORT: //0
//                return new Transport(args);
//            case HYBRIDE: //1
//                return new Hybride(args);
            case "VC": //2
                return new VaisseauArmeLeger(nom, args);
//            case ARMELOURD: //3
//                return new VaisseauArmeLourd(args);
//            case PHASER: //4
//                return new Phaser(args);
//            case BLASTER: //5
//                return new Blaster(args);
//            case SOUTE://6
//                return new Soute(args);
//            case CONTAINER: //7
//                return new Container(args);
            default:
                System.out.println("Erreur : Ce type de vaisseau n'existe pas");
                return null;
                
        }
    }
    
    private static String getType(String nom) {
        return nom.substring(0, 2);
    }
}