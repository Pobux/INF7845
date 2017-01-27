package farstar;

import java.util.HashMap;
import java.util.Map;

public class VaisseauArmeLourd extends VaisseauArme {
    Map<String, Arme> elementCharges = new HashMap();
    public VaisseauArmeLourd(String nom, int masse, int volume, int capaciteMaximale) {
        super(nom, masse, volume, capaciteMaximale);
    }
    
    public void desequiper(Arme arme) {
        if(elementCharges.containsKey(arme.getNom())) {
            elementCharges.remove(arme.getNom());
        }
        //TODO gestion des erreurs
    }
    
    public int getMasse() {
        int masseTotale = masse;
        for (Map.Entry<String, Arme> e : elementCharges.entrySet()) {
            Arme value = e.getValue();
            masseTotale += value.getMasse();
        }
        
        return masseTotale;
    }
}

