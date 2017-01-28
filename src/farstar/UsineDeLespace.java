package farstar;
import java.util.HashMap;

public class UsineDeLespace {
    public static Transportable createProduct(TypeProduit type, Object[] args) {
        Transportable produit = null;
        switch(type) {
            case TRANSPORT: //0
                return new Transport(args);
            case HYBRIDE: //1
                return new Hybride(args);
            case ARMELEGER: //2
                return new VaisseauArmeLeger(args);
            case ARMELOURD: //3
                return new VaisseauArmeLourd(args);
            case PHASER: //4
                return new Phaser(args);
            case BLASTER: //5
                return new Blaster(args);
            case SOUTE://6
                return new Soute(args);
            case CONTAINER: //7
                return new Container(args);
            default:
                System.out.println("Erreur : Mauvais choix de produit de l'espace.");
                
        }
    }
    
    
}
