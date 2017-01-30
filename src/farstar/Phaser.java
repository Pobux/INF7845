package farstar;

public class Phaser extends Arme {
    
    Phaser(String nom, Object[] args) throws nonConstructionException {
        super(nom, TypeProduit.PHASER);
        construire(args);
    }
    
    @Override
    protected void construire(Object[] args) throws nonConstructionException {
        //volume, masse
        Class[] validation = {Integer.class, Integer.class};
        if(valideArgs(args, validation)) {
            setVolume((int) args[0]);
            setMasse((int) args[1]);;
        } else {
            erreurNonConstruction();
        }
        
    };
}