package farstar;
import java.util.*;
import java.lang.reflect.Method;

public class Soute {
    private int capaciteMasse;
    private int capaciteVolume;
    private int masseCourante;
    private int volumeRestant;
    Map<String, Transportable> elementCharges = new HashMap();
    Manager DB;
    Vaisseau parent;
    
    public Soute(int capaciteMasse, int capaciteVolume, Vaisseau vaisseau) {
        this.capaciteMasse = capaciteMasse;
        this.capaciteVolume = volumeRestant = capaciteVolume;
        DB = Manager.getInstance();
        parent = vaisseau;
    }

    public int getCapaciteMasse() {
        return capaciteMasse;
    }

    public int getCapaciteVolume() {
        return capaciteVolume;
    }

    public int getMasseCourante() {
        return masseCourante;
    }

    public int getVolumeRestant() {
        return volumeRestant;
    }
    
    public void charger(Transportable element) {
        if(peutCharger(element)) {
            elementCharges.put(element.getNom(), element);
            DB.ajouterProduitPlacer(element);
            volumeRestant = volumeRestant - element.getVolume();
            masseCourante = masseCourante + element.getMasse();
        } else {
            System.out.println("Erreur : Il n'y plus de place pour charger " + element.getNom());
        }
    }
    
    public boolean peutCharger(Transportable element) {
        int massePotentielle = masseCourante + element.getMasse();
        int volumeRestantPotentiel = volumeRestant - element.getVolume();
        
        return massePotentielle <= getCapaciteMasse() && 
                volumeRestantPotentiel >= 0;
    }
   
    public Transportable decharger(String nomElement) {
        if(elementCharges.containsKey(nomElement)) {
            Transportable element = elementCharges.get(nomElement);
            DB.retirerProduitPlacer(element);
            elementCharges.remove(nomElement);
            masseCourante = masseCourante - element.getMasse();
            volumeRestant = volumeRestant + element.getVolume();
            return element;
        } else {
            System.out.println("Erreur : Le produit " + nomElement + " est inexistant");
        }
        
        return null;
    }
    
    public Vaisseau localiser(Transportable element) {
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