package farstar;

public abstract class Transportable {
    public int volume;
    public int masse;
    public String nom;
    
    public Transportable(String nom, int masse, int volume) {
        this.nom = nom;
        this.masse = masse;
        this.volume = volume;
    }
    
    public String getNom() {
        return nom;
    }
    
    abstract public int getMasse();
    
    public int getVolume() {
        return volume;
    }
}
