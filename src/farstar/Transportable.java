package farstar;

abstract class Transportable {
    String nom;
    int volume;
    int masse;
    private TypeProduit type = null;
    
    public Transportable(TypeProduit type) {
        this.type = type;
    }
    
    protected abstract void construire(String nom, Object[] args) 
            throws nonConstructionException;
    
    
    protected void erreurNonConstruction() throws nonConstructionException {
        throw new nonConstructionException("Erreur : Vous ne pouvez pas construire " + type);
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
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    public TypeProduit getType() {
        return type;
    }
    
    public void setType(TypeProduit type) {
        this.type = type;
    }
    
    public int getMasse() {
        return masse;
    };
    
    public void setMasse(int masse) {
        this.masse = masse;
    }
}
