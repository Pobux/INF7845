package farstar;
import java.util.*;

public abstract class VaisseauArme extends Vaisseau {
    protected int capaciteMaximale;
            
    public VaisseauArme(String nom, int masse, int volume, int capaciteMaximale) {
        super(nom, masse, volume);
        this.capaciteMaximale = capaciteMaximale;
    }
}
 