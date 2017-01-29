package farstar;

public final class Hybride extends VaisseauArmeLourd 
        implements Chargeable {
    
    private Soute soute;
    
    public Hybride(String nom, Object[] args) throws nonConstructionException {
        super(nom, args);
    }
    
    @Override
    public void construire(Object[] args) throws nonConstructionException {
        //volume, masse, max arme, capacite soute volume, capacite soute masse
        Class[] validation = {Integer.class, 
                              Integer.class, 
                              Integer.class,
                              Integer.class,
                              Integer.class};
        
        if(valideArgs(args, validation)) {
            setVolume((int) args[0]);
            setMasse((int) args[1]);
            setArmeMax((int) args[2]);
            creerSoute((int) args[3], (int) args[4]);
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
    
    public void charger(Transportable element) {
        if(soute.peutCharger(element)) {
            soute.charger(element);
        }
        //TODO gestion d'erreur
    }
      
    public Transportable decharger(String nomElement) {
        return soute.decharger(nomElement);
    }
    
    public Vaisseau localiser(Transportable element) {
        return null;
    }
    
}
