package farstar;

import java.util.HashMap;
import java.util.Map;

public abstract class VaisseauArme extends Transportable implements Vaisseau {
    protected int capaciteMaximaleArme;
    protected Map<String, Arme> elementCharges = new HashMap();
    Manager DB;
    
    VaisseauArme(String nom, TypeProduit type) {
        super(nom, type); //Même les classes abstraites doivent avoir un constructeur
        DB = Manager.getInstance();
    }
    
    @Override
    protected void construire(Object[] args) throws nonConstructionException {
        //volume, masse, arme
        Class[] validation = {Integer.class, Integer.class, Integer.class};
        if(valideArgs(args, validation)) {
            setVolume((int) args[0]);
            setMasse((int) args[1]);
            setArmeMax((int) args[2]);
        } else {
            erreurNonConstruction();
        }
    };
    
    public Vaisseau localiser(Transportable element) {
        if(elementCharges.containsKey(element.getNom())) {
            return this;
        }
        return null;
    }
    
    Map<String, Arme> getEquipement() {
        return elementCharges;
    }
    
    int compterEquipement() {
        return elementCharges.size();
    }
       
    Arme desequiper(Arme arme) {
        if(elementCharges.containsKey(arme.getNom())) {
            Arme armeRetirer = elementCharges.remove(arme.getNom());
            DB.retirerProduitPlacer(armeRetirer);
            return armeRetirer;
        } else {
            System.out.println("Erreur : " + arme.getNom() + " n'est pas chargé.");
            return null;
        }
    }
    
    @Override
    int getMasse() {
        int masseTotale = masse;
        for (Map.Entry<String, Arme> e : elementCharges.entrySet()) {
            Arme value = e.getValue();
            masseTotale += value.getMasse();
        }
        
        return masseTotale;
    }
    
    void setArmeMax(int max) {
        this.capaciteMaximaleArme = max;
    }
    
    protected void capaciteAtteinteErreur() {
        System.out.println("Erreur : Capacité d'armes atteinte ou arme déjà équipée.");
    }
    
    int getVolume() {
        int volume = this.volume;
 
        for (Map.Entry<String, Arme> entry : elementCharges.entrySet()) {
            Arme value = entry.getValue();
            volume += value.getVolume();
        }

        return volume;
    }

    @Override
    public String toString() {
        String msg = super.toString();
        
        msg += "Armes équipées : \n";
        for (Map.Entry<String, Arme> e : elementCharges.entrySet()) {
            Arme value = e.getValue();
            msg += value.getNom() + "\n";
        }
        
        return msg + "\n";
    }
    
    
}
 