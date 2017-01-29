package farstar;

public class Blaster extends Arme {
    int capaciteGaz;
    int gazCourant = 0;
    
    public Blaster(String nom, Object[] args) throws nonConstructionException {
        super(nom, TypeProduit.PHASER);
        construire(args);
    }
    
    @Override
    public void construire(Object[] args) throws nonConstructionException {
        //volume, masse, capacite, gaz courant
        Class[] validation = {Integer.class, Integer.class, Integer.class, Integer.class};
        if(valideArgs(args, validation)) {
            setVolume((int) args[0]);
            setMasse((int) args[1]);
            setGaz((int) args[2], (int) args[3]);
        } else {
            erreurNonConstruction();
        }
    };
    
    public void setGaz(int capaciteGaz, int gazCourant) throws nonConstructionException {
        if(gazCourant > capaciteGaz) {
            erreurNonConstruction("Le gaz courant est supérieur à la capacité du blaster " + getNom());
        }
        
        setCapaciteGaz(capaciteGaz);
        remplir(gazCourant);
    }
    
    public void setCapaciteGaz(int capaciteGaz) {
        this.capaciteGaz = capaciteGaz;
    }
    
    public void remplir(int gaz) {
        gazCourant = gazCourant + gaz;
        if(gazCourant > capaciteGaz) {
            gazCourant = capaciteGaz;
        }
    }
    
    public void remplirPlein() {
        gazCourant = capaciteGaz;
    }
}