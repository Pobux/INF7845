package farstar;

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
        soute = new Soute(volumeSoute, masseSoute);
    }
    
    @Override
    public int getMasse() {
        return masse + soute.getMasseCourante();
    }
    
    @Override
    public int getVolume() {
        return volume + soute.getVolumeCourant();
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
    
    public void localiser(Transportable element) {
        
    }
    
}