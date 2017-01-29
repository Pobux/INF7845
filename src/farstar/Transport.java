//package farstar;
//
//public final class Transport extends Vaisseau implements Chargeable {
//    private Soute soute;
//    
//    public Transport(String nom, int masse, int volume, Soute soute) {
//        super(nom, masse, volume);
//        setSoute(soute);
//    }
//    
//    @Override
//    public int getMasse() {
//        return masse + soute.getMasseCourante();
//    }
//    
//    @Override
//    public int getVolume() {
//        return volume + soute.getVolumeCourant();
//    }
//    
//    @Override
//    public void setSoute(Soute soute) {
//        this.soute = soute;
//    }
//    
//    @Override
//    public void charger(Transportable element) {
//        if(soute.peutCharger(element)) {
//            soute.charger(element);
//        }
//        //TODO gestion d'erreur
//    }
//}