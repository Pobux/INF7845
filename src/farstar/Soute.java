package farstar;
import java.util.*;

public class Soute {
    private int capaciteMasse;
    private int capaciteVolume;
    Map<String, Transportable> elementCharges = new HashMap();
    Manager DB;
    Vaisseau parent;
    
    Soute(int capaciteVolume, int capaciteMasse, Vaisseau vaisseau) {
        this.capaciteMasse = capaciteMasse;
        this.capaciteVolume = capaciteVolume;
        DB = Manager.getInstance();
        parent = vaisseau;
    }

    int getCapaciteMasse() {
        return capaciteMasse;
    }

    int getCapaciteVolume() {
        return capaciteVolume;
    }

    int getMasseCourante() {
        int masse = 0;
        
        for (Map.Entry<String, Transportable> entry : elementCharges.entrySet()) {
            Transportable value = entry.getValue();
            masse += value.getMasse();
        }
        
        return masse;
    }

    int getVolumeRestant() {
        int volumeCharge = 0;
        
        for (Map.Entry<String, Transportable> entry : elementCharges.entrySet()) {
            Transportable value = entry.getValue();
            volumeCharge += value.getVolume();
        }
        
        return capaciteVolume - volumeCharge;
    }
    
    void charger(Transportable element) {
        if(peutCharger(element)) {
            elementCharges.put(element.getNom(), element);
            DB.ajouterProduitPlacer(element);
        } else {
            System.out.println("Erreur : Il n'y plus de place pour charger " + element.getNom());
        }
    }
    
    boolean peutCharger(Transportable element) {
        int massePotentielle = getMasseCourante() + element.getMasse();
        int volumeRestantPotentiel = getVolumeRestant() - element.getVolume();
        
        if(massePotentielle > getCapaciteMasse()) {
            System.out.println("La capacité maximale de la masse est dépassée.");
            return false;
        }
        
        if(volumeRestantPotentiel < 0) {
            System.out.println("La capacité maximale du volume est dépassée.");
            return false;
        }
        
        return true;
    }
   
    Transportable decharger(String nomElement) {
        if(elementCharges.containsKey(nomElement)) {
            Transportable element = elementCharges.get(nomElement);
            DB.retirerProduitPlacer(element);
            elementCharges.remove(nomElement);
            return element;
        } else {
            System.out.println("Erreur : Le produit " + nomElement + " est inexistant");
        }
        
        return null;
    }
    
    Vaisseau localiser(Transportable element) {
        for (Map.Entry<String, Transportable> e : elementCharges.entrySet()) {
            if(element.getNom().equals(e.getKey())) {
                return parent;
            }        
        }
        
        return localiserEnProfondeur(element);
    }
    
    private Vaisseau localiserEnProfondeur(Transportable element) {
        try {
            //Il faut vérifier si l'élément peut en localiser d'autres
            element.getClass().getMethod("localiser");
            Vaisseau vaisseau = (Vaisseau) element;
            return vaisseau.localiser(element);
        } catch (NoSuchMethodException | SecurityException excep) {
            //Rien ne sert de localiser plus en profondeur
        }
        return null;
    }
}