package farstar;

import java.util.HashMap;
import java.util.Map;

public class VaisseauArmeLourd extends VaisseauArme {
    Map<String, Arme> elementCharges = new HashMap();
    public VaisseauArmeLourd(String nom, int masse, int volume, int capaciteMaximale) {
        super(nom, masse, volume, capaciteMaximale);
    }
    
    public void equiper(Phaser arme) {
        if(!elementCharges.containsKey(arme.getNom()) 
                && compterEquipement() < capaciteMaximale ) {
            elementCharges.put(arme.getNom(), arme);
        }
        //TODO gestion des erreurs
    }
        
    @Override
    public void desequiper(String armeNom) {
        if(elementCharges.containsKey(armeNom)) {
            elementCharges.remove(armeNom);
        }
        //TODO gestion des erreurs
    }
    
    @Override
    public int compterEquipement() {
        return elementCharges.size();
    }
    
    @Override
    public int getMasse() {
        int masseTotale = masse;
        for (Map.Entry<String, Arme> e : elementCharges.entrySet()) {
            Arme value = e.getValue();
            masseTotale += value.getMasse();
        }
        
        return masseTotale;
    }
}

