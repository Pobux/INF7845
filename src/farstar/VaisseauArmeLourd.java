package farstar;

import java.util.*;

public class VaisseauArmeLourd extends VaisseauArme {
    
    public VaisseauArmeLourd(String nom, Object[] args) throws nonConstructionException {
        super(nom, TypeProduit.ARMELOURD);
        construire(args);
    }
    
    public void equiper(Arme arme) {
        if(!elementCharges.containsKey(arme.getNom()) 
                && compterEquipement() < capaciteMaximaleArme ) {
            elementCharges.put(arme.getNom(), arme);
            DB.ajouterProduitPlacer(arme);
        } else {
            capaciteAtteinteErreur();
        }
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


