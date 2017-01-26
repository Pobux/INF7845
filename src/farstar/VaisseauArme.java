package farstar;
import java.util.*;

public abstract class VaisseauArme extends Vaisseau {
    Map<String, Arme> elementCharges = new HashMap();
    protected int capaciteMaximale;
            
    public VaisseauArme(String nom, int masse, int volume, int capaciteMaximale) {
        super(nom, masse, volume);
        this.capaciteMaximale = capaciteMaximale;
    }
    
    public void desequiper(Arme arme) {
        if(elementCharges.containsKey(arme.getNom())) {
            elementCharges.remove(arme.getNom());
        }
        //TODO gestion des erreurs
    }
}
 