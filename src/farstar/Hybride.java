package farstar;

public final class Hybride extends VaisseauArmeLourd 
        implements Chargeable {
    
    private Soute soute;
    
    public Hybride(String nom, int masse, int volume,  int capaciteMaximale) {
        super(nom, masse, volume, capaciteMaximale);
        setSoute(soute);
    }
    
    @Override
    public void setSoute(Soute soute) {
        if(soute.getCapaciteVolume() < volume 
                && soute.getCapaciteMasse() < masse ) {
            this.soute = soute;
        }
    }
    
    @Override
    public void charger(Transportable element) {
        if(soute.peutCharger(element)) {
            soute.charger(element);
        }
    }
}
