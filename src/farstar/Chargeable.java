package farstar;

public interface Chargeable {
    public void charger(Transportable element);
    public Transportable decharger(String nomElement);
    public void creerSoute(int volumeSoute, int masseSoute);
}
