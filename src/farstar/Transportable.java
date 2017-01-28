package farstar;

abstract class Transportable {
    String nom;
    int volume;
    int masse;
    private TypeProduit type = null;
    
    public Transportable(TypeProduit type, Object[] args) {
        this.type = type;
    }
    
    protected abstract void construire(Object[] args);
    
    public String getNom() {
        return nom;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public TypeProduit getType() {
        return type;
    }
    
    public void setType(TypeProduit type) {
        this.type = type;
    }
    
    public abstract int getMasse();
}
