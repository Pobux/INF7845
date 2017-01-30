package farstar;

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
            setVolume((int) args[0]);
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
        return masse + soute.getMasseCourante();
    }
    
    @Override
    int getVolume() {
        return volume + soute.getCapaciteVolume();
    }
    
    @Override
    public void charger(Transportable element) {
        if(soute.peutCharger(element)) {
            soute.charger(element);
        }
        //TODO gestion d'erreur
    }
    
    @Override
    public Transportable decharger(String nomElement) {
        return soute.decharger(nomElement);
    }
    
}
