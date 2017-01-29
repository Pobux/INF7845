package farstar;

import java.util.HashMap;
import java.util.Map;

public abstract class VaisseauArme extends Transportable implements Vaisseau {
    protected int capaciteMaximale;
    Map<String, Arme> elementCharges = new HashMap();
    
    public VaisseauArme(TypeProduit type) {
        super(type); //Même les classes abstraites doivent avoir un constructeur
    }
    
    public void equiper(Arme arme) {
        if(!elementCharges.containsKey(arme.getNom()) 
                && compterEquipement() < capaciteMaximale ) {
            elementCharges.put(arme.getNom(), arme);
        }
        //TODO gestion des erreurs
    }
        
    public void desequiper(String armeNom) {
        if(elementCharges.containsKey(armeNom)) {
            elementCharges.remove(armeNom);
        }
        //TODO gestion des erreurs
    }
    

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
    
    public void setArmeMax(int max) {
        this.capaciteMaximale = max;
    }
}
 