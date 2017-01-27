package farstar;

abstract public class Vaisseau extends Transportable {
    
    public Vaisseau(String nom, int masse, int volume) {
        super(nom, masse, volume);
    }
    
    public void localiser(Transportable element) {
        String typeElement = element.getClass().getSimpleName();
        
        //foreach pour les vaisseaux ici
        
//        switch(typeElement) {
//            case "Arme":
//                //GET LIST VAISSEAU ARME
//                //Localiser en foreach
//            case "Transport":
//                //GET LIST VAISSEAU TRANSPORT
//                //Localiser en foreach
//            case "Container":
//                //GET LIST CONTAINER
//                //Localiser en foreach
//            default:
//                //GET LIST TRANSPORTABLE
//                //Localiser en foreach
//        }
    }
}
