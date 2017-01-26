package farstar;

public final class Transport extends Vaisseau implements Chargeable {
    private Soute soute;
    
    public Transport(String nom, int masse, int volume, Soute soute) {
        super(nom, masse, volume);
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
