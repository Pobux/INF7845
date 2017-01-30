package farstar;

public class Blaster extends Arme {
    int capaciteGaz;
    int gazCourant = 0;
    
    Blaster(String nom, Object[] args) throws nonConstructionException {
        super(nom, TypeProduit.BLASTER);
        construire(args);
    }
    
    @Override
    protected void construire(Object[] args) throws nonConstructionException {
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
    
    void setGaz(int capaciteGaz, int gazCourant) throws nonConstructionException {
        if(gazCourant > capaciteGaz) {
            erreurNonConstruction("Le gaz courant est supérieur à la capacité du blaster " + getNom());
        }
        
        setCapaciteGaz(capaciteGaz);
        remplir(gazCourant);
    }
    
    void setCapaciteGaz(int capaciteGaz) {
        this.capaciteGaz = capaciteGaz;
    }
    
    void remplir(int gaz) {
        gazCourant = gazCourant + gaz;
        if(gazCourant > capaciteGaz) {
            gazCourant = capaciteGaz;
        }
    }
    
    void remplirPlein() {
        gazCourant = capaciteGaz;
    }
    
    int getTauxRemplir() {
        return gazCourant / capaciteGaz;
    }

    @Override
    public String toString() {
        String msg = super.toString();
        msg += "Remplit a " + getTauxRemplir() + ".";
        return msg + "\n";
    }
}