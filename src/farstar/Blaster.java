package farstar;

public class Blaster extends Arme {
    private int capaciteGaz;
    private int gazCourant;
    
    public Blaster(String nom, int masse, int volume, int capaciteGaz) {
        super(nom, masse, volume);
        this.capaciteGaz = capaciteGaz;
        gazCourant = 0;
    }
    
    public int getGazCourant() {
        return gazCourant;
    }
    
    public double pourcentageGazRestant() {
        return gazCourant / capaciteGaz;
    }
    
    public void recharger() {
        gazCourant = capaciteGaz;
    }
}
