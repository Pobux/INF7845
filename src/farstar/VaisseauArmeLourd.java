package farstar;

import java.util.HashMap;
import java.util.Map;

public class VaisseauArmeLourd extends VaisseauArme {
    Map<String, Phaser> elementCharges = new HashMap();
    public VaisseauArmeLourd(String nom, int masse, int volume, int capaciteMaximale) {
        super(nom, masse, volume, capaciteMaximale);
    }
    
    public void desequiper(Arme arme) {
        if(elementCharges.containsKey(arme.getNom())) {
            elementCharges.remove(arme.getNom());
        }
        //TODO gestion des erreurs
    }
}

