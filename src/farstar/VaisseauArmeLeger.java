package farstar;

import java.util.HashMap;
import java.util.Map;

public class VaisseauArmeLeger extends VaisseauArme {
    Map<String, Phaser> elementCharges = new HashMap();
    public VaisseauArmeLeger(String nom, int masse, int volume, int capaciteMaximale) {
        super(nom, masse, volume, capaciteMaximale);
    }
    
    public void desequiper(String nomArme) {
        if(elementCharges.containsKey(nomArme)) {
            elementCharges.remove(nomArme);
        }
        //TODO gestion des erreurs
    }
    
    public int getMasse() {
        int masseTotale = masse;
        for (Map.Entry<String, Phaser> e : elementCharges.entrySet()) {
            Phaser value = e.getValue();
            masseTotale += value.getMasse();
        }
        
        return masseTotale;
    }
}
