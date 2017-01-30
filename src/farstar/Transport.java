package farstar;
import java.util.*;

public class Transport extends Transportable implements Chargeable, Vaisseau {
    private Soute soute;
    
    public Transport(String nom, Object[] args)  throws nonConstructionException {
        super(nom, TypeProduit.TRANSPORT);
        construire(args);
    }
    
    @Override
    public void construire(Object[] args) throws nonConstructionException {
        //volume, masse, capacite volume soute, capacite masse soute
        Class[] validation = {Integer.class, Integer.class, Integer.class, Integer.class};
        if(valideArgs(args, validation)) {
            setVolume((int) args[0]);
            setMasse((int) args[1]);
            creerSoute((int) args[2], (int) args[3]);
        } else {
            erreurNonConstruction();
        }  
    };
    
    public void creerSoute(int volumeSoute, int masseSoute) {
        soute = new Soute(volumeSoute, masseSoute, this);
    }
    
    @Override
    public int getMasse() {
        return masse + soute.getMasseCourante();
    }
    
    @Override
    public int getVolume() {
        return volume + soute.getCapaciteVolume();
    }
    
    public int getVolumeRestantSoute() {
        return soute.getVolumeRestant();
    }
    
    public void charger(Transportable element) {
        soute.charger(element);
    }
      
    public Transportable decharger(String nomElement) {
        return soute.decharger(nomElement);
    }
    
    public Vaisseau localiser(Transportable element) {
        return soute.localiser(element);
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