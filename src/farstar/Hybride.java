package farstar;

import java.util.Map;

public class Hybride extends VaisseauArmeLourd 
        implements Chargeable {
    
    private Soute soute;
    
    Hybride(String nom, Object[] args) throws nonConstructionException {
        super(nom, args);
    }
    
    @Override
    protected void construire(Object[] args) throws nonConstructionException {
        //volume, masse, max arme, capacite soute volume, capacite soute masse
        Class[] validation = {Integer.class, 
                              Integer.class, 
                              Integer.class,
                              Integer.class,
                              Integer.class};
        
        if(valideArgs(args, validation)) {
            setVolume((int) args[0] - (int) args[3]);
            setMasse((int) args[1]);
            setArmeMax((int) args[2]);
            creerSoute((int) args[3], (int) args[4]);
        } else {
            erreurNonConstruction();
        }
        
    };
    
    @Override
    public void creerSoute(int volumeSoute, int masseSoute) {
        soute = new Soute(volumeSoute, masseSoute, this);
    }
    
    @Override
    int getMasse() {
        return super.getMasse() + soute.getMasseCourante();
    }
    
    @Override
    int getVolume() {
        return super.getVolume() + soute.getCapaciteVolume();
    }
    
    @Override
    public void charger(Transportable element) {
        if(soute.peutCharger(element)) {
            soute.charger(element);
        } else {
            System.out.println("Erreur : " + getNom() + " ne peut charger " + element.getNom());
        }
    }
    
    @Override
    public Transportable decharger(String nomElement) {
        return soute.decharger(nomElement);
    }
    
    public int getVolumeRestantSoute() {
        return soute.getVolumeRestant();
    }
    
    public Vaisseau localiser(Transportable element) {
        Vaisseau element_trouve = super.localiser(element);
        if(element_trouve == null) {
            return soute.localiser(element);
        } else {
            return element_trouve;
        }
    }
    
    @Override
    public String toString() {
        String msg = super.toString() + "\nIl reste " + getVolumeRestantSoute() + " "
                + "de volume disponible dans la soute.\nChargement :\n";
        for (Map.Entry<String, Transportable> en : soute.elementCharges.entrySet()) {
            Object key = en.getKey();
            msg += key + "\n";
        }
        
        return msg += "\n";
    }
}
