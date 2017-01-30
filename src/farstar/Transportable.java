package farstar;

public abstract class Transportable {
    protected String nom;
    protected int volume = 0;
    protected int masse = 0;
    private TypeProduit type = null;
    
    Transportable(String nom, TypeProduit type) {
        this.type = type;
        this.nom = nom;
    }
    
    protected abstract void construire(Object[] args) 
            throws nonConstructionException;
    
    
    protected void erreurNonConstruction() throws nonConstructionException {
        throw new nonConstructionException("Erreur : Vous ne pouvez pas construire " + type + " "
                + "arguments invalide");
    }
    
    protected void erreurNonConstruction(String msg) throws nonConstructionException {
        throw new nonConstructionException(msg);
    }
    
    protected boolean valideArgs(Object[] args, Class[] validations) {
        if(args.length == validations.length) {;
            return matchArgs(args, validations);
        } else {
            return false;
        }
    }
    
    private boolean matchArgs(Object[] args, Class[] validation) {
        for (int i = 0; i < args.length; i++) {
            if(args[i].getClass() != validation[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    
    public String getNom() {
        return nom;
    }
    
    void setNom(String nom) {
        this.nom = nom;
    }
    
    int getVolume() {
        return volume;
    }
    
    void setVolume(int volume) {
        this.volume = volume;
    }
    
    TypeProduit getType() {
        return type;
    }
    
    void setType(TypeProduit type) {
        this.type = type;
    }
    
    int getMasse() {
        return masse;
    };
    
    void setMasse(int masse) {
        this.masse = masse;
    }

    @Override
    public String toString() {
        return "Caractéristique de : " + getNom() + "\nType : " + type + "\n"
                + "Masse : " + getMasse()
                + "\nVolume : " + getVolume()
                + "\n";
    }
    
    
}
