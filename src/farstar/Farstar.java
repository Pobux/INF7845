package farstar;

public class Farstar {

    public static void main(String[] args) {
        Vaisseau va = new VaisseauArme("Hello", 23, 23);
        Transportable lol = new Arme("Arme1", 23, 23);
        va.localiser(lol);
    }
    
}
