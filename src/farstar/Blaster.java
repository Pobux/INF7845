package farstar;

public class Blaster extends Arme {
    int capaciteGaz;
    
    public Blaster(String nom, int masse, int volume, int capaciteGaz) {
        super(nom, masse, volume);
        this.capaciteGaz = capaciteGaz;
    }
    
    public void fire() {
        System.out.println("fire blaster");
    }
}
