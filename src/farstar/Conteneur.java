package farstar;

public class Conteneur extends Transportable {
    
    public Conteneur(String nom, Object[] args) throws nonConstructionException {
        super(nom, TypeProduit.CONTAINER);
        construire(args);
    }
    
    @Override
    public void construire(Object[] args) throws nonConstructionException {
        //volume, masse
        Class[] validation = {Integer.class, Integer.class};
        if(valideArgs(args, validation)) {
            setVolume((int) args[0]);
            setMasse((int) args[1]);
        } else {
            erreurNonConstruction();
        }  
    };
}
