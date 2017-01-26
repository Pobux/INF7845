
package farstar;
import java.util.*;

public class Soute {
    final private int capaciteMasse;
    final private int capaciteVolume;
    private int masseCourante;
    private int volumeCourant;
    Map<String, Transportable> elementCharges = new HashMap();
    
    public Soute(int capaciteMasse, int capaciteVolume) {
        this.capaciteMasse = capaciteMasse;
        this.capaciteVolume = capaciteVolume;
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

    public int getVolumeCourant() {
        return volumeCourant;
    }
    
    public void charger(Transportable element) {
        if(peutCharger(element)) {
            elementCharges.put(element.getNom(), element);
        }
    }
    
    public boolean peutCharger(Transportable element) {
        int massePotentielle = masseCourante + element.getMasse();
        int volumePotentiel = volumeCourant + element.getVolume();
        
        return massePotentielle <= capaciteMasse && 
                volumePotentiel <= capaciteVolume;
    }
   
    public void decharger(Transportable element) {
        if(elementCharges.containsKey(element.getNom())) {
            elementCharges.remove(element.getNom());
        }
    }
}
