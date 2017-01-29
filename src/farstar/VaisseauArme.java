package farstar;

import java.util.HashMap;
import java.util.Map;

public abstract class VaisseauArme extends Transportable implements Vaisseau {
    protected int capaciteMaximale;
    Map<String, Arme> elementCharges = new HashMap();
    
    public VaisseauArme(String nom, TypeProduit type) {
        super(nom, type); //Même les classes abstraites doivent avoir un constructeur
    }
    
    @Override
    public void construire(Object[] args) throws nonConstructionException {
        //volume, masse, 2 Phaser
        Class[] validation = {Integer.class, Integer.class, Integer.class};
        if(valideArgs(args, validation)) {
            setVolume((int) args[0]);
            setMasse((int) args[1]);
            setArmeMax((int) args[2]);
        } else {
            erreurNonConstruction();
        }
        
    };
    
        
    public void localiser(Transportable element) {
        
    }
    
    public int compterEquipement() {
        return elementCharges.size();
    }
       
    public void desequiper(String armeNom) {
        if(elementCharges.containsKey(armeNom)) {
            elementCharges.remove(armeNom);
        }
        //TODO gestion des erreurs
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
 