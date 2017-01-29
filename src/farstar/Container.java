package farstar;

public class Container extends Transportable {
    
    public Container(String nom, Object[] args) throws nonConstructionException {
        super(TypeProduit.CONTAINER);
        construire(nom, args);
    }
    
    @Override
    public void construire(String nom, Object[] args) throws nonConstructionException {
        //volume, masse, 2 Phaser
        Class[] validation = {Integer.class, Integer.class};
        if(valideArgs(args, validation)) {
            setVolume((int) args[0]);
            setMasse((int) args[1]);;
        } else {
            erreurNonConstruction();
        }  
    };
}
