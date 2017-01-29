package farstar;

public class Farstar {

    public static void main(String[] args) {
        //Creation de différents vaisseau
        //La creation s'insère dans les managers
        //Lors de commande on appelle le manager
        FarStarAPI FA = new FarStarAPI();
        VaisseauArmeLeger val = (VaisseauArmeLeger) FA.creer("VC-1", new Object[]{2, 2, 2});
        System.out.println(val.getMasse());
    }
    
}
