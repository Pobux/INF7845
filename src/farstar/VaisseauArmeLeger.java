package farstar;

import java.util.*;

public class VaisseauArmeLeger extends VaisseauArme {
    
    public VaisseauArmeLeger(String nom, Object[] args) throws nonConstructionException {
        super(TypeProduit.ARMELEGER);

        construire(nom, args);
    }
    
    @Override
    public void construire(String nom, Object[] args) throws nonConstructionException {
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
    
    public void equiper(Phaser arme) {
        if(!elementCharges.containsKey(arme.getNom()) 
                && compterEquipement() < capaciteMaximale ) {
            elementCharges.put(arme.getNom(), arme);
        }
        //TODO gestion des erreurs
    }
    
    @Override
    public int compterEquipement() {
        return elementCharges.size();
    }
    
    @Override
    public void desequiper(String nomArme) {
        if(elementCharges.containsKey(nomArme)) {
            elementCharges.remove(nomArme);
        }
        //TODO gestion des erreurs
    }
}
