package farstar;

class Arme extends Transportable {
    
    public Arme(String nom, int masse, int volume) {
        super(nom, masse, volume);
    }
    
    public int getMasse() {
        return masse;
    }
    
    public int getVolume() {
        return volume;
    }    
}
