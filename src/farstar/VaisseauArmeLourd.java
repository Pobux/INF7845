package farstar;

import java.util.*;

public class VaisseauArmeLourd extends VaisseauArme {
    
    public VaisseauArmeLourd(String nom, Object[] args) throws nonConstructionException {
        super(nom, TypeProduit.ARMELEGER);
        construire(args);
    }
    
    public void equiper(Arme arme) {
        if(!elementCharges.containsKey(arme.getNom()) 
                && compterEquipement() < capaciteMaximale ) {
            elementCharges.put(arme.getNom(), arme);
        }
        //TODO gestion des erreurs
    }
    
    public Map<String, Blaster> getListeBlaster() {
        Map<String, Blaster> listeBlaster = new HashMap();
        for (Map.Entry<String, Arme> e : elementCharges.entrySet()) {
            Arme value = e.getValue();
            if(value.getClass() == Blaster.class) {
                listeBlaster.put(nom, (Blaster) value);
            }
        }
        
        return listeBlaster;
    }
     
}


